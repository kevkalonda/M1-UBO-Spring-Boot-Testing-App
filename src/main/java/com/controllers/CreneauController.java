package com.controllers;

import com.dtos.CreneauDto;
import com.services.impl.CreneauServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/creneau")
public class CreneauController {

    private final CreneauServiceImpl creneauService;
    public CreneauController(CreneauServiceImpl creneauService){
        this.creneauService = creneauService;
    }

    /**
     *
     * @return
     */
    @GetMapping
    public List<CreneauDto> obtenirToutLesCreneau(){
        return  this.creneauService.obtenirTousLesCreneaux();
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public CreneauDto obtenirCreneau(@PathVariable Long id){
        return this.creneauService.obtenirCreneauParId(id);
    }

    /**
     *
     * @param coursDto
     * @return
     */
    @PostMapping
    public CreneauDto enregistrerCreneau(final @RequestBody CreneauDto coursDto){
        return this.creneauService.enregistrerCreneau(coursDto);
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean supprimerCreneau(@PathVariable Long id){
        return this.creneauService.supprimerCreneauparId(id);
    }
}
