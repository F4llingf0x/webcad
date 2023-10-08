package com.fallingfox.webcad.model.mapper;

import com.fallingfox.webcad.model.dto.ProjectDto;
import com.fallingfox.webcad.model.entity.Project;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    /**
     * Convert entity to dto.
     *
     * @param dto which will be converted.
     * @return the entity.
     */
    Project dtoToEntity(ProjectDto dto);

    /**
     * Convert a dto to entity.
     *
     * @param entity which will be converted.
     * @return the entity.
     */
    ProjectDto entityToDto(Project entity);

}
