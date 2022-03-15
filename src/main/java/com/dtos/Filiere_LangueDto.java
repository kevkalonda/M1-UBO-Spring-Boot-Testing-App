package com.dtos;

import lombok.Data;


import java.util.List;

@Data
public class Filiere_LangueDto {
    private Long Id;
    private String codeFiliereLangue;
    private String nomFiliereLangue;
    private ComposanteDto depend_De;
    private List<CoursDto> coursList;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getCodeFiliereLangue() {
		return codeFiliereLangue;
	}
	public void setCodeFiliereLangue(String codeFiliereLangue) {
		this.codeFiliereLangue = codeFiliereLangue;
	}
	public String getNomFiliereLangue() {
		return nomFiliereLangue;
	}
	public void setNomFiliereLangue(String nomFiliereLangue) {
		this.nomFiliereLangue = nomFiliereLangue;
	}
	public ComposanteDto getDepend_De() {
		return depend_De;
	}
	public void setDepend_De(ComposanteDto depend_De) {
		this.depend_De = depend_De;
	}
	public List<CoursDto> getCoursList() {
		return coursList;
	}
	public void setCoursList(List<CoursDto> coursList) {
		this.coursList = coursList;
	}
}
