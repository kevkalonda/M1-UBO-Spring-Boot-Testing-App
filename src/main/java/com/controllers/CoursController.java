package com.controllers;

import com.dtos.CoursDto;
import com.services.impl.CoursServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cours")
public class CoursController {
    private final CoursServiceImpl coursService;
    public CoursController(CoursServiceImpl coursService){
        this.coursService = coursService;
    }

    /**
     *
     * @return
     */
    @GetMapping
    public List<CoursDto> obtenirToutLesCours(){
        return  this.coursService.obtenirTousLesCours();
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public CoursDto obtenirCours(@PathVariable Long id){
        return this.coursService.obtenirCoursParId(id);
    }

    /**
     *
     * @param coursDto
     * @return
     */
    @PostMapping
    public CoursDto enregistrerCours(final @RequestBody CoursDto coursDto){
        return this.coursService.enregistrerCours(coursDto);
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean supprimerCours(@PathVariable Long id){
        return this.coursService.supprimerCoursParId(id);
    }
}
