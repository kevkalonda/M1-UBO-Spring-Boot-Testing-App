package com.services.impl;

import com.dtos.CoursDto;
import com.dtos.Seance_FormationDto;
import com.dtos.VacataireDto;
import com.entities.Cours;
import com.entities.Seance_Formation;
import com.entities.Vacataire;
import com.repositories.VacataireRepository;
import com.services.VacataireService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
@Service("vacataireService")
public class VacataireServiceImpl implements VacataireService {

    private VacataireRepository vacataireRepository;
    public VacataireServiceImpl(VacataireRepository vacataireRepository1){
        this.vacataireRepository=vacataireRepository1;
    }

    protected VacataireServiceImpl (){
    }
    /**
     * Enregistrer le vacataire passé en paramettre
     *
     * @param vacataireDto
     * @return
     */
    @Override
    public VacataireDto enregistrerVacataire(VacataireDto vacataireDto) {
        Vacataire vacataire = vacataireDtoToEntity(vacataireDto);
        vacataire = vacataireRepository.save(vacataire);
        return vacataireEntityToDto(vacataire);
    }

    /**
     * La méthode renvoie le vacataire dont l'id est passé en paramettre
     *
     * @param idVacataire
     * @return
     */
    @Override
    public VacataireDto obtenirVacataireParId(Long idVacataire) {
        Vacataire vacataire = this.vacataireRepository.findById(idVacataire).orElseThrow(() -> new EntityNotFoundException("Vacataire not found"));
        return vacataireEntityToDto(vacataire);
    }

    /**
     * La methode renvoinun booleab si le vacataire dont l'id passé en paramettre a été suppimé
     *
     * @param idVacataire
     * @return
     */
    @Override
    public boolean supprimerVacataireParId(Long idVacataire) {
        this.vacataireRepository.deleteById(idVacataire);
        return true;
    }

    /**
     * Cette méthode retourne tous les Vacataires
     *
     * @return
     */
    @Override
    public List<VacataireDto> obtenirTousLesVacataires() {
        List<VacataireDto> vacataireDtos = new ArrayList<>();
        List<Vacataire> vacataires = this.vacataireRepository.findAll();
        vacataires.forEach(vacataire -> {
            vacataireDtos.add(vacataireEntityToDto(vacataire));
        });
        return vacataireDtos;
    }

    protected VacataireDto vacataireEntityToDto(Vacataire vacataire){
        VacataireDto v = new VacataireDto();
        v.setId(vacataire.getId());
        v.setLogin(vacataire.getLogin());
        v.setMotDePasse(vacataire.getMotDePasse());
        v.setPrenom(vacataire.getPrenom());
        v.setNomUsuel(vacataire.getNomUsuel());
        v.setMail(vacataire.getMail());

        //est effectué par une liste de seance formation
        List<Seance_Formation> seance_formations = vacataire.getEffectue();
        List<Seance_FormationDto> formationDtoList = new ArrayList<>();
        Seance_FormationServiceImpl sFSI = new Seance_FormationServiceImpl();
        for(Seance_Formation sf: seance_formations){
            formationDtoList.add(sFSI.seanceFormationEntityToDto(sf));
        }
        v.setEffectue(formationDtoList);

        //participe à 0 ou plusieurs Cours
        List<Cours> coursList = vacataire.getParticipe_A();
        List<CoursDto> coursDtoList = new ArrayList<>();
        CoursServiceImpl cSI = new CoursServiceImpl();
        for(Cours cours : coursList){
            coursDtoList.add(cSI.coursEntityToDto(cours));
        }
        v.setParticipe_A(coursDtoList);

        return v;
    }

    protected Vacataire vacataireDtoToEntity(VacataireDto vacataireDto){
        Vacataire v = new Vacataire();
        v.setId(vacataireDto.getId());
        v.setLogin(vacataireDto.getLogin());
        v.setMotDePasse(vacataireDto.getMotDePasse());
        v.setPrenom(vacataireDto.getPrenom());
        v.setNomUsuel(vacataireDto.getNomUsuel());
        v.setMail(vacataireDto.getMail());

        //est effectué par une liste de seance formation
        List<Seance_FormationDto> seance_formationsDto = vacataireDto.getEffectue();
        List<Seance_Formation> formationList = new ArrayList<>();
        for(Seance_FormationDto sf: seance_formationsDto){
            Seance_FormationServiceImpl sFSI = new Seance_FormationServiceImpl();
            formationList.add(sFSI.seanceFormationDtoToEntity(sf));
        }
        v.setEffectue(formationList);

        //partici pe à 0 ou plusieurs Cours
        List<CoursDto> coursListDto = vacataireDto.getParticipe_A();
        List<Cours> coursList = new ArrayList<>();
        for(CoursDto cours : coursListDto){
            CoursServiceImpl cSI = new CoursServiceImpl();
            coursList.add(cSI.coursDtoToEntiy(cours));
        }
        v.setParticipe_A(coursList);
        return v;
    }
}
