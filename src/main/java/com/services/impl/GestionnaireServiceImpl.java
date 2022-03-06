package com.services.impl;

import com.dtos.GestionnaireDto;
import com.entities.Gestionnaire;
import com.repositories.GestionnaireRepository;
import com.services.GestionnaireService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
@Service("gestionnaireService")
public class GestionnaireServiceImpl implements GestionnaireService {

    private GestionnaireRepository gestionnaireRepository;
    public GestionnaireServiceImpl(GestionnaireRepository gestionnaireRepository1){
        this.gestionnaireRepository=gestionnaireRepository1;
    }

    /**
     * Enregistre un gestionnaire
     *
     * @param gestionnaireDto
     * @return
     */
    @Override
    public GestionnaireDto enregistrerGestionnaire(GestionnaireDto gestionnaireDto) {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        Gestionnaire gestionnaire = mapperService.gestionnaireDtoToEntity(gestionnaireDto);
        gestionnaire = this.gestionnaireRepository.save(gestionnaire);
        return mapperService.gestionnaireEntityToDto(gestionnaire);
    }

    /**
     * La méthode renvoie l'gestionnaire dont l'id est passé en paramettre
     *
     * @param idGestionnaire
     * @return
     */
    @Override
    public GestionnaireDto obtenirGestionnaireParId(Long idGestionnaire) {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        Gestionnaire gestionnaire = this.gestionnaireRepository.findById(idGestionnaire).orElseThrow(() -> new EntityNotFoundException("Gestionnaire not found"));
        return mapperService.gestionnaireEntityToDto(gestionnaire);
    }

    /**
     * La methode renvoinun booleab si l'gestionnaire dont l'id passé en paramettre a été suppimé
     *
     * @param idGestionnaire
     * @return
     */
    @Override
    public boolean supprimerGestionnaireParId(Long idGestionnaire) {
        this.gestionnaireRepository.deleteById(idGestionnaire);
        return true;
    }

    /**
     * Cette méthode retourne tous les gestionnaires
     *
     * @return
     */
    @Override
    public List<GestionnaireDto> obtenirTousLesGestionnaires() {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        List<GestionnaireDto> gestionnaireDtoList = new ArrayList<>();
        List<Gestionnaire> gestionnaires = this.gestionnaireRepository.findAll();
        gestionnaires.forEach(gestionnaire -> {
            gestionnaireDtoList.add(mapperService.gestionnaireEntityToDto(gestionnaire));
        });
        return gestionnaireDtoList;
    }



}
