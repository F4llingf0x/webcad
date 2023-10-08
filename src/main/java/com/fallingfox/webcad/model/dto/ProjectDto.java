package com.fallingfox.webcad.model.dto;

import com.fallingfox.webcad.model.enums.Metric;
import com.fallingfox.webcad.model.enums.Status;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class ProjectDto {

    String name;
    Metric metric;
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

    public Metric getMetric() {
        return metric;
    }

    public ProjectDto setMetric(Metric metric) {
        this.metric = metric;
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
        return Objects.equals(name, that.name) && metric == that.metric && Objects.equals(creationDate, that.creationDate) && Objects.equals(lastUpdated, that.lastUpdated) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, metric, creationDate, lastUpdated, status);
    }

    @Override
    public String toString() {
        return "ProjectDto{" +
                "name='" + name + '\'' +
                ", metric=" + metric +
                ", creationDate=" + creationDate +
                ", lastUpdated=" + lastUpdated +
                ", status=" + status +
                '}';
    }
}
