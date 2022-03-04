package com.services.impl;

import com.dtos.ComposanteDto;
import com.dtos.Filiere_LangueDto;
import com.dtos.ResponsableDto;
import com.entities.Composante;
import com.entities.Filiere_Langue;
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

    //pour obtenir la classe
    protected ComposanteServiceImpl(){
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
    protected Composante composanteDtoToEntity (ComposanteDto composanteDto){
        Composante composante = new Composante();
        composante.setNomComposante(composanteDto.getNomComposante());
        composante.setId(composanteDto.getId());

        ResponsableServiceImpl rSI = new ResponsableServiceImpl();
        composante.setResponsable(rSI.responsableDtoToEntity(composanteDto.getResponsable()));

        List<Filiere_LangueDto> filiere_langueDtoList = composanteDto.getFiliere_langueList();
        List<Filiere_Langue> filiere_langueList = new ArrayList<>();
        Filiere_LangueServiceImpl flSI = new Filiere_LangueServiceImpl();
        for(Filiere_LangueDto filiere_langueDto: filiere_langueDtoList){
            filiere_langueList.add(flSI.filiere_langueDtoToEntity(filiere_langueDto));
        }
        composante.setFiliere_langueList(filiere_langueList);
        return composante;
    }

    protected ComposanteDto composanteEntityToDto(Composante composante){
        ComposanteDto composanteDto = new ComposanteDto();
        composanteDto.setNomComposante(composante.getNomComposante());
        composanteDto.setId(composante.getId());
        ResponsableServiceImpl rSI = new ResponsableServiceImpl();
        composanteDto.setResponsable(rSI.responsableEntityToDto(composante.getResponsable()));

        List<Filiere_Langue> filiere_langueList = composante.getFiliere_langueList();
        List<Filiere_LangueDto> filiere_langueDtoList = new ArrayList<>();
        Filiere_LangueServiceImpl flSI = new Filiere_LangueServiceImpl();
        for(Filiere_Langue filiere_langue : filiere_langueList){
            filiere_langueDtoList.add(flSI.filiere_langueEntityToDto(filiere_langue));
        }
        composanteDto.setFiliere_langueList(filiere_langueDtoList);
        return null;
    }
}
