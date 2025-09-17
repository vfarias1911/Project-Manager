package com.java360.pmanager.domain.applicationservice;


import com.java360.pmanager.domain.entity.Project;
import com.java360.pmanager.domain.model.ProjectStatus;
import com.java360.pmanager.domain.repository.ProjectRepository;
import com.java360.pmanager.infrastructure.dto.SaveProjectDataDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //@Service marca uma classe como um serviço que contém a lógica de negócio da aplicação,
        // abstraindo e orquestrando operações entre os controladores (que recebem as requisições)
        // e os repositórios (que interagem com o banco de dados)
@RequiredArgsConstructor //biblioteca Lombok, que gera automaticamente um construtor com um parâmetro
                        // para cada campo final ou não-nulo (@NonNull) na classe.
@Slf4j // Anotação do lombok usada para geração de logs através do comando exemplo "log.info("Project Created: " + project);"
public class ProjectService {
    private static final Logger LOGGER =LoggerFactory.getLogger(ProjectService.class);

    private final ProjectRepository projectRepository;

    @Transactional
    public Project createProject(SaveProjectDataDTO saveProjectData){

        Project project = Project
                .builder() // Inicia com o builder e finaliza com o build.
                .name(saveProjectData.getName())
                .description(saveProjectData.getDescription())
                .inicialDate(saveProjectData.getInicialDate())
                .finalDate(saveProjectData.getFinalDate())
                .status(ProjectStatus.PENDING)
                .build();

        projectRepository.save(project);

        log.info("Project Created: " + project);

        return project;
    }

}
