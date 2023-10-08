package com.fallingfox.webcad.repository;

import com.fallingfox.webcad.model.entity.Project;
import com.fallingfox.webcad.model.enums.Status;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {

    @Transactional
    @Modifying
    @Query("UPDATE Project p " +
            "SET p.lastUpdated = :date " +
            "WHERE p.name = :name")
    void updateProjectDate(@Param("name") String name,
                           @Param("date") LocalDate currentDate);


    @Transactional
    @Modifying
    @Query("UPDATE Project p " +
            "SET p.status = :status " +
            "WHERE p.name = :name")
    void deleteProject(@Param("name") String name,
                       @Param("status") Status status);

    @Query("SELECT p FROM Project p " +
            "WHERE p.status = :status")
    List<Project> findAllValid(Status status);
}
