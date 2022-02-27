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
    @OneToOne
    private Vacataire effectue_par;

    /**
     * association avec la table Creneau
     */
    @OneToOne
    private Creneau est_Planifie_sur;

    private int estEffectue;
    private int dureeEffective;
    private String validite;
    private String commentaire;
}
