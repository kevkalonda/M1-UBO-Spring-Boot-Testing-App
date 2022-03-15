package com.entities;

import com.dtos.Type_seanceDto;
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
    private Type_seanceDto type;
    private LocalDate date_heure;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Seance_Formation> seanceFormationList;
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn (name="cours",referencedColumnName="Id",nullable=false)
    private Cours cours;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public Type_seanceDto getType() {
		return type;
	}
	public void setType(Type_seanceDto type) {
		this.type = type;
	}
	public LocalDate getDate_heure() {
		return date_heure;
	}
	public void setDate_heure(LocalDate date_heure) {
		this.date_heure = date_heure;
	}
	public List<Seance_Formation> getSeanceFormationList() {
		return seanceFormationList;
	}
	public void setSeanceFormationList(List<Seance_Formation> seanceFormationList) {
		this.seanceFormationList = seanceFormationList;
	}
	public Cours getCours() {
		return cours;
	}
	public void setCours(Cours cours) {
		this.cours = cours;
	}
}
