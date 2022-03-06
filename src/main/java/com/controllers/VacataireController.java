package com.controllers;

import com.dtos.UtilisateurDto;
import com.dtos.VacataireDto;
import com.services.impl.UtilisateurServiceImpl;
import com.services.impl.VacataireServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/vacataire")
public class VacataireController {
    private final VacataireServiceImpl vacataireService;

    /**
     *
     * @param vacataireService
     */
    public VacataireController(VacataireServiceImpl vacataireService){
        this.vacataireService = vacataireService;
    }

    /**
     *
     * @return
     */
    @GetMapping
    public List<VacataireDto> obtenirToutLesVacataire(){
        return  this.vacataireService.obtenirTousLesVacataires();
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public VacataireDto obtenirVacataire(@PathVariable Long id){
        return this.vacataireService.obtenirVacataireParId(id);
    }

    /**
     *
     * @param vacataireDto
     * @return
     */
    @PostMapping
    public VacataireDto enregistrerVacataire(final @RequestBody VacataireDto vacataireDto){
        return this.vacataireService.enregistrerVacataire(vacataireDto);
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean supprimerVacataire(@PathVariable Long id){
        return this.vacataireService.supprimerVacataireParId(id);
    }
}
