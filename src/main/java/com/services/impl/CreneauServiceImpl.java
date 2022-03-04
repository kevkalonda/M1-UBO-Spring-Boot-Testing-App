package com.services.impl;

import com.dtos.CoursDto;
import com.dtos.CreneauDto;
import com.dtos.Seance_FormationDto;
import com.entities.Cours;
import com.entities.Creneau;
import com.entities.Seance_Formation;
import com.repositories.CreneauRepository;
import com.services.CreneauService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
@Service("creneauService")
public class CreneauServiceImpl implements CreneauService {

    private CreneauRepository creneauRepository;
    public CreneauServiceImpl(CreneauRepository creneauRepository1){
        this.creneauRepository= creneauRepository1;
    }

    protected CreneauServiceImpl (){
    }
    @Override
    public CreneauDto enregistrerCreneau(CreneauDto creneauDto) {
        Creneau creneau = creneauDtoToEntity(creneauDto);
        creneau = this.creneauRepository.save(creneau);
        return creneauEntityToDto(creneau);
    }

    @Override
    public CreneauDto obtenirCreneauParId(Long idCreneau) {
        Creneau creneau= this.creneauRepository.findById(idCreneau).orElseThrow(() -> new EntityNotFoundException("creneau not found"));
        return creneauEntityToDto(creneau);
    }

    @Override
    public boolean supprimerCreneauparId(Long idCreneau) {
        creneauRepository.deleteById(idCreneau);
        return true;
    }

    @Override
    public List<CreneauDto> obtenirTousLesCreneaux() {
        List<CreneauDto> creneauDtoList = new ArrayList<>();
        List<Creneau> creneauList = this.creneauRepository.findAll();
        creneauList.forEach(creneau -> {
            creneauDtoList.add(creneauEntityToDto(creneau));
        });
        return creneauDtoList;
    }
    protected CreneauDto creneauEntityToDto (Creneau creneau){
        CreneauDto creneauDto = new CreneauDto();
        creneauDto.setId(creneau.getId());
        creneauDto.setDate_heure(creneau.getDate_heure());
        creneauDto.setDuree(creneau.getDuree());
        creneauDto.setType(creneau.getType());

        //jointure
        CoursServiceImpl crsSI = new CoursServiceImpl();
        Cours cours = creneau.getCours();
        creneauDto.setCours(crsSI.coursEntityToDto(cours));

        List<Seance_Formation> seance_formations = creneau.getSeanceFormationList();
        List<Seance_FormationDto> seanceFormationDtoList = new ArrayList<>();
        Seance_FormationServiceImpl sfSI = new Seance_FormationServiceImpl();
        for(Seance_Formation seance_formation : seance_formations){
            seanceFormationDtoList.add(sfSI.seanceFormationEntityToDto(seance_formation));
        }
        creneauDto.setSeanceFormationList(seanceFormationDtoList);
        return creneauDto;
    }
    protected Creneau creneauDtoToEntity(CreneauDto creneauDto){
        Creneau creneau = new Creneau();
        creneau.setId(creneauDto.getId());
        creneau.setDate_heure(creneauDto.getDate_heure());
        creneau.setDuree(creneauDto.getDuree());
        creneau.setType(creneauDto.getType());

        CoursServiceImpl crsSI = new CoursServiceImpl();
        CoursDto coursDto = creneauDto.getCours();
        creneau.setCours(crsSI.coursDtoToEntiy(coursDto));

        List<Seance_FormationDto> seanceFormationDtoList = creneauDto.getSeanceFormationList();
        List<Seance_Formation> seance_formations = new ArrayList<>();
        Seance_FormationServiceImpl sfSI = new Seance_FormationServiceImpl();
        for(Seance_FormationDto seance_formationDto : seanceFormationDtoList){
            seance_formations.add(sfSI.seanceFormationDtoToEntity(seance_formationDto));
        }
        creneau.setSeanceFormationList(seance_formations);
        return creneau;
    }
}
