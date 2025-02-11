package com.enviro.assessment.grad001.thaborasunyane.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "waste_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Waste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Waste name is required")
    private String name;

    @NotBlank(message = "Disposal method is required")
    private String disposal;

    @NotBlank(message = "Recycling tips are required")
    private String recyclingTips;

    @NotBlank(message = "Category is required")
    private String category;

}
