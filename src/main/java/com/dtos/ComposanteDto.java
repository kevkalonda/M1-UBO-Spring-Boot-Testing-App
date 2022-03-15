package com.dtos;

import com.entities.Creneau;
import lombok.Data;

import java.util.List;

@Data
public class ComposanteDto {

    private Long Id;
    private List<ResponsableDto> responsableDtos;
    private String nomComposante;
    private List<Filiere_LangueDto> filiere_langueList;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public List<ResponsableDto> getResponsableDtos() {
		return responsableDtos;
	}
	public void setResponsableDtos(List<ResponsableDto> responsableDtos) {
		this.responsableDtos = responsableDtos;
	}
	public String getNomComposante() {
		return nomComposante;
	}
	public void setNomComposante(String nomComposante) {
		this.nomComposante = nomComposante;
	}
	public List<Filiere_LangueDto> getFiliere_langueList() {
		return filiere_langueList;
	}
	public void setFiliere_langueList(List<Filiere_LangueDto> filiere_langueList) {
		this.filiere_langueList = filiere_langueList;
	}
}
