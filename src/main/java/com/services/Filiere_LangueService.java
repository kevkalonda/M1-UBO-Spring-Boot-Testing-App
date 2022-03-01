package com.services;

import com.dtos.Filiere_LangueDto;

import java.util.List;

public interface Filiere_LangueService {
    /**
     *Enregistre un utilisateur
     * @param filiere_langueDto
     * @return
     */
    Filiere_LangueDto enregistrerFiliereLangue(Filiere_LangueDto filiere_langueDto);

    /**
     *La méthode renvoie l'utilisateur dont l'id est passé en paramettre
     * @param idFiliereLangue
     * @return
     */
    Filiere_LangueDto obtenirFiliereLangueParId(Long idFiliereLangue);

    /**
     *La methode renvoinun booleab si l'utilisateur dont l'id passé en paramettre a été suppimé
     * @param idFiliereLangue
     * @return
     */
    boolean supprimerFiliereLangueParId(Long idFiliereLangue);

    /**
     *Cette méthode retourne tous les Utilisateurs
     * @return
     */
    List<Filiere_LangueDto> obtenirToutesLesFilieresLangues();
}
