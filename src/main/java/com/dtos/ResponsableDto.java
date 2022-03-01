package com.dtos;


import lombok.Data;

@Data
public class ResponsableDto extends UtilisateurDto{

    private ComposanteDto est_Rattache_A;

}
