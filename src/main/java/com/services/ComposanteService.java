package com.services;

import com.dtos.ComposanteDto;

import java.util.List;

public interface ComposanteService {
    /**
     * Enregistrement d' une composante
     * @param composanteDto
     * @return
     */
    ComposanteDto enregistrerComposante(ComposanteDto composanteDto);

    /**
     * Obtenir une composante par son identifiant
     * @param composanteId
     * @return
     */
    ComposanteDto obtenirComposanteParID(Long composanteId );

    /**
     * Supprimer une composante à partir de son identifiant
     * @param composanteId
     * @return
     */
    boolean supprimerComposanteParId(Long composanteId);

    /**
     * Obtenir toutes les composantes
     * @return
     */
    List<ComposanteDto> obtenirToutLesComposantes();
}
