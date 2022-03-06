package com.services.impl;

import com.dtos.CoursDto;
import com.dtos.Seance_FormationDto;
import com.dtos.VacataireDto;
import com.entities.Cours;
import com.entities.Seance_Formation;
import com.entities.Vacataire;
import com.repositories.VacataireRepository;
import com.services.VacataireService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
@Service("vacataireService")
public class VacataireServiceImpl implements VacataireService {

    private VacataireRepository vacataireRepository;
    public VacataireServiceImpl(VacataireRepository vacataireRepository1){
        this.vacataireRepository=vacataireRepository1;
    }

    /**
     * Enregistrer le vacataire passé en paramettre
     *
     * @param vacataireDto
     * @return
     */
    @Override
    public VacataireDto enregistrerVacataire(VacataireDto vacataireDto) {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        Vacataire vacataire = mapperService.vacataireDtoToEntity(vacataireDto);
        vacataire = vacataireRepository.save(vacataire);
        return mapperService.vacataireEntityToDto(vacataire);
    }

    /**
     * La méthode renvoie le vacataire dont l'id est passé en paramettre
     *
     * @param idVacataire
     * @return
     */
    @Override
    public VacataireDto obtenirVacataireParId(Long idVacataire) {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        Vacataire vacataire = this.vacataireRepository.findById(idVacataire).orElseThrow(() -> new EntityNotFoundException("Vacataire not found"));
        return mapperService.vacataireEntityToDto(vacataire);
    }

    /**
     * La methode renvoinun booleab si le vacataire dont l'id passé en paramettre a été suppimé
     *
     * @param idVacataire
     * @return
     */
    @Override
    public boolean supprimerVacataireParId(Long idVacataire) {
        this.vacataireRepository.deleteById(idVacataire);
        return true;
    }

    /**
     * Cette méthode retourne tous les Vacataires
     *
     * @return
     */
    @Override
    public List<VacataireDto> obtenirTousLesVacataires() {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        List<VacataireDto> vacataireDtos = new ArrayList<>();
        List<Vacataire> vacataires = this.vacataireRepository.findAll();
        vacataires.forEach(vacataire -> {
            vacataireDtos.add(mapperService.vacataireEntityToDto(vacataire));
        });
        return vacataireDtos;
    }




}
