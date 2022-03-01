package com.services;

import com.dtos.GestionnaireDto;

import java.util.List;

public interface GestionnaireService {
    /**
     *Enregistre un utilisateur
     * @param gestionnaireDto
     * @return
     */
    GestionnaireDto enregistrerGestionnaire(GestionnaireDto gestionnaireDto);

    /**
     *La méthode renvoie l'utilisateur dont l'id est passé en paramettre
     * @param idGestionnaire
     * @return
     */
    GestionnaireDto obtenirGestionnaireParId(Long idGestionnaire);

    /**
     *La methode renvoinun booleab si l'utilisateur dont l'id passé en paramettre a été suppimé
     * @param idGestionnaire
     * @return
     */
    boolean supprimerGestionnaireParId(Long idGestionnaire);

    /**
     *Cette méthode retourne tous les Utilisateurs
     * @return
     */
    List<GestionnaireDto> obtenirTousLesGestionnaires();
}
