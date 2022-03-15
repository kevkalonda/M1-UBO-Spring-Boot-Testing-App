package com.dtos;

import com.entities.Cours;
import com.entities.Seance_Formation;
import lombok.Data;

import javax.persistence.OneToMany;
import java.util.List;

@Data
public class VacataireDto extends UtilisateurDto{

    private List<Seance_FormationDto> effectue;
    private List<CoursDto> participe_A;
	public List<Seance_FormationDto> getEffectue() {
		return effectue;
	}
	public void setEffectue(List<Seance_FormationDto> effectue) {
		this.effectue = effectue;
	}
	public List<CoursDto> getParticipe_A() {
		return participe_A;
	}
	public void setParticipe_A(List<CoursDto> participe_A) {
		this.participe_A = participe_A;
	}
}
