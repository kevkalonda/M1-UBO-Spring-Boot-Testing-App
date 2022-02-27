package com.dtos;

import com.entities.Creneau;
import com.entities.Vacataire;
import lombok.Data;

import javax.persistence.OneToOne;

@Data

public class Seance_FormationDto {
    private Long Id;
    private VacataireDto effectue_par;
    private CreneauDto est_Planifie_sur;
    private int estEffectue;
    private int dureeEffective;
    private String validite;
    private String commentaire;
}
