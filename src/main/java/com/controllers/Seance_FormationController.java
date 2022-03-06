package com.controllers;

import com.dtos.Seance_FormationDto;
import com.services.impl.Seance_FormationServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/seance_formation")
public class Seance_FormationController {
    private final Seance_FormationServiceImpl seance_formationService;
    public Seance_FormationController(Seance_FormationServiceImpl seance_formationService){
        this.seance_formationService = seance_formationService;
    }

    /**
     *
     * @return
     */
    @GetMapping
    public List<Seance_FormationDto> obtenirToutLesSeance_Formation(){
        return  this.seance_formationService.obtenirToutesLesSeancesFormations();
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Seance_FormationDto obtenirSeance_Formation(@PathVariable Long id){
        return this.seance_formationService.obtenirSeanceFormationParId(id);
    }

    /**
     *
     * @param responsableDto
     * @return
     */
    @PostMapping
    public Seance_FormationDto enregistrerSeance_Formation(final @RequestBody Seance_FormationDto responsableDto){
        return this.seance_formationService.enregistrerSeanceFormation(responsableDto);
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean supprimerSeance_Formation(@PathVariable Long id){
        return this.seance_formationService.supprimerSeanceFormationParId(id);
    }
}
