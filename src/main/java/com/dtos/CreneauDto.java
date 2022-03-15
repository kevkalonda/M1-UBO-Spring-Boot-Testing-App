package com.dtos;

import lombok.Data;


import java.time.LocalDate;
import java.util.List;

@Data
public class CreneauDto {

    private Long Id;
    private int duree;
    private Type_seanceDto type;
    private LocalDate date_heure;
    private List<Seance_FormationDto> seanceFormationList;
    private CoursDto cours;
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
	public List<Seance_FormationDto> getSeanceFormationList() {
		return seanceFormationList;
	}
	public void setSeanceFormationList(List<Seance_FormationDto> seanceFormationList) {
		this.seanceFormationList = seanceFormationList;
	}
	public CoursDto getCours() {
		return cours;
	}
	public void setCours(CoursDto cours) {
		this.cours = cours;
	}
}
