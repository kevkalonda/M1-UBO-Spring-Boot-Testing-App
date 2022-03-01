package com.services.impl;

import com.dtos.ComposanteDto;
import com.dtos.ResponsableDto;
import com.entities.Composante;
import com.entities.Responsable;
import com.repositories.ComposanteRepository;
import com.services.ComposanteService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("composanteService")
public class ComposanteServiceImpl implements ComposanteService {

    private ComposanteRepository composanteRepository;
    public ComposanteServiceImpl(ComposanteRepository composanteRepos){
        this.composanteRepository= composanteRepos;
    }
    @Override
    public ComposanteDto enregistrerComposante(ComposanteDto composanteDto) {
        //conversion de Dto à l'entité
        Composante composante = composanteDtoToEntity(composanteDto);
        //enregistrement de l'entité
        composante = this.composanteRepository.save(composante);
        //on return une nouvelle composanteDto
        return composanteEntityToDto(composante);
    }

    @Override
    public ComposanteDto obtenirComposanteParID(Long composanteId) {
        Composante composante = this.composanteRepository.findById(composanteId).orElseThrow(() -> new EntityNotFoundException("composante n'existe pas"));
        return composanteEntityToDto(composante);
    }

    @Override
    public boolean supprimerComposanteParId(Long composanteId) {
        this.composanteRepository.deleteById(composanteId);
        return true;
    }

    @Override
    public List<ComposanteDto> obtenirToutLesComposantes() {
        List<ComposanteDto> composanteDtoList = new ArrayList<>();
        List<Composante> composanteList = this.composanteRepository.findAll();
        composanteList.forEach(composante -> {
            composanteDtoList.add(composanteEntityToDto(composante));
        });
        return composanteDtoList;
    }

    /**
     *
     * @param composanteDto
     * @return
     */
    private Composante composanteDtoToEntity (ComposanteDto composanteDto){
        Composante composante = new Composante();
        composante.setNomComposante(composanteDto.getNomComposante());
        composante.setId(composanteDto.getId());

        ResponsableDto responsableDto = composanteDto.getResponsable();
        Responsable responsable = new Responsable();
        responsable.setId(responsableDto.getId());
        responsable.setLogin(responsableDto.getLogin());
        responsable.setMail(responsableDto.getMail());

        //composante du responsable
        ComposanteDto estRatacher = responsableDto.getEst_Rattache_A();
        Composante responsableComposante = new Composante();


        //responsable.setEst_Rattache_A(responsableDto.getEst_Rattache_A());
        //composante.setResponsable(composanteDto.getResponsable());
        //composante.setFiliere_langueList(composanteDto.getFiliere_langueList());
        return null;
    }

    private ComposanteDto composanteEntityToDto(Composante composante){

        return null;
    }
}
