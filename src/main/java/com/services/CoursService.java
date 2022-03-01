package com.services;

import com.dtos.CoursDto;

import java.util.List;

public interface CoursService {
    /**
     *Enregistre un utilisateur
     * @param coursDto
     * @return
     */
    CoursDto enregistrerCours( CoursDto coursDto);

    /**
     *La méthode renvoie l'utilisateur dont l'id est passé en paramettre
     * @param idCours
     * @return
     */
    CoursDto obtenirCoursParId(Long idCours);

    /**
     *La methode renvoinun booleab si l'utilisateur dont l'id passé en paramettre a été suppimé
     * @param idCours
     * @return
     */
    boolean supprimerCoursParId(Long idCours);

    /**
     *Cette méthode retourne tous les Utilisateurs
     * @return
     */
    List<CoursDto> obtenirTousLesCours();
}
