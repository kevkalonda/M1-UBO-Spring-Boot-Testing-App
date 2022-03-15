package com.dtos;

import lombok.Data;

import java.util.List;

@Data
public class CoursDto {
    private Long Id;
    private String intitule;
    private List<VacataireDto> vacataireList;
    private List<Filiere_LangueDto> filiere_langueList;
    private List<CreneauDto> creneauList;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public List<VacataireDto> getVacataireList() {
		return vacataireList;
	}
	public void setVacataireList(List<VacataireDto> vacataireList) {
		this.vacataireList = vacataireList;
	}
	public List<Filiere_LangueDto> getFiliere_langueList() {
		return filiere_langueList;
	}
	public void setFiliere_langueList(List<Filiere_LangueDto> filiere_langueList) {
		this.filiere_langueList = filiere_langueList;
	}
	public List<CreneauDto> getCreneauList() {
		return creneauList;
	}
	public void setCreneauList(List<CreneauDto> creneauList) {
		this.creneauList = creneauList;
	}
}
