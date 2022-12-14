package com.epsiBibliProjet.librairie.model;

import com.epsiBibliProjet.librairie.enumator.Format;
import com.epsiBibliProjet.librairie.enumator.Language;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Data
public class BookItem extends Book {

    private String barcode;

    private String title;

    private String tag;
    private boolean isReferenceOnly;

    private int numberOfPages;

    @Enumerated(EnumType.STRING)
    private Language language;

    @Enumerated(EnumType.STRING)
    private Format format;

    private String library;

    public BookItem(){
        this.isReferenceOnly = false;
    }


}