package com.controllers;

import com.dtos.Filiere_LangueDto;
import com.dtos.GestionnaireDto;
import com.services.impl.Filiere_LangueServiceImpl;
import com.services.impl.GestionnaireServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/gestionnaire")
public class GestionnaireController {

    private final GestionnaireServiceImpl gestionnaireService;
    public GestionnaireController(GestionnaireServiceImpl gestionnaireService){
        this.gestionnaireService = gestionnaireService;
    }

    /**
     *
     * @return
     */
    @GetMapping
    public List<GestionnaireDto> obtenirToutLesGestionnaire(){
        return  this.gestionnaireService.obtenirTousLesGestionnaires();
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public GestionnaireDto obtenirGestionnaire(@PathVariable Long id){
        return this.gestionnaireService.obtenirGestionnaireParId(id);
    }

    /**
     *
     * @param gestionnaireDto
     * @return
     */
    @PostMapping
    public GestionnaireDto enregistrerGestionnaire(final @RequestBody GestionnaireDto gestionnaireDto){
        return this.gestionnaireService.enregistrerGestionnaire(gestionnaireDto);
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean supprimerGestionnaire(@PathVariable Long id){
        return this.gestionnaireService.supprimerGestionnaireParId(id);
    }
}
