package com.entities;

import lombok.Data;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@DiscriminatorColumn(name = "G")
public class Gestionnaire extends Utilisateur{

}
