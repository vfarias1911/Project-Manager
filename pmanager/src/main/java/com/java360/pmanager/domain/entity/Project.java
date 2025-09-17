package com.java360.pmanager.domain.entity;

import com.java360.pmanager.domain.model.ProjectStatus;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="project")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @Column(name = "description", nullable = false, length = 150)
    private String description;

    @Column(name = "inicial_date", nullable = false)
    private LocalDate inicialDate;

    @Column(name = "final_date", nullable = false)
    private LocalDate finalDate;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING) // O status será uma string e na tabela ficará a informação "Em progress"
    private ProjectStatus status; // Variável se refere ao Model.ProjectStatus. Possíveis status são: PENDING, IN_PROGRESS, FINISHED




}
