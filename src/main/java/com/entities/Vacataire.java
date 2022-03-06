package com.entities;

import lombok.Data;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@DiscriminatorColumn(name = "V")
public class Vacataire extends Utilisateur{

    @OneToMany(mappedBy = "Id")
    private List<Seance_Formation> effectue;

    @OneToMany(mappedBy = "Id")
    private List<Cours> participe_A;
}
