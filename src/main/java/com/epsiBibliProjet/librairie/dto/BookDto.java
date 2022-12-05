package com.epsiBibliProjet.librairie.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BookDto {
    private String name;
    private String isbn;
    private String subject;
    private String overview;

    private String publisher;

    private Date publicationDate;

    private String lang;

    private List<Long> authorIds;
}
