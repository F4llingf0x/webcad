package com.fallingfox.webcad.service;

import com.fallingfox.webcad.model.dto.ProjectDto;
import com.fallingfox.webcad.model.entity.Project;
import com.fallingfox.webcad.model.enums.Status;
import com.fallingfox.webcad.model.mapper.ProjectMapper;
import com.fallingfox.webcad.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository repository;
    private final ProjectMapper mapper;


    public ProjectService(ProjectRepository repository, ProjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    private Project getByName(String name) {
        return repository.findById(name).orElseThrow(
                () -> new IllegalArgumentException("Project not found with id: %s".formatted(name)));
    }

    public ProjectDto findByName(String name) {
        return mapper.entityToDto(getByName(name));
    }

    public List<ProjectDto> findAllValid() {
        List<Project> allValid = repository.findAllValid(Status.ACTIVE);
        return allValid.stream().map(mapper::entityToDto).toList();
    }

    public ProjectDto create(ProjectDto dto) {
        dto.setStatus(Status.ACTIVE);
        dto.setCreationDate(LocalDate.now());
        Project savedProject = repository.save(mapper.dtoToEntity(dto));
        return mapper.entityToDto(savedProject);
    }

    public void updateProjectUpdateDate(String name) {
        repository.updateProjectDate(name, LocalDate.now());
    }

    public void deleteProjectUpdateDate(String name) {
        repository.deleteProject(name, Status.DELETED);
    }

}
