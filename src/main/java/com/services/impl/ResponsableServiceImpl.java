package com.services.impl;

import com.dtos.ComposanteDto;
import com.dtos.ResponsableDto;
import com.entities.Composante;
import com.entities.Responsable;
import com.repositories.ResponsableRepository;
import com.services.ResponsableService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
@Service("responsableService")
public class ResponsableServiceImpl implements ResponsableService {
    private ResponsableRepository responsableRepository;
    public ResponsableServiceImpl(ResponsableRepository responsableRepository1){
        this.responsableRepository=responsableRepository1;
    }
    /**
     * Enregistre un responsable
     *
     * @param responsableDto
     * @return
     */
    @Override
    public ResponsableDto enregistrerResponsable(ResponsableDto responsableDto) {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        Responsable responsable = mapperService.responsableDtoToEntity(responsableDto);
        responsable = this.responsableRepository.save(responsable);
        return mapperService.responsableEntityToDto(responsable);
    }

    /**
     * La méthode renvoie responsable dont l'id est passé en paramettre
     *
     * @param idResponsable
     * @return
     */
    @Override
    public ResponsableDto obtenirResponsableParId(Long idResponsable) {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        Responsable responsable = this.responsableRepository.findById(idResponsable).orElseThrow(() -> new EntityNotFoundException("Responsable not found"));
        return mapperService.responsableEntityToDto(responsable);
    }

    /**
     * La methode renvoinun booleab si responsable dont l'id passé en paramettre a été suppimé
     *
     * @param idResponsable
     * @return
     */
    @Override
    public boolean supprimerResponsableParId(Long idResponsable) {
        this.responsableRepository.deleteById(idResponsable);
        return true;
    }

    /**
     * Cette méthode retourne tous les responsables
     *
     * @return
     */
    @Override
    public List<ResponsableDto> obtenirTousLesResponsables() {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        List<ResponsableDto> responsableDtos = new ArrayList<>();
        List<Responsable> responsables = responsableRepository.findAll();
        if(responsables != null){
            responsables.forEach(responsable -> {
                responsableDtos.add(mapperService.responsableEntityToDto(responsable));
            });
        }
        return responsableDtos;
    }



}
