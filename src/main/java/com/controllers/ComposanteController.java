package com.controllers;

import com.dtos.ComposanteDto;
import com.services.impl.ComposanteServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/composantes")
public class ComposanteController {

    private final ComposanteServiceImpl composanteService;
    public ComposanteController(ComposanteServiceImpl composanteService){
        this.composanteService = composanteService;
    }

    /**
     *
     * @return
     */
    @GetMapping
    public List<ComposanteDto> obtenirToutLesComposantes(){
        return  this.composanteService.obtenirToutLesComposantes();
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ComposanteDto obtenirComposante(@PathVariable Long id){
        return this.composanteService.obtenirComposanteParID(id);
    }

    /**
     *
     * @param composanteDto
     * @return
     */
    @PostMapping
    public ComposanteDto enregistrerComposante(final @RequestBody ComposanteDto composanteDto){
        return this.composanteService.enregistrerComposante(composanteDto);
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean supprimerComposante(@PathVariable Long id){
        return this.composanteService.supprimerComposanteParId(id);
    }
}
