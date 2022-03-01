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
}
