package com.entities;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Data
@DiscriminatorColumn(name = "R")
public class Responsable extends Utilisateur{
    /**
     * association avec la table composante
     */
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn (name="est_Rattache_A",referencedColumnName="Id",nullable=false)

    private Composante est_Rattache_A;

	public Composante getEst_Rattache_A() {
		return est_Rattache_A;
	}

	public void setEst_Rattache_A(Composante est_Rattache_A) {
		this.est_Rattache_A = est_Rattache_A;
	}
}
