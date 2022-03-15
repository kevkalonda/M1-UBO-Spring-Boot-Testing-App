package com.dtos;


import lombok.Data;

@Data
public class ResponsableDto extends UtilisateurDto{

    private ComposanteDto est_Rattache_A;

	public ComposanteDto getEst_Rattache_A() {
		return est_Rattache_A;
	}

	public void setEst_Rattache_A(ComposanteDto est_Rattache_A) {
		this.est_Rattache_A = est_Rattache_A;
	}

}
