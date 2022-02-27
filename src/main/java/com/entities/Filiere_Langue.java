package com.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Filiere_Langue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String codeFiliereLangue;
    private String nomFiliereLangue;
    /**
     * association avec la table composante
     */
    @OneToOne
    private Composante depend_De;

    /**
     * association avec la table cours
     */
    @OneToMany(mappedBy = "Id")
    private List<Cours> coursList;
}
