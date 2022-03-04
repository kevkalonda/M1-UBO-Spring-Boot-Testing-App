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

    protected GestionnaireServiceImpl (){
    }
    /**
     * Enregistre un utilisateur
     *
     * @param gestionnaireDto
     * @return
     */
    @Override
    public GestionnaireDto enregistrerGestionnaire(GestionnaireDto gestionnaireDto) {
        Gestionnaire gestionnaire = this.gestionnaireDtoToEntity(gestionnaireDto);
        gestionnaire = this.gestionnaireRepository.save(gestionnaire);
        return gestionnaireEntityToDto(gestionnaire);
    }

    /**
     * La méthode renvoie l'utilisateur dont l'id est passé en paramettre
     *
     * @param idGestionnaire
     * @return
     */
    @Override
    public GestionnaireDto obtenirGestionnaireParId(Long idGestionnaire) {
        Gestionnaire gestionnaire = this.gestionnaireRepository.findById(idGestionnaire).orElseThrow(() -> new EntityNotFoundException("Gestionnaire not found"));
        return gestionnaireEntityToDto(gestionnaire);
    }

    /**
     * La methode renvoinun booleab si l'utilisateur dont l'id passé en paramettre a été suppimé
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
     * Cette méthode retourne tous les Utilisateurs
     *
     * @return
     */
    @Override
    public List<GestionnaireDto> obtenirTousLesGestionnaires() {
        List<GestionnaireDto> gestionnaireDtoList = new ArrayList<>();
        List<Gestionnaire> gestionnaires = this.gestionnaireRepository.findAll();
        gestionnaires.forEach(gestionnaire -> {
            gestionnaireDtoList.add(gestionnaireEntityToDto(gestionnaire));
        });
        return gestionnaireDtoList;
    }
    private Gestionnaire gestionnaireDtoToEntity(GestionnaireDto gestionnaireDto){
        Gestionnaire gestionnaire = new Gestionnaire();
        gestionnaire.setId(gestionnaireDto.getId());
        gestionnaire.setLogin(gestionnaireDto.getLogin());
        gestionnaire.setMail(gestionnaireDto.getMail());
        gestionnaire.setPrenom(gestionnaireDto.getPrenom());
        gestionnaire.setNomUsuel(gestionnaireDto.getNomUsuel());
        gestionnaire.setMotDePasse(gestionnaireDto.getMotDePasse());
        return gestionnaire;
    }

    private GestionnaireDto gestionnaireEntityToDto(Gestionnaire gestionnaire){
        GestionnaireDto gestionnaireDto = new GestionnaireDto();
        gestionnaireDto.setId(gestionnaire.getId());
        gestionnaireDto.setLogin(gestionnaire.getLogin());
        gestionnaireDto.setMail(gestionnaire.getMail());
        gestionnaireDto.setPrenom(gestionnaire.getPrenom());
        gestionnaireDto.setNomUsuel(gestionnaire.getNomUsuel());
        gestionnaireDto.setMotDePasse(gestionnaire.getMotDePasse());
        return gestionnaireDto;
    }
}
