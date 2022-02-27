package com.dtos;

import com.entities.Creneau;
import lombok.Data;

import java.util.List;

@Data
public class ComposanteDto {

    private Long Id;
    private ResponsableDto responsable;
    private String nomComposante;
    private List<Filiere_LangueDto> filiere_langueList;
}
