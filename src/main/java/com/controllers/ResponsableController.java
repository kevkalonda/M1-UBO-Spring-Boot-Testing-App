package com.controllers;

import com.dtos.ResponsableDto;
import com.services.impl.ResponsableServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/responsable")
public class ResponsableController {
    private final ResponsableServiceImpl responsableService;
    public ResponsableController(ResponsableServiceImpl responsableService){
        this.responsableService = responsableService;
    }

    /**
     *
     * @return
     */
    @GetMapping
    public List<ResponsableDto> obtenirToutLesResponsable(){
        return  this.responsableService.obtenirTousLesResponsables();
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponsableDto obtenirResponsable(@PathVariable Long id){
        System.out.println("appelle de la foncion dans controlleur ok");
        return this.responsableService.obtenirResponsableParId(id);
    }

    /**
     *
     * @param responsableDto
     * @return
     */
    @PostMapping
    public ResponsableDto enregistrerResponsable(final @RequestBody ResponsableDto responsableDto){
        return this.responsableService.enregistrerResponsable(responsableDto);
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean supprimerResponsable(@PathVariable Long id){
        return this.responsableService.supprimerResponsableParId(id);
    }
}
