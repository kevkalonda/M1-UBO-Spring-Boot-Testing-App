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
}
