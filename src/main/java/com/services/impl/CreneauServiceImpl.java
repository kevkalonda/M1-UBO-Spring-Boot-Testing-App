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

    @Override
    public CreneauDto enregistrerCreneau(CreneauDto creneauDto) {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        Creneau creneau = mapperService.creneauDtoToEntity(creneauDto);
        creneau = this.creneauRepository.save(creneau);
        return mapperService.creneauEntityToDto(creneau);
    }

    @Override
    public CreneauDto obtenirCreneauParId(Long idCreneau) {
        MapperServiceImpl mapperService = new MapperServiceImpl();

        Creneau creneau= this.creneauRepository.findById(idCreneau).orElseThrow(() -> new EntityNotFoundException("creneau not found"));
        return mapperService.creneauEntityToDto(creneau);
    }

    @Override
    public boolean supprimerCreneauparId(Long idCreneau) {
        creneauRepository.deleteById(idCreneau);
        return true;
    }

    @Override
    public List<CreneauDto> obtenirTousLesCreneaux() {
        MapperServiceImpl mapperService = new MapperServiceImpl();

        List<CreneauDto> creneauDtoList = new ArrayList<>();
        List<Creneau> creneauList = this.creneauRepository.findAll();
        creneauList.forEach(creneau -> {
            creneauDtoList.add(mapperService.creneauEntityToDto(creneau));
        });
        return creneauDtoList;
    }
}
