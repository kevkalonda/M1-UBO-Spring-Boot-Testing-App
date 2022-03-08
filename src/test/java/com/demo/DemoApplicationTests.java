package com.demo;

import com.dtos.ComposanteDto;
import com.dtos.GestionnaireDto;
import com.dtos.ResponsableDto;
import com.entities.Seance_Formation;
import com.services.impl.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


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
	@Test
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
	}
	@Test
	void add(){
		ResponsableDto responsableDto = new ResponsableDto();
		responsableDto.setId(null);
		responsableDto.setNomUsuel("LM10");
		responsableDto.setMotDePasse("1234");
		responsableDto.setPrenom("lionel");
		responsableDto.setMail("lm10@gmail.com");
		responsableDto.setLogin("messi");

		/*ComposanteDto composanteDto = new ComposanteDto();
		composanteDto.setNomComposante("UFR Science");
		composanteDto.setId();
		composanteDto.setFiliere_langueList(null);
		composanteDto.setResponsable(responsableDto);*/
		responsableDto.setEst_Rattache_A(null);
		//composanteService.enregistrerComposante(composanteDto);
		responsableService.enregistrerResponsable(responsableDto);

	}


}
