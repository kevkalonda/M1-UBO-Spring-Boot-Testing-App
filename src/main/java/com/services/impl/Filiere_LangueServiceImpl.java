package com.services.impl;

import com.dtos.ComposanteDto;
import com.dtos.CoursDto;
import com.dtos.Filiere_LangueDto;
import com.entities.Composante;
import com.entities.Cours;
import com.entities.Filiere_Langue;
import com.repositories.Filiere_LangueRepository;
import com.services.Filiere_LangueService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
@Service("filiere_LangueService")
public class Filiere_LangueServiceImpl implements Filiere_LangueService {

    private Filiere_LangueRepository filiereLangueRepository;
    public Filiere_LangueServiceImpl(Filiere_LangueRepository filiereLangueRepository1){
        this.filiereLangueRepository=filiereLangueRepository1;
    }

    protected Filiere_LangueServiceImpl  (){
    }
    @Override
    public Filiere_LangueDto enregistrerFiliereLangue(Filiere_LangueDto filiere_langueDto) {
        Filiere_Langue filiere_langue = filiere_langueDtoToEntity(filiere_langueDto);
        filiere_langue = this.filiereLangueRepository.save(filiere_langue);
        return filiere_langueEntityToDto(filiere_langue);
    }

    @Override
    public Filiere_LangueDto obtenirFiliereLangueParId(Long idFiliereLangue) {
        Filiere_Langue filiere_langue = this.filiereLangueRepository.findById(idFiliereLangue).orElseThrow(() -> new EntityNotFoundException("Filiere not found"));
        return filiere_langueEntityToDto(filiere_langue);
    }

    @Override
    public boolean supprimerFiliereLangueParId(Long idFiliereLangue) {
        this.filiereLangueRepository.deleteById(idFiliereLangue);
        return true;
    }

    @Override
    public List<Filiere_LangueDto> obtenirToutesLesFilieresLangues() {
        List<Filiere_LangueDto> filiere_langueDtos = new ArrayList<>();
        List<Filiere_Langue> filiere_langueList = this.filiereLangueRepository.findAll();
        filiere_langueList.forEach(filiere_langue -> {
            filiere_langueDtos.add(filiere_langueEntityToDto(filiere_langue));
        });
        return filiere_langueDtos;
    }
    protected Filiere_LangueDto filiere_langueEntityToDto(Filiere_Langue filiere_langue){
        Filiere_LangueDto filiere_langueDto = new Filiere_LangueDto();
        filiere_langueDto.setId(filiere_langue.getId());
        filiere_langueDto.setCodeFiliereLangue(filiere_langue.getCodeFiliereLangue());
        filiere_langueDto.setNomFiliereLangue(filiere_langue.getNomFiliereLangue());

        //table de jointure
        ComposanteServiceImpl cSI = new ComposanteServiceImpl();
        Composante composante = filiere_langue.getDepend_De();
        filiere_langueDto.setDepend_De(cSI.composanteEntityToDto(composante));

        List<Cours> coursList = filiere_langue.getCoursList();
        List<CoursDto> coursDtoList = new ArrayList<>();
        CoursServiceImpl crsSI = new CoursServiceImpl();
        for(Cours cours : coursList){
            coursDtoList.add(crsSI.coursEntityToDto(cours));
        }
        filiere_langueDto.setCoursList(coursDtoList);
        return filiere_langueDto;
    }

    protected Filiere_Langue filiere_langueDtoToEntity(Filiere_LangueDto filiere_langueDto){
        Filiere_Langue filiere_langue = new Filiere_Langue();
        filiere_langue.setId(filiere_langueDto.getId());
        filiere_langue.setCodeFiliereLangue(filiere_langueDto.getCodeFiliereLangue());
        filiere_langue.setNomFiliereLangue(filiere_langueDto.getNomFiliereLangue());

        ComposanteServiceImpl cSI = new ComposanteServiceImpl();
        ComposanteDto composanteDto = filiere_langueDto.getDepend_De();
        filiere_langue.setDepend_De(cSI.composanteDtoToEntity(composanteDto));

        List<CoursDto> coursDtoList = filiere_langueDto.getCoursList();
        List<Cours> coursList = new ArrayList<>();
        CoursServiceImpl crsSI = new CoursServiceImpl();
        for(CoursDto coursDto: coursDtoList){
            coursList.add(crsSI.coursDtoToEntiy(coursDto));
        }
        filiere_langue.setCoursList(coursList);
        return filiere_langue;
    }
}
