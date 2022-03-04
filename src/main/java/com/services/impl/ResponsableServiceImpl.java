package com.services.impl;

import com.dtos.ComposanteDto;
import com.dtos.ResponsableDto;
import com.entities.Composante;
import com.entities.Responsable;
import com.repositories.ResponsableRepository;
import com.services.ResponsableService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
@Service("responsableService")
public class ResponsableServiceImpl implements ResponsableService {
    private ResponsableRepository responsableRepository;
    public ResponsableServiceImpl(ResponsableRepository responsableRepository1){
        this.responsableRepository=responsableRepository1;
    }

    protected ResponsableServiceImpl (){
    }
    /**
     * Enregistre un utilisateur
     *
     * @param responsableDto
     * @return
     */
    @Override
    public ResponsableDto enregistrerResponsable(ResponsableDto responsableDto) {
        Responsable responsable = this.responsableDtoToEntity(responsableDto);
        responsable = this.responsableRepository.save(responsable);
        return responsableEntityToDto(responsable);
    }

    /**
     * La méthode renvoie l'utilisateur dont l'id est passé en paramettre
     *
     * @param idResponsable
     * @return
     */
    @Override
    public ResponsableDto obtenirResponsableParId(Long idResponsable) {
        Responsable responsable = this.responsableRepository.findById(idResponsable).orElseThrow(() -> new EntityNotFoundException("Responsable not found"));
        return this.responsableEntityToDto(responsable);
    }

    /**
     * La methode renvoinun booleab si l'utilisateur dont l'id passé en paramettre a été suppimé
     *
     * @param idResponsable
     * @return
     */
    @Override
    public boolean supprimerResponsableParId(Long idResponsable) {
        this.responsableRepository.deleteById(idResponsable);
        return true;
    }

    /**
     * Cette méthode retourne tous les Utilisateurs
     *
     * @return
     */
    @Override
    public List<ResponsableDto> obtenirTousLesResponsables() {
        List<ResponsableDto> responsableDtos = new ArrayList<>();
        List<Responsable> responsables = this.responsableRepository.findAll();
        responsables.forEach(responsable -> {
            responsableDtos.add(responsableEntityToDto(responsable));
        });
        return responsableDtos;
    }
    protected   ResponsableDto responsableEntityToDto(Responsable responsable){
        ResponsableDto responsableDto = new ResponsableDto();
        responsableDto.setId(responsable.getId());
        responsableDto.setLogin(responsable.getLogin());
        responsableDto.setMail(responsable.getMail());
        responsableDto.setPrenom(responsable.getPrenom());
        responsableDto.setMotDePasse(responsable.getMotDePasse());
        responsableDto.setNomUsuel(responsable.getNomUsuel());

        //tables de jointure
        ComposanteServiceImpl cSI = new ComposanteServiceImpl();
        Composante composante= responsable.getEst_Rattache_A();
        responsableDto.setEst_Rattache_A(cSI.composanteEntityToDto(composante));
        return responsableDto;
    }

    protected Responsable responsableDtoToEntity(ResponsableDto responsableDto){
        Responsable responsable = new Responsable();
        responsable.setId(responsableDto.getId());
        responsable.setLogin(responsableDto.getLogin());
        responsable.setMail(responsableDto.getMail());
        responsable.setPrenom(responsableDto.getPrenom());
        responsable.setMotDePasse(responsableDto.getMotDePasse());
        responsable.setNomUsuel(responsableDto.getNomUsuel());

        ComposanteServiceImpl cSI = new ComposanteServiceImpl();
        ComposanteDto composanteDto = responsableDto.getEst_Rattache_A();
        responsable.setEst_Rattache_A(cSI.composanteDtoToEntity(composanteDto));
        return responsable;
    }
}
