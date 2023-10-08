package com.fallingfox.webcad.model.entity;

import com.fallingfox.webcad.model.enums.Unit;
import com.fallingfox.webcad.model.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Project")
public class Project {

    @Id
    @Column(unique = true, name = "Name", updatable = false)
    String name;
    @Column(name = "Unit", updatable = false)
    @Enumerated(EnumType.STRING)
    Unit unit;
    @Column(name = "CreationDate", updatable = false)
    LocalDate creationDate;
    @Column(name = "UpdateDate")
    LocalDate lastUpdated;
    @Column(name = "Status", updatable = false)
    @Enumerated(EnumType.STRING)
    Status status;


    public String getName() {
        return name;
    }

    public Project setName(String name) {
        this.name = name;
        return this;
    }

    public Unit getUnit() {
        return unit;
    }

    public Project setUnit(Unit unit) {
        this.unit = unit;
        return this;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Project setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public Project setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Project setStatus(Status status) {
        this.status = status;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(name, project.name) && unit == project.unit && Objects.equals(creationDate, project.creationDate) && Objects.equals(lastUpdated, project.lastUpdated) && status == project.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, unit, creationDate, lastUpdated, status);
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", metric=" + unit +
                ", creationDate=" + creationDate +
                ", lastUpdated=" + lastUpdated +
                ", status=" + status +
                '}';
    }
}
