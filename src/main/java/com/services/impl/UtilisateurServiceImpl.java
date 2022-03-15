package com.services.impl;

import com.dtos.UtilisateurDto;
import com.entities.Utilisateur;
import com.repositories.UtilisateurRepository;
import com.services.UtilisateurService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
@Service("utilisateurService")
public class UtilisateurServiceImpl implements UtilisateurService {
    private UtilisateurRepository utilisateurRepository;
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository1){
        this.utilisateurRepository=utilisateurRepository1;
    }
    /**
     * Enregistre un utilisateur
     *
     * @param utilisateurDto
     * @return
     */
    @Override
    public UtilisateurDto enregisterUtilisateur(UtilisateurDto utilisateurDto) {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        Utilisateur utilisateur = mapperService.utilisateurDtoToEntity(utilisateurDto);
        utilisateur = this.utilisateurRepository.save(utilisateur);
        return mapperService.utilisateurEntityToDto(utilisateur);
    }

    /**
     * La méthode renvoie l'utilisateur dont l'id est passé en paramettre
     *
     * @param idUtilisateur
     * @return
     */
    @Override
    public UtilisateurDto obtenirUtilisateurParId(Long idUtilisateur) {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        Utilisateur utilisateur = this.utilisateurRepository.findById(idUtilisateur).orElseThrow(() -> new EntityNotFoundException("Utilisateur not found"));
        return mapperService.utilisateurEntityToDto(utilisateur);
    }

    /**
     * La methode renvoinun booleab si l'utilisateur dont l'id passé en paramettre a été suppimé
     *
     * @param idUtilisateur
     * @return
     */
    @Override
    public boolean supprimerUtilisateurParId(Long idUtilisateur) {
        this.utilisateurRepository.deleteById(idUtilisateur);
        return true;
    }

    /**
     * Cette méthode retourne tous les Utilisateurs
     *
     * @return
     */
    @Override
    public List<UtilisateurDto> obtenirTousLesUtulisateurs() {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        List<UtilisateurDto> utilisateurDtos = new ArrayList<>();
        List<Utilisateur> utilisateurs = this.utilisateurRepository.findAll();
        utilisateurs.forEach(utilisateur -> {
            utilisateurDtos.add(mapperService.utilisateurEntityToDto(utilisateur));
        });
        return null;
    }

    
  

}
