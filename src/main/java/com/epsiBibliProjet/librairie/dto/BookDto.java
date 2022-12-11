package com.epsiBibliProjet.librairie.dto;

import com.epsiBibliProjet.librairie.enumator.BookStatus;
import com.epsiBibliProjet.librairie.enumator.Format;
import com.epsiBibliProjet.librairie.enumator.Language;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

    private String barcode;

    private String title;

    private String tag;

    private boolean isReferenceOnly;

    private int numberOfPages;

    private Language language;


    private Format format;

    private String library;

    private BookStatus status;

    private List<Long> authorIds;
}
