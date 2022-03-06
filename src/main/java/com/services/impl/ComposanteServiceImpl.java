package com.services.impl;

import com.dtos.ComposanteDto;
import com.dtos.Filiere_LangueDto;
import com.dtos.ResponsableDto;
import com.entities.Composante;
import com.entities.Filiere_Langue;
import com.entities.Responsable;
import com.repositories.ComposanteRepository;
import com.services.ComposanteService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("composanteService")
public class ComposanteServiceImpl implements ComposanteService {

    private ComposanteRepository composanteRepository;
    public ComposanteServiceImpl(ComposanteRepository composanteRepos){
        this.composanteRepository= composanteRepos;
    }

    @Override
    public ComposanteDto enregistrerComposante(ComposanteDto composanteDto) {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        //conversion de Dto à l'entité
        Composante composante = mapperService.composanteDtoToEntity(composanteDto);
        //enregistrement de l'entité
        composante = this.composanteRepository.save(composante);
        //on return une nouvelle composanteDto
        return mapperService.composanteEntityToDto(composante);
    }

    @Override
    public ComposanteDto obtenirComposanteParID(Long composanteId) {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        Composante composante = this.composanteRepository.findById(composanteId).orElseThrow(() -> new EntityNotFoundException("composante n'existe pas"));
        return mapperService.composanteEntityToDto(composante);
    }

    @Override
    public boolean supprimerComposanteParId(Long composanteId) {
        this.composanteRepository.deleteById(composanteId);
        return true;
    }

    @Override
    public List<ComposanteDto> obtenirToutLesComposantes() {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        List<ComposanteDto> composanteDtoList = new ArrayList<>();
        List<Composante> composanteList = this.composanteRepository.findAll();
        composanteList.forEach(composante -> {
            composanteDtoList.add(mapperService.composanteEntityToDto(composante));
        });
        return composanteDtoList;
    }

}
