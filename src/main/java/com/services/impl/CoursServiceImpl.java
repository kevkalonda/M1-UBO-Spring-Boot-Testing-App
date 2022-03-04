package com.services.impl;

import com.dtos.*;
import com.entities.*;
import com.repositories.CoursRepository;
import com.services.CoursService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
@Service("coursService")
public class CoursServiceImpl implements CoursService {
    private CoursRepository coursRepository;
    public CoursServiceImpl(CoursRepository coursRepository1){
        this.coursRepository= coursRepository1;
    }

    protected CoursServiceImpl (){

    }
    @Override
    public CoursDto enregistrerCours(CoursDto coursDto) {
        Cours cours = this.coursDtoToEntiy(coursDto);
        cours = this.coursRepository.save(cours);

        return coursEntityToDto(cours);
    }

    @Override
    public CoursDto obtenirCoursParId(Long idCours) {
        Cours cours = this.coursRepository.findById(idCours).orElseThrow(() -> new EntityNotFoundException("cours n'existe pas"));
        return coursEntityToDto(cours);
    }

    @Override
    public boolean supprimerCoursParId(Long idCours) {
        this.coursRepository.deleteById(idCours);
        return true;
    }

    @Override
    public List<CoursDto> obtenirTousLesCours() {
        List<CoursDto> coursDtoList = new ArrayList<>();
        List<Cours> coursList = this.coursRepository.findAll();
        coursList.forEach(cours->{
            coursDtoList.add(this.coursEntityToDto(cours));
        });
        return coursDtoList;
    }
    protected CoursDto coursEntityToDto(Cours cours){

        CoursDto coursDto = new  CoursDto();
        coursDto.setId(cours.getId());
        coursDto.setIntitule(cours.getIntitule());

        List<Creneau> creneauList = cours.getCreneauList();
        List<CreneauDto> creneauDtoList  = new ArrayList<>();
        CreneauServiceImpl crnSI = new CreneauServiceImpl();
        for(Creneau creneau: creneauList){
            creneauDtoList.add(crnSI.creneauEntityToDto(creneau));
        }
        coursDto.setCreneauList(creneauDtoList);

        List<Vacataire> vacataireList = cours.getVacataireList();
        List<VacataireDto> vacataireDtoList = new ArrayList<>();
        VacataireServiceImpl vSI = new VacataireServiceImpl();
        for(Vacataire vacataire : vacataireList){
            vacataireDtoList.add(vSI.vacataireEntityToDto(vacataire));
        }
        coursDto.setVacataireList(vacataireDtoList);

        List<Filiere_Langue> filiere_langueList = cours.getFiliere_langueList();
        List<Filiere_LangueDto> filiere_langueDtos = new ArrayList<>();
        Filiere_LangueServiceImpl flSI = new Filiere_LangueServiceImpl();
        for (Filiere_Langue filiere_langue : filiere_langueList){
            filiere_langueDtos.add(flSI.filiere_langueEntityToDto(filiere_langue));
        }
        coursDto.setFiliere_langueList(filiere_langueDtos);
        return coursDto;
    }
    protected Cours coursDtoToEntiy(CoursDto coursDto){
        Cours cours =new Cours();
        cours.setId(coursDto.getId());
        cours.setIntitule(coursDto.getIntitule());

        List<CreneauDto> creneauDtoList = coursDto.getCreneauList();
        List<Creneau> creneauList = new ArrayList<>();
        CreneauServiceImpl crnSI = new CreneauServiceImpl();
        for(CreneauDto creneauDto : creneauDtoList){
            creneauList.add(crnSI.creneauDtoToEntity(creneauDto));
        }
        cours.setCreneauList(creneauList);

        List<VacataireDto> vacataireDtos = coursDto.getVacataireList();
        List<Vacataire> vacataires = new ArrayList<>();
        VacataireServiceImpl vacSI = new VacataireServiceImpl();
        for(VacataireDto vacataireDto : vacataireDtos){
            vacataires.add(vacSI.vacataireDtoToEntity(vacataireDto));
        }
        cours.setVacataireList(vacataires);

        List<Filiere_LangueDto> filiere_langueDtos = coursDto.getFiliere_langueList();
        List<Filiere_Langue> filiere_langueList = new ArrayList<>();
        Filiere_LangueServiceImpl flSI = new Filiere_LangueServiceImpl();
        for(Filiere_LangueDto filiere_langueDto: filiere_langueDtos){
            filiere_langueList.add(flSI.filiere_langueDtoToEntity(filiere_langueDto));
        }
        cours.setFiliere_langueList(filiere_langueList);
        return cours;
    }
}
