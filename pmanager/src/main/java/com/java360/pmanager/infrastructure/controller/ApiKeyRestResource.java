package com.java360.pmanager.infrastructure.controller;

import com.java360.pmanager.domain.applicationservice.ApiKeyService;
import com.java360.pmanager.domain.applicationservice.ProjectService;
import com.java360.pmanager.domain.document.ApiKey;
import com.java360.pmanager.domain.entity.Project;
import com.java360.pmanager.infrastructure.dto.ApiKeyDTO;
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

import static com.java360.pmanager.infrastructure.controller.RestConstants.*;

//@RestController indica que aqui será recebida a requisição http do cliente.
@RestController
//O @RequestMapping poderia também estar como (@RequestMapping("/projects/")) mas foi utilizado o RestController para configurar o path
@RequestMapping(PATH_API_KEYS)
//@RequiredArgsConstructor é uma anotação do Lombok que gera automaticamente um construtor
// para uma classe que inclui todos os campos (atributos) que são finais ou anotados com @NonNull.
@RequiredArgsConstructor
public class ApiKeyRestResource {

	// O @RequiredArgsConstructor cria o construtor para o private abaixo
	private final ApiKeyService apiKeyService;

	//Requisição de create
	@PostMapping
	public ResponseEntity<ApiKeyDTO> createApiKey(@RequestBody @Valid ApiKeyDTO apiKeyDTO){

		ApiKey apiKey = apiKeyService.createApiKey(apiKeyDTO);

		return ResponseEntity
				.created(URI.create(PATH_API_KEYS + "/" + apiKey.getId()))
				.body(ApiKeyDTO.create(apiKey));

	}


}
