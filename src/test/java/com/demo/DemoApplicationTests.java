package com.demo;

import com.dtos.GestionnaireDto;
import com.dtos.ResponsableDto;
import com.services.impl.GestionnaireServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class DemoApplicationTests {
	List<ResponsableDto> responsableDtos = new ArrayList<>();
	List<GestionnaireDto> gestionnaireDtoList = new ArrayList<>();
	@Test
	void contextLoads() {
		GestionnaireServiceImpl gestionnaireService;
		GestionnaireDto gestionnaireDto = new GestionnaireDto();
		gestionnaireDto.setId(null);
		gestionnaireDto.setPrenom("Clement");
		gestionnaireDto.setNomUsuel("Lumwanga");
		gestionnaireDto.setMail("clementLumwanga@gmail.com");
		gestionnaireDto.setLogin("clLumwanga");
		gestionnaireDto.setMotDePasse("1234");
		System.out.println(gestionnaireDto.toString());
	}

}
