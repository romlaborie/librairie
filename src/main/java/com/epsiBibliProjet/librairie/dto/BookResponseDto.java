package com.epsiBibliProjet.librairie.dto;

import lombok.Data;

import java.util.List;

@Data
public class BookResponseDto {
    private Long id;
    private String name;
    private List<String> authorNames;
}
