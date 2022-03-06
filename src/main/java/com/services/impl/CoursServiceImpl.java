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

    @Override
    public CoursDto enregistrerCours(CoursDto coursDto) {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        Cours cours = mapperService.coursDtoToEntiy(coursDto);
        cours = this.coursRepository.save(cours);

        return mapperService.coursEntityToDto(cours);
    }

    @Override
    public CoursDto obtenirCoursParId(Long idCours) {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        Cours cours = this.coursRepository.findById(idCours).orElseThrow(() -> new EntityNotFoundException("cours n'existe pas"));
        return mapperService.coursEntityToDto(cours);
    }

    @Override
    public boolean supprimerCoursParId(Long idCours) {
        this.coursRepository.deleteById(idCours);
        return true;
    }

    @Override
    public List<CoursDto> obtenirTousLesCours() {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        List<CoursDto> coursDtoList = new ArrayList<>();
        List<Cours> coursList = this.coursRepository.findAll();
        coursList.forEach(cours->{
            coursDtoList.add(mapperService.coursEntityToDto(cours));
        });
        return coursDtoList;
    }

}
