package com.services;

import com.dtos.ResponsableDto;

import java.util.List;

public interface ResponsableService {
    /**
     *Enregistre un utilisateur
     * @param responsableDto
     * @return
     */
    ResponsableDto enregistrerResponsable(ResponsableDto responsableDto);

    /**
     *La méthode renvoie l'utilisateur dont l'id est passé en paramettre
     * @param idResponsable
     * @return
     */
    ResponsableDto obtenirResponsableParId(Long idResponsable);

    /**
     *La methode renvoinun booleab si l'utilisateur dont l'id passé en paramettre a été suppimé
     * @param idResponsable
     * @return
     */
    boolean supprimerResponsableParId(Long idResponsable);

    /**
     *Cette méthode retourne tous les Utilisateurs
     * @return
     */
    List<ResponsableDto> obtenirTousLesResponsables();
}
