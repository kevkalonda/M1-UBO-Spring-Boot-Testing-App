package com.services;

import com.dtos.Seance_FormationDto;

import java.util.List;

public interface Seance_FormationService {
    /**
     *Enregistre un utilisateur
     * @param seance_formationDto
     * @return
     */
    Seance_FormationDto enregistrerSeanceFormation(Seance_FormationDto seance_formationDto);

    /**
     *La méthode renvoie l'utilisateur dont l'id est passé en paramettre
     * @param idSeanceFormation
     * @return
     */
    Seance_FormationDto obtenirSeanceFormationParId(Long idSeanceFormation);

    /**
     *La methode renvoinun booleab si l'utilisateur dont l'id passé en paramettre a été suppimé
     * @param idSeanceFormatio
     * @return
     */
    boolean supprimerSeanceFormationParId(Long idSeanceFormatio);

    /**
     *Cette méthode retourne tous les Utilisateurs
     * @return
     */
    List<Seance_FormationDto> obtenirToutesLesSeancesFormations();
}
