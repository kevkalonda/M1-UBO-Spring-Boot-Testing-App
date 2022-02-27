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
}
