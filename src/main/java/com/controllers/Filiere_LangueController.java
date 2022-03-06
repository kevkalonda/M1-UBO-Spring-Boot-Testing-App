package com.controllers;

import com.dtos.Filiere_LangueDto;
import com.services.impl.Filiere_LangueServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/filiere_langue")
public class Filiere_LangueController {

    private final Filiere_LangueServiceImpl filiere_langueService;
    public Filiere_LangueController(Filiere_LangueServiceImpl filiereLangueService){
        this.filiere_langueService = filiereLangueService;
    }

    /**
     *
     * @return
     */
    @GetMapping
    public List<Filiere_LangueDto> obtenirToutLesFiliere_Langue(){
        return  this.filiere_langueService.obtenirToutesLesFilieresLangues();
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Filiere_LangueDto obtenirFiliere_Langue(@PathVariable Long id){
        return this.filiere_langueService.obtenirFiliereLangueParId(id);
    }

    /**
     *
     * @param filiere_langueDto
     * @return
     */
    @PostMapping
    public Filiere_LangueDto enregistrerFiliere_Langue(final @RequestBody Filiere_LangueDto filiere_langueDto){
        return this.filiere_langueService.enregistrerFiliereLangue(filiere_langueDto);
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean supprimerFiliere_Langue(@PathVariable Long id){
        return this.filiere_langueService.supprimerFiliereLangueParId(id);
    }
}
