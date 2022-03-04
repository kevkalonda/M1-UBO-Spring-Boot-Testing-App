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

    public Seance_FormationServiceImpl (){

    }
    /**
     * Enregistre un utilisateur
     *
     * @param seance_formationDto
     * @return
     */
    @Override
    public Seance_FormationDto enregistrerSeanceFormation(Seance_FormationDto seance_formationDto) {
        Seance_Formation seance_formation = seanceFormationDtoToEntity(seance_formationDto);
        seance_formation = this.seance_formationRepository.save(seance_formation);
        return seanceFormationEntityToDto(seance_formation);
    }

    /**
     * La méthode renvoie l'utilisateur dont l'id est passé en paramettre
     *
     * @param idSeanceFormation
     * @return
     */
    @Override
    public Seance_FormationDto obtenirSeanceFormationParId(Long idSeanceFormation) {
        Seance_Formation seance_formation = this.seance_formationRepository.findById(idSeanceFormation).orElseThrow(() -> new EntityNotFoundException("Seance Formation not found"));
        return seanceFormationEntityToDto(seance_formation);
    }

    /**
     * La methode renvoinun booleab si l'utilisateur dont l'id passé en paramettre a été suppimé
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
        List<Seance_FormationDto> seanceFormationDtoList = new ArrayList<>();
        List<Seance_Formation> seance_formations = this.seance_formationRepository.findAll();
        seance_formations.forEach(seance_formation -> {
            seanceFormationDtoList.add(seanceFormationEntityToDto(seance_formation));
        });
        return seanceFormationDtoList;
    }

    protected Seance_FormationDto  seanceFormationEntityToDto(Seance_Formation seance_formation){
        Seance_FormationDto seance_formationDto = new Seance_FormationDto();
        //transformation des attributs de la classe
        seance_formationDto.setId(seance_formation.getId());
        seance_formationDto.setEstEffectue(seance_formation.getEstEffectue());
        seance_formationDto.setDureeEffective(seance_formation.getDureeEffective());
        seance_formationDto.setValidite(seance_formation.getValidite());
        seance_formationDto.setCommentaire(seance_formation.getCommentaire());

        //transformation du jointure
        CreneauServiceImpl cSI = new CreneauServiceImpl();
        Creneau creneau = seance_formation.getEst_Planifie_sur();
        seance_formationDto.setEst_Planifie_sur(cSI.creneauEntityToDto(creneau));

        VacataireServiceImpl vSI = new VacataireServiceImpl();
        Vacataire vacataire = seance_formation.getEffectue_par();
        seance_formationDto.setEffectue_par(vSI.vacataireEntityToDto(vacataire));

        return seance_formationDto;
    }
    protected Seance_Formation seanceFormationDtoToEntity(Seance_FormationDto seance_formationDto){

        Seance_Formation seance_formation = new Seance_Formation();
        //transformation des attributs de la classe
        seance_formation.setId(seance_formationDto.getId());
        seance_formation.setEstEffectue(seance_formationDto.getEstEffectue());
        seance_formation.setDureeEffective(seance_formationDto.getDureeEffective());
        seance_formation.setValidite(seance_formationDto.getValidite());
        seance_formation.setCommentaire(seance_formationDto.getCommentaire());

        //transformation du jointure
        CreneauServiceImpl cSI = new CreneauServiceImpl();
        CreneauDto creneau = seance_formationDto.getEst_Planifie_sur();
        seance_formation.setEst_Planifie_sur(cSI.creneauDtoToEntity(creneau));

        VacataireServiceImpl vSI = new VacataireServiceImpl();
        VacataireDto vacataire = seance_formationDto.getEffectue_par();
        seance_formation.setEffectue_par(vSI.vacataireDtoToEntity(vacataire));


        return seance_formation;
    }
}
