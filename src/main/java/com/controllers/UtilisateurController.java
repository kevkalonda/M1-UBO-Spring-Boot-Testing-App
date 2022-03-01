package com.controllers;

import com.dtos.UtilisateurDto;
import com.services.impl.UtilisateurServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {
    private final UtilisateurServiceImpl utilisateurService;
    public UtilisateurController(UtilisateurServiceImpl utilisateurService){
        this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public List<UtilisateurDto> obtenirToutLesUtilisateur(){
        return  this.utilisateurService.obtenirTousLesUtulisateurs();
    }

    @GetMapping("/{id}")
    public UtilisateurDto obtenirUtilisateur(@PathVariable Long id){
        return this.utilisateurService.obtenirUtilisateurParId(id);
    }

    @PostMapping
    public UtilisateurDto enregistrerUtilisateur(final @RequestBody UtilisateurDto responsableDto){
        return this.utilisateurService.enregisterUtilisateur(responsableDto);
    }

    @DeleteMapping("/{id}")
    public boolean supprimerUtilisateur(@PathVariable Long id){
        return this.utilisateurService.supprimerUtilisateurParId(id);
    }
}
