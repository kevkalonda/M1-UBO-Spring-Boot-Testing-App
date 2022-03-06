package com.services.impl;

import com.dtos.ComposanteDto;
import com.dtos.CoursDto;
import com.dtos.Filiere_LangueDto;
import com.entities.Composante;
import com.entities.Cours;
import com.entities.Filiere_Langue;
import com.repositories.Filiere_LangueRepository;
import com.services.Filiere_LangueService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
@Service("filiere_LangueService")
public class Filiere_LangueServiceImpl implements Filiere_LangueService {

    private Filiere_LangueRepository filiereLangueRepository;
    public Filiere_LangueServiceImpl(Filiere_LangueRepository filiereLangueRepository1){
        this.filiereLangueRepository=filiereLangueRepository1;
    }

    @Override
    public Filiere_LangueDto enregistrerFiliereLangue(Filiere_LangueDto filiere_langueDto) {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        Filiere_Langue filiere_langue = mapperService.filiere_langueDtoToEntity(filiere_langueDto);
        filiere_langue = this.filiereLangueRepository.save(filiere_langue);
        return mapperService.filiere_langueEntityToDto(filiere_langue);
    }

    @Override
    public Filiere_LangueDto obtenirFiliereLangueParId(Long idFiliereLangue) {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        Filiere_Langue filiere_langue = this.filiereLangueRepository.findById(idFiliereLangue).orElseThrow(() -> new EntityNotFoundException("Filiere not found"));
        return mapperService.filiere_langueEntityToDto(filiere_langue);
    }

    @Override
    public boolean supprimerFiliereLangueParId(Long idFiliereLangue) {
        this.filiereLangueRepository.deleteById(idFiliereLangue);
        return true;
    }

    @Override
    public List<Filiere_LangueDto> obtenirToutesLesFilieresLangues() {
        MapperServiceImpl mapperService = new MapperServiceImpl();

        List<Filiere_LangueDto> filiere_langueDtos = new ArrayList<>();
        List<Filiere_Langue> filiere_langueList = this.filiereLangueRepository.findAll();
        filiere_langueList.forEach(filiere_langue -> {
            filiere_langueDtos.add(mapperService.filiere_langueEntityToDto(filiere_langue));
        });
        return filiere_langueDtos;
    }

}
