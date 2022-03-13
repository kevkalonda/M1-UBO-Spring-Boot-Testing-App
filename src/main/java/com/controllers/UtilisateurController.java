package com.controllers;

import com.dtos.GestionnaireDto;
import com.dtos.ResponsableDto;
import com.dtos.UtilisateurDto;
import com.dtos.VacataireDto;
import com.entities.Gestionnaire;
import com.entities.Vacataire;
import com.services.impl.GestionnaireServiceImpl;
import com.services.impl.ResponsableServiceImpl;
import com.services.impl.UtilisateurServiceImpl;
import com.services.impl.VacataireServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {
    private final UtilisateurServiceImpl utilisateurService;
    private  final GestionnaireServiceImpl gestionnaireService;
    private final VacataireServiceImpl vacataireService;
    private  final ResponsableServiceImpl responsableService;
    public UtilisateurController(UtilisateurServiceImpl utilisateurService, VacataireServiceImpl vacataireService, GestionnaireServiceImpl gestionnaireService,ResponsableServiceImpl responsableService ){
        this.utilisateurService = utilisateurService;
        this.gestionnaireService = gestionnaireService;
        this.responsableService = responsableService;
        this.vacataireService = vacataireService;
    }

    /**
     *
     * @return
     */
    @GetMapping
    public List<UtilisateurDto> obtenirToutLesUtilisateur(){
        return  this.utilisateurService.obtenirTousLesUtulisateurs();
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public UtilisateurDto obtenirUtilisateur(@PathVariable Long id){
        return this.utilisateurService.obtenirUtilisateurParId(id);
    }

    /**
     *
     * @param responsableDto
     * @return
     */
    @PostMapping
    public UtilisateurDto enregistrerUtilisateur(final @RequestBody UtilisateurDto responsableDto){
        return this.utilisateurService.enregisterUtilisateur(responsableDto);
    }

    @GetMapping("/connexion")
    public String connexion(final @RequestBody String longin, final @RequestBody String motDePass){
        Long id = this.utilisateurService.obtenirUtilisateurParLoginEtMotDePass(longin,motDePass);
        String typeUser ="";
        ResponsableDto responsableDto = this.responsableService.obtenirResponsableParId(id);
        if(responsableDto.getId() == null){
            GestionnaireDto gestionnaireDto = this.gestionnaireService.obtenirGestionnaireParId(id);
            if(gestionnaireDto.getId() == null){
                VacataireDto vacataireDto = this.vacataireService.obtenirVacataireParId(id);
                if(vacataireDto.getId() != null){
                    typeUser = "Vacataire";
                }
            }else{
                typeUser ="Gestionnaire";
            }
        }else{
            typeUser ="Responsable";
        }
        return  typeUser;
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean supprimerUtilisateur(@PathVariable Long id){
        return this.utilisateurService.supprimerUtilisateurParId(id);
    }
}
