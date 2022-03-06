package com.services.impl;

import com.dtos.*;
import com.entities.*;
import com.services.MapperService;

import java.util.ArrayList;
import java.util.List;

public class MapperServiceImpl implements MapperService {
    /**
     *
     * @param vacataireDto
     * @return
     */
    @Override
    public Vacataire vacataireDtoToEntity(VacataireDto vacataireDto) {
        Vacataire v = new Vacataire();
        v.setId(vacataireDto.getId());
        v.setLogin(vacataireDto.getLogin());
        v.setMotDePasse(vacataireDto.getMotDePasse());
        v.setPrenom(vacataireDto.getPrenom());
        v.setNomUsuel(vacataireDto.getNomUsuel());
        v.setMail(vacataireDto.getMail());

        //est effectué par une liste de seance formation
        List<Seance_FormationDto> seance_formationsDto = vacataireDto.getEffectue();
        List<Seance_Formation> formationList = new ArrayList<>();
        for(Seance_FormationDto sf: seance_formationsDto){
            formationList.add(this.seanceFormationDtoToEntity(sf));
        }
        v.setEffectue(formationList);

        //partici pe à 0 ou plusieurs Cours
        List<CoursDto> coursListDto = vacataireDto.getParticipe_A();
        List<Cours> coursList = new ArrayList<>();
        for(CoursDto cours : coursListDto){
            coursList.add(this.coursDtoToEntiy(cours));
        }
        v.setParticipe_A(coursList);
        return v;
    }

    /**
     *
     * @param vacataire
     * @return
     */
    @Override
    public VacataireDto vacataireEntityToDto(Vacataire vacataire) {
        VacataireDto v = new VacataireDto();
        v.setId(vacataire.getId());
        v.setLogin(vacataire.getLogin());
        v.setMotDePasse(vacataire.getMotDePasse());
        v.setPrenom(vacataire.getPrenom());
        v.setNomUsuel(vacataire.getNomUsuel());
        v.setMail(vacataire.getMail());

        //est effectué par une liste de seance formation
        List<Seance_Formation> seance_formations = vacataire.getEffectue();
        List<Seance_FormationDto> formationDtoList = new ArrayList<>();
        for(Seance_Formation sf: seance_formations){
            formationDtoList.add(this.seanceFormationEntityToDto(sf));
        }
        v.setEffectue(formationDtoList);

        //participe à 0 ou plusieurs Cours
        List<Cours> coursList = vacataire.getParticipe_A();
        List<CoursDto> coursDtoList = new ArrayList<>();
        for(Cours cours : coursList){
            coursDtoList.add(this.coursEntityToDto(cours));
        }
        v.setParticipe_A(coursDtoList);
        return v;
    }

    /**
     *
     * @param utilisateurDto
     * @return
     */
    @Override
    public Utilisateur utilisateurDtoToEntity(UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(utilisateurDto.getId());
        utilisateur.setLogin(utilisateurDto.getLogin());
        utilisateur.setMail(utilisateurDto.getMail());
        utilisateur.setNomUsuel(utilisateurDto.getNomUsuel());
        utilisateur.setPrenom(utilisateurDto.getPrenom());
        utilisateur.setMotDePasse(utilisateurDto.getMotDePasse());
        return utilisateur;
    }

    /**
     *
     * @param utilisateur
     * @return
     */
    @Override
    public UtilisateurDto utilisateurEntityToDto(Utilisateur utilisateur) {
        UtilisateurDto utilisateurDto = new UtilisateurDto();
        utilisateurDto.setId(utilisateur.getId());
        utilisateurDto.setLogin(utilisateur.getLogin());
        utilisateurDto.setMail(utilisateur.getMail());
        utilisateurDto.setNomUsuel(utilisateur.getNomUsuel());
        utilisateurDto.setPrenom(utilisateur.getPrenom());
        utilisateurDto.setMotDePasse(utilisateur.getMotDePasse());
        return utilisateurDto;
    }

    /**
     *
     * @param seance_formationDto
     * @return
     */
    @Override
    public Seance_Formation seanceFormationDtoToEntity(Seance_FormationDto seance_formationDto) {
        Seance_Formation seance_formation = new Seance_Formation();
        //transformation des attributs de la classe
        seance_formation.setId(seance_formationDto.getId());
        seance_formation.setEstEffectue(seance_formationDto.getEstEffectue());
        seance_formation.setDureeEffective(seance_formationDto.getDureeEffective());
        seance_formation.setValidite(seance_formationDto.getValidite());
        seance_formation.setCommentaire(seance_formationDto.getCommentaire());

        //transformation du jointure
        CreneauDto creneau = seance_formationDto.getEst_Planifie_sur();
        seance_formation.setEst_Planifie_sur(this.creneauDtoToEntity(creneau));

        VacataireDto vacataire = seance_formationDto.getEffectue_par();
        seance_formation.setEffectue_par(this.vacataireDtoToEntity(vacataire));
        return null;
    }

    /**
     *
     * @param seance_formation
     * @return
     */
    @Override
    public Seance_FormationDto seanceFormationEntityToDto(Seance_Formation seance_formation) {
        Seance_FormationDto seance_formationDto = new Seance_FormationDto();
        //transformation des attributs de la classe
        seance_formationDto.setId(seance_formation.getId());
        seance_formationDto.setEstEffectue(seance_formation.getEstEffectue());
        seance_formationDto.setDureeEffective(seance_formation.getDureeEffective());
        seance_formationDto.setValidite(seance_formation.getValidite());
        seance_formationDto.setCommentaire(seance_formation.getCommentaire());

        //transformation du jointure
        Creneau creneau = seance_formation.getEst_Planifie_sur();
        seance_formationDto.setEst_Planifie_sur(this.creneauEntityToDto(creneau));

        Vacataire vacataire = seance_formation.getEffectue_par();
        seance_formationDto.setEffectue_par(this.vacataireEntityToDto(vacataire));
        return seance_formationDto;
    }

    /**
     *
     * @param responsableDto
     * @return
     */
    @Override
    public Responsable responsableDtoToEntity(ResponsableDto responsableDto) {
        Responsable responsable = new Responsable();
        responsable.setId(responsableDto.getId());
        responsable.setLogin(responsableDto.getLogin());
        responsable.setMail(responsableDto.getMail());
        responsable.setPrenom(responsableDto.getPrenom());
        responsable.setMotDePasse(responsableDto.getMotDePasse());
        responsable.setNomUsuel(responsableDto.getNomUsuel());

        ComposanteDto composanteDto = responsableDto.getEst_Rattache_A();
        responsable.setEst_Rattache_A(this.composanteDtoToEntity(composanteDto));

        return responsable;
    }

    /**
     *
     * @param responsable
     * @return
     */
    @Override
    public ResponsableDto responsableEntityToDto(Responsable responsable) {
        ResponsableDto responsableDto = new ResponsableDto();
        responsableDto.setId(responsable.getId());
        responsableDto.setLogin(responsable.getLogin());
        responsableDto.setMail(responsable.getMail());
        responsableDto.setPrenom(responsable.getPrenom());
        responsableDto.setMotDePasse(responsable.getMotDePasse());
        responsableDto.setNomUsuel(responsable.getNomUsuel());

        //tables de jointure
        Composante composante= responsable.getEst_Rattache_A();
        responsableDto.setEst_Rattache_A(this.composanteEntityToDto(composante));
        return responsableDto;
    }

    /**
     *
     * @param gestionnaireDto
     * @return
     */
    @Override
    public Gestionnaire gestionnaireDtoToEntity(GestionnaireDto gestionnaireDto) {
        Gestionnaire gestionnaire = new Gestionnaire();
        gestionnaire.setId(gestionnaireDto.getId());
        gestionnaire.setLogin(gestionnaireDto.getLogin());
        gestionnaire.setMail(gestionnaireDto.getMail());
        gestionnaire.setPrenom(gestionnaireDto.getPrenom());
        gestionnaire.setNomUsuel(gestionnaireDto.getNomUsuel());
        gestionnaire.setMotDePasse(gestionnaireDto.getMotDePasse());
        return gestionnaire;
    }

    /**
     *
     * @param gestionnaire
     * @return
     */
    @Override
    public GestionnaireDto gestionnaireEntityToDto(Gestionnaire gestionnaire) {
        GestionnaireDto gestionnaireDto = new GestionnaireDto();
        gestionnaireDto.setId(gestionnaire.getId());
        gestionnaireDto.setLogin(gestionnaire.getLogin());
        gestionnaireDto.setMail(gestionnaire.getMail());
        gestionnaireDto.setPrenom(gestionnaire.getPrenom());
        gestionnaireDto.setNomUsuel(gestionnaire.getNomUsuel());
        gestionnaireDto.setMotDePasse(gestionnaire.getMotDePasse());
        return gestionnaireDto;
    }

    /**
     *
     * @param filiere_langue
     * @return
     */
    @Override
    public Filiere_LangueDto filiere_langueEntityToDto(Filiere_Langue filiere_langue) {
        Filiere_LangueDto filiere_langueDto = new Filiere_LangueDto();
        filiere_langueDto.setId(filiere_langue.getId());
        filiere_langueDto.setCodeFiliereLangue(filiere_langue.getCodeFiliereLangue());
        filiere_langueDto.setNomFiliereLangue(filiere_langue.getNomFiliereLangue());

        //table de jointure
        Composante composante = filiere_langue.getDepend_De();
        filiere_langueDto.setDepend_De(this.composanteEntityToDto(composante));

        List<Cours> coursList = filiere_langue.getCoursList();
        List<CoursDto> coursDtoList = new ArrayList<>();
        for(Cours cours : coursList){
            coursDtoList.add(this.coursEntityToDto(cours));
        }
        filiere_langueDto.setCoursList(coursDtoList);
        return filiere_langueDto;
    }

    /**
     *
     * @param filiere_langueDto
     * @return
     */
    @Override
    public Filiere_Langue filiere_langueDtoToEntity(Filiere_LangueDto filiere_langueDto) {
        Filiere_Langue filiere_langue = new Filiere_Langue();
        filiere_langue.setId(filiere_langueDto.getId());
        filiere_langue.setCodeFiliereLangue(filiere_langueDto.getCodeFiliereLangue());
        filiere_langue.setNomFiliereLangue(filiere_langueDto.getNomFiliereLangue());

        ComposanteDto composanteDto = filiere_langueDto.getDepend_De();
        filiere_langue.setDepend_De(this.composanteDtoToEntity(composanteDto));

        List<CoursDto> coursDtoList = filiere_langueDto.getCoursList();
        List<Cours> coursList = new ArrayList<>();
        for(CoursDto coursDto: coursDtoList){
            coursList.add(this.coursDtoToEntiy(coursDto));
        }
        filiere_langue.setCoursList(coursList);
        return filiere_langue;
    }

    /**
     *
     * @param creneau
     * @return
     */
    @Override
    public CreneauDto creneauEntityToDto(Creneau creneau) {
        CreneauDto creneauDto = new CreneauDto();
        creneauDto.setId(creneau.getId());
        creneauDto.setDate_heure(creneau.getDate_heure());
        creneauDto.setDuree(creneau.getDuree());
        creneauDto.setType(creneau.getType());

        //jointure
        Cours cours = creneau.getCours();
        creneauDto.setCours(this.coursEntityToDto(cours));

        List<Seance_Formation> seance_formations = creneau.getSeanceFormationList();
        List<Seance_FormationDto> seanceFormationDtoList = new ArrayList<>();
        for(Seance_Formation seance_formation : seance_formations){
            seanceFormationDtoList.add(this.seanceFormationEntityToDto(seance_formation));
        }
        creneauDto.setSeanceFormationList(seanceFormationDtoList);
        return creneauDto;
    }

    /**
     *
     * @param creneauDto
     * @return
     */
    @Override
    public Creneau creneauDtoToEntity(CreneauDto creneauDto) {
        Creneau creneau = new Creneau();
        creneau.setId(creneauDto.getId());
        creneau.setDate_heure(creneauDto.getDate_heure());
        creneau.setDuree(creneauDto.getDuree());
        creneau.setType(creneauDto.getType());

        CoursDto coursDto = creneauDto.getCours();
        creneau.setCours(this.coursDtoToEntiy(coursDto));

        List<Seance_FormationDto> seanceFormationDtoList = creneauDto.getSeanceFormationList();
        List<Seance_Formation> seance_formations = new ArrayList<>();
        for(Seance_FormationDto seance_formationDto : seanceFormationDtoList){
            seance_formations.add(this.seanceFormationDtoToEntity(seance_formationDto));
        }
        creneau.setSeanceFormationList(seance_formations);
        return creneau;
    }

    /**
     *
     * @param coursDto
     * @return
     */
    @Override
    public Cours coursDtoToEntiy(CoursDto coursDto) {
        Cours cours =new Cours();
        cours.setId(coursDto.getId());
        cours.setIntitule(coursDto.getIntitule());

        List<CreneauDto> creneauDtoList = coursDto.getCreneauList();
        List<Creneau> creneauList = new ArrayList<>();
        for(CreneauDto creneauDto : creneauDtoList){
            creneauList.add(this.creneauDtoToEntity(creneauDto));
        }
        cours.setCreneauList(creneauList);

        List<VacataireDto> vacataireDtos = coursDto.getVacataireList();
        List<Vacataire> vacataires = new ArrayList<>();
        for(VacataireDto vacataireDto : vacataireDtos){
            vacataires.add(this.vacataireDtoToEntity(vacataireDto));
        }
        cours.setVacataireList(vacataires);

        List<Filiere_LangueDto> filiere_langueDtos = coursDto.getFiliere_langueList();
        List<Filiere_Langue> filiere_langueList = new ArrayList<>();
        for(Filiere_LangueDto filiere_langueDto: filiere_langueDtos){
            filiere_langueList.add(this.filiere_langueDtoToEntity(filiere_langueDto));
        }
        cours.setFiliere_langueList(filiere_langueList);
        return null;
    }

    /**
     *
     * @param cours
     * @return
     */
    @Override
    public CoursDto coursEntityToDto(Cours cours) {
        CoursDto coursDto = new  CoursDto();
        coursDto.setId(cours.getId());
        coursDto.setIntitule(cours.getIntitule());

        List<Creneau> creneauList = cours.getCreneauList();
        List<CreneauDto> creneauDtoList  = new ArrayList<>();
        for(Creneau creneau: creneauList){
            creneauDtoList.add(this.creneauEntityToDto(creneau));
        }
        coursDto.setCreneauList(creneauDtoList);

        List<Vacataire> vacataireList = cours.getVacataireList();
        List<VacataireDto> vacataireDtoList = new ArrayList<>();
        for(Vacataire vacataire : vacataireList){
            vacataireDtoList.add(this.vacataireEntityToDto(vacataire));
        }
        coursDto.setVacataireList(vacataireDtoList);

        List<Filiere_Langue> filiere_langueList = cours.getFiliere_langueList();
        List<Filiere_LangueDto> filiere_langueDtos = new ArrayList<>();
        for (Filiere_Langue filiere_langue : filiere_langueList){
            filiere_langueDtos.add(this.filiere_langueEntityToDto(filiere_langue));
        }
        coursDto.setFiliere_langueList(filiere_langueDtos);
        return coursDto;
    }

    /**
     *
     * @param composante
     * @return
     */
    @Override
    public ComposanteDto composanteEntityToDto(Composante composante) {
        ComposanteDto composanteDto = new ComposanteDto();
        composanteDto.setNomComposante(composante.getNomComposante());
        composanteDto.setId(composante.getId());
        composanteDto.setResponsable(this.responsableEntityToDto(composante.getResponsable()));

        List<Filiere_Langue> filiere_langueList = composante.getFiliere_langueList();
        List<Filiere_LangueDto> filiere_langueDtoList = new ArrayList<>();
        for(Filiere_Langue filiere_langue : filiere_langueList){
            filiere_langueDtoList.add(this.filiere_langueEntityToDto(filiere_langue));
        }
        composanteDto.setFiliere_langueList(filiere_langueDtoList);
        return composanteDto;
    }

    /**
     *
     * @param composanteDto
     * @return
     */
    @Override
    public Composante composanteDtoToEntity(ComposanteDto composanteDto) {
        Composante composante = new Composante();
        composante.setNomComposante(composanteDto.getNomComposante());
        composante.setId(composanteDto.getId());
        composante.setResponsable(this.responsableDtoToEntity(composanteDto.getResponsable()));

        List<Filiere_LangueDto> filiere_langueDtoList = composanteDto.getFiliere_langueList();
        List<Filiere_Langue> filiere_langueList = new ArrayList<>();
        for(Filiere_LangueDto filiere_langueDto: filiere_langueDtoList){
            filiere_langueList.add(this.filiere_langueDtoToEntity(filiere_langueDto));
        }
        composante.setFiliere_langueList(filiere_langueList);
        return composante;
    }
}
