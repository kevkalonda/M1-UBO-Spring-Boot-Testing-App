package com.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Creneau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private int duree;
    private Type_CM type;
    private LocalDate date_heure;
    @OneToMany(mappedBy = "Id")
    private List<Seance_Formation> seanceFormationList;
    @OneToOne
    private Cours cours;
}
