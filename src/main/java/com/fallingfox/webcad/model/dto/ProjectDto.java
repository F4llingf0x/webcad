package com.fallingfox.webcad.model.dto;

import com.fallingfox.webcad.model.enums.Unit;
import com.fallingfox.webcad.model.enums.Status;

import java.time.LocalDate;
import java.util.Objects;

public class ProjectDto {

    String name;
    Unit unit;
    LocalDate creationDate;
    LocalDate lastUpdated;
    Status status;


    public String getName() {
        return name;
    }

    public ProjectDto setName(String name) {
        this.name = name;
        return this;
    }

    public Unit getUnit() {
        return unit;
    }

    public ProjectDto setUnit(Unit unit) {
        this.unit = unit;
        return this;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public ProjectDto setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public ProjectDto setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public ProjectDto setStatus(Status status) {
        this.status = status;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectDto that = (ProjectDto) o;
        return Objects.equals(name, that.name) && unit == that.unit && Objects.equals(creationDate, that.creationDate) && Objects.equals(lastUpdated, that.lastUpdated) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, unit, creationDate, lastUpdated, status);
    }

    @Override
    public String toString() {
        return "ProjectDto{" +
                "name='" + name + '\'' +
                ", unit=" + unit +
                ", creationDate=" + creationDate +
                ", lastUpdated=" + lastUpdated +
                ", status=" + status +
                '}';
    }
}
