package com.services.impl;

import com.dtos.CreneauDto;
import com.dtos.Seance_FormationDto;
import com.dtos.VacataireDto;
import com.entities.Creneau;
import com.entities.Seance_Formation;
import com.entities.Vacataire;
import com.repositories.Seance_FormationRepository;
import com.services.Seance_FormationService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
@Service("seance_FormationService")
public class Seance_FormationServiceImpl implements Seance_FormationService {

    private Seance_FormationRepository seance_formationRepository;
    public Seance_FormationServiceImpl(Seance_FormationRepository seance_formationRepository1){
        this.seance_formationRepository=seance_formationRepository1;
    }

    /**
     * Enregistre la seance formation
     *
     * @param seance_formationDto
     * @return
     */
    @Override
    public Seance_FormationDto enregistrerSeanceFormation(Seance_FormationDto seance_formationDto) {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        Seance_Formation seance_formation = mapperService.seanceFormationDtoToEntity(seance_formationDto);
        seance_formation = this.seance_formationRepository.save(seance_formation);
        return mapperService.seanceFormationEntityToDto(seance_formation);
    }

    /**
     * La méthode renvoie la seance formation dont l'id est passé en paramettre
     *
     * @param idSeanceFormation
     * @return
     */
    @Override
    public Seance_FormationDto obtenirSeanceFormationParId(Long idSeanceFormation) {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        Seance_Formation seance_formation = this.seance_formationRepository.findById(idSeanceFormation).orElseThrow(() -> new EntityNotFoundException("Seance Formation not found"));
        return mapperService.seanceFormationEntityToDto(seance_formation);
    }

    /**
     * La methode renvoinun booleab si la seance formation dont l'id passé en paramettre a été suppimé
     *
     * @param idSeanceFormatio
     * @return
     */
    @Override
    public boolean supprimerSeanceFormationParId(Long idSeanceFormatio) {
        this.seance_formationRepository.deleteById(idSeanceFormatio);
        return true;
    }

    /**
     * Cette méthode retourne tous les Seance_Formation
     *
     * @return
     */
    @Override
    public List<Seance_FormationDto> obtenirToutesLesSeancesFormations() {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        List<Seance_FormationDto> seanceFormationDtoList = new ArrayList<>();
        List<Seance_Formation> seance_formations = this.seance_formationRepository.findAll();
        seance_formations.forEach(seance_formation -> {
            seanceFormationDtoList.add(mapperService.seanceFormationEntityToDto(seance_formation));
        });
        return seanceFormationDtoList;
    }


}
