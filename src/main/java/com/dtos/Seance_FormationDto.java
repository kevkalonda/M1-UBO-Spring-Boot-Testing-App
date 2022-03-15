package com.dtos;

import com.entities.Creneau;
import com.entities.Vacataire;
import lombok.Data;

import javax.persistence.OneToOne;

@Data

public class Seance_FormationDto {
    private Long Id;
    private VacataireDto effectue_par;
    private CreneauDto est_Planifie_sur;
    private int estEffectue;
    private int dureeEffective;
    private String validite;
    private String commentaire;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public VacataireDto getEffectue_par() {
		return effectue_par;
	}
	public void setEffectue_par(VacataireDto effectue_par) {
		this.effectue_par = effectue_par;
	}
	public CreneauDto getEst_Planifie_sur() {
		return est_Planifie_sur;
	}
	public void setEst_Planifie_sur(CreneauDto est_Planifie_sur) {
		this.est_Planifie_sur = est_Planifie_sur;
	}
	public int getEstEffectue() {
		return estEffectue;
	}
	public void setEstEffectue(int estEffectue) {
		this.estEffectue = estEffectue;
	}
	public int getDureeEffective() {
		return dureeEffective;
	}
	public void setDureeEffective(int dureeEffective) {
		this.dureeEffective = dureeEffective;
	}
	public String getValidite() {
		return validite;
	}
	public void setValidite(String validite) {
		this.validite = validite;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
}
