package com.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Composante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToOne
    private List<Responsable> responsableList;

    private String nomComposante;

    @OneToMany(mappedBy = "Id")
    private List<Filiere_Langue> filiere_langueList;
}
