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

    @GetMapping
    public List<CreneauDto> obtenirToutLesCreneau(){
        return  this.creneauService.obtenirTousLesCreneaux();
    }

    @GetMapping("/{id}")
    public CreneauDto obtenirCreneau(@PathVariable Long id){
        return this.creneauService.obtenirCreneauParId(id);
    }

    @PostMapping
    public CreneauDto enregistrerCreneau(final @RequestBody CreneauDto coursDto){
        return this.creneauService.enregistrerCreneau(coursDto);
    }

    @DeleteMapping("/{id}")
    public boolean supprimerCreneau(@PathVariable Long id){
        return this.creneauService.supprimerCreneauparId(id);
    }
}
