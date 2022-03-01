package com.services;

import com.dtos.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {
    /**
     *Enregistre un utilisateur
     * @param utilisateurDto
     * @return
     */
    UtilisateurDto enregisterUtilisateur(UtilisateurDto utilisateurDto);

    /**
     *La méthode renvoie l'utilisateur dont l'id est passé en paramettre
     * @param idUtilisateur
     * @return
     */
    UtilisateurDto obtenirUtilisateurParId(Long idUtilisateur);

    /**
     *La methode renvoinun booleab si l'utilisateur dont l'id passé en paramettre a été suppimé
     * @param idUtilisateur
     * @return
     */
    boolean supprimerUtilisateurParId(Long idUtilisateur);

    /**
     * Cette méthode retourne tous les Utilisateurs
     * @return
     */
    List<UtilisateurDto> obtenirTousLesUtulisateurs();
}
