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
}
