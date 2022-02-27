package com.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String intitule;

    @OneToMany(mappedBy = "Id")
    private List<Vacataire> vacataireList;

    @OneToMany(mappedBy = "Id")
    private List<Filiere_Langue> filiere_langueList;

    @OneToMany(mappedBy = "Id")
    private List<Creneau> creneauList;

}
