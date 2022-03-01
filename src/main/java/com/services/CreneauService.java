package com.services;

import com.dtos.CreneauDto;

import java.util.List;

public interface CreneauService {
    /**
     *Enregistre un utilisateur
     * @param creneauDto
     * @return
     */
    CreneauDto enregistrerCreneau( CreneauDto creneauDto);

    /**
     *La méthode renvoie l'utilisateur dont l'id est passé en paramettre
     * @param idCreneau
     * @return
     */
    CreneauDto obtenirCreneauParId(Long idCreneau);

    /**
     *La methode renvoinun booleab si l'utilisateur dont l'id passé en paramettre a été suppimé
     * @param idCreneau
     * @return
     */
    boolean supprimerCreneauparId(Long idCreneau);

    /**
     *Cette méthode retourne tous les Utilisateurs
     * @return
     */
    List<CreneauDto> obtenirTousLesCreneaux();
}
