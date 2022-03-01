package com.services;

import com.dtos.ResponsableDto;
import com.dtos.VacataireDto;

import java.util.List;

public interface VacataireService {
    /**
     * Enregistrer le vacataire passé en paramettre
     * @param vacataireDto
     * @return
     */
    VacataireDto enregistrerVacataire(VacataireDto vacataireDto);

    /**
     * La méthode renvoie le vacataire dont l'id est passé en paramettre
     * @param idVacataire
     * @return
     */
    VacataireDto obtenirVacataireParId(Long idVacataire);

    /**
     * La methode renvoinun booleab si le vacataire dont l'id passé en paramettre a été suppimé
     * @param idVacataire
     * @return
     */
    boolean supprimerVacataireParId(Long idVacataire);

    /**
     * Cette méthode retourne tous les Vacataires
     * @return
     */
    List<VacataireDto> obtenirTousLesVacataires();
}
