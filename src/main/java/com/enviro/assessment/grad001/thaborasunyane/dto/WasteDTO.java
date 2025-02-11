package com.enviro.assessment.grad001.thaborasunyane.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class WasteDTO {

    @NotBlank(message = "Waste name is required")
    private String name;

    @NotBlank(message = "Disposal method is required")
    private String disposal;

    @NotBlank(message = "Recycling tips are required")
    private String recyclingTips;

    @NotBlank(message = "Category is required")
    private String category;
}
