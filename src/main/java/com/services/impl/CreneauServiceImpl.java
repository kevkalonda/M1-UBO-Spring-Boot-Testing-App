package com.services.impl;

import com.dtos.CreneauDto;
import com.entities.Creneau;
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
    private CreneauDto creneauEntityToDto (Creneau creneau){
        return null;
    }
    private Creneau creneauDtoToEntity(CreneauDto creneauDto){
        return null;
    }
}
