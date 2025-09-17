package com.java360.pmanager.infrastructure.controller;

import com.java360.pmanager.domain.applicationservice.ProjectService;
import com.java360.pmanager.domain.entity.Project;
import com.java360.pmanager.infrastructure.dto.ProjectDTO;
import com.java360.pmanager.infrastructure.dto.SaveProjectDataDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static com.java360.pmanager.infrastructure.controller.RestConstants.PATH_PROJECTS;

//@RestController indica que aqui será recebida a requisição http do cliente.
@RestController
//O @RequestMapping poderia também estar como (@RequestMapping("/projects/")) mas foi utilizado o RestController para configurar o path
@RequestMapping(PATH_PROJECTS)
//@RequiredArgsConstructor é uma anotação do Lombok que gera automaticamente um construtor
// para uma classe que inclui todos os campos (atributos) que são finais ou anotados com @NonNull.
@RequiredArgsConstructor
public class ProjectRestResource {

	// O @RequiredArgsConstructor cria o construtor para o private abaixo
	private final ProjectService projectService;

	//Requisição de create
	@PostMapping

	//A @RequestBody no Spring Boot e em outras aplicações Java é uma anotação que indica que o corpo de uma
	// requisição HTTP deve ser convertido em um objeto Java, permitindo que os dados enviados pelo cliente
	// sejam automaticamente mapeados para o objeto especificado como um parâmetro no mé
	// todo do controlador.
	//O  @Valid valida as caracteristicas dos inputs descritas no SaveProjectDataDTO
	public ResponseEntity<ProjectDTO> createProject(@RequestBody @Valid SaveProjectDataDTO saveProjectData){

		Project project = projectService.createProject(saveProjectData);

		return ResponseEntity
				.created(URI.create(PATH_PROJECTS + "/" + project.getId()))
				.body(ProjectDTO.create(project));

	}


}
