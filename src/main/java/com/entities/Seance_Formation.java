package com.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Seance_Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    /**
     * association avec la table Vacataire
     */
    @ManyToOne
    private Vacataire effectue_par;

    /**
     * association avec la table Creneau
     */
    @ManyToOne
    private Creneau est_Planifie_sur;

    private int estEffectue;
    private int dureeEffective;
    private String validite;
    private String commentaire;
}
