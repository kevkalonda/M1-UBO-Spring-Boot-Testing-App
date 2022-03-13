package com.demo;

import com.dtos.ComposanteDto;
import com.dtos.GestionnaireDto;
import com.dtos.ResponsableDto;
import com.entities.Seance_Formation;
import com.services.impl.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class DemoApplicationTests {
	@Autowired
	GestionnaireServiceImpl gestionnaireService;
	@Autowired
	ResponsableServiceImpl responsableService;
	@Autowired
	VacataireServiceImpl vacataireService;
	@Autowired
	Seance_FormationServiceImpl seance_formationService;
	@Autowired
	Filiere_LangueServiceImpl filiere_langueService;
	@Autowired
	CreneauServiceImpl creneauService;
	@Autowired
	CoursServiceImpl coursService;
	@Autowired
	ComposanteServiceImpl composanteService;

	/*@Test
	void addGestionnaire() {
		GestionnaireDto gestionnaireDto = new GestionnaireDto();
		gestionnaireDto.setId(null);
		gestionnaireDto.setPrenom("kevin");
		gestionnaireDto.setNomUsuel("Lumwanga");
		gestionnaireDto.setMail("kevinLumwanga@gmail.com");
		gestionnaireDto.setLogin("kvLumwanga");
		gestionnaireDto.setMotDePasse("1234");
		//System.out.println(gestionnaireDto.toString());
		gestionnaireService.enregistrerGestionnaire(gestionnaireDto);
	}*/

	@Test
	void addComposante(){
		ComposanteDto composanteDto = new ComposanteDto();
		composanteDto.setNomComposante("UFR Langue");
		composanteDto.setId(null);
		long id = 3;
		ResponsableDto responsableDto = new ResponsableDto();
		ResponsableDto responsableDto2 = new ResponsableDto();
		responsableDto2.setId((long)2);
		responsableDto.setId(id);
		List<ResponsableDto> responsableDtoList = new ArrayList<>();
		responsableDtoList.add(responsableDto);
		responsableDtoList.add(responsableDto2);
		composanteDto.setResponsableDtos(responsableDtoList);

		composanteService.enregistrerComposante(composanteDto);
		System.out.println(composanteDto.getResponsableDtos().toString());
	}
	/*@Test
	void add(){
		ResponsableDto responsableDto = new ResponsableDto();
		responsableDto.setId(null);
		responsableDto.setNomUsuel("LM10");
		responsableDto.setMotDePasse("1234");
		responsableDto.setPrenom("lionel");
		responsableDto.setMail("lm10@gmail.com");
		responsableDto.setLogin("messi");
		long id =6;
		ComposanteDto composanteDto = new ComposanteDto();
		composanteDto.setId(id);

		responsableDto.setEst_Rattache_A(composanteDto);
		responsableService.enregistrerResponsable(responsableDto);

	}*/


}
