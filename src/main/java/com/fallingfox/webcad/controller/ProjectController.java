package com.fallingfox.webcad.controller;

import com.fallingfox.webcad.model.dto.ProjectDto;
import com.fallingfox.webcad.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webcad/project")
public class ProjectController {

    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }


    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<ProjectDto> findAll() {
        return service.findAllValid();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public ProjectDto create(@RequestBody ProjectDto dto) {
        return service.create(dto);
    }






}
