package com.fallingfox.webcad.controller;

import com.fallingfox.webcad.model.dto.ProjectDto;
import com.fallingfox.webcad.model.entity.Project;
import com.fallingfox.webcad.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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

    @GetMapping("/index")
    @ResponseStatus(HttpStatus.OK)
    public String index(Model model) {
        List<ProjectDto> projects = service.findAllValid();
        model.addAttribute("projects",projects);
        return "index";
    }





}
