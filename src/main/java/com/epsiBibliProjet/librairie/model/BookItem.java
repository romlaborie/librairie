package com.epsiBibliProjet.librairie.model;

import com.epsiBibliProjet.librairie.enumator.Format;
import com.epsiBibliProjet.librairie.enumator.Language;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@PrimaryKeyJoinColumn( name = "bookId" )
@SuperBuilder
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