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
@NoArgsConstructor
@SuperBuilder
public class BookItem extends Book {
    private String isbn;
    private String subject;
    private String barcode;
    private String title;
    private boolean isReferenceOnly;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Language.class)
    private List<Language> language;

    private int numberOfPages;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Format.class)
    private List<Format> formats;
    @ManyToOne
    @JoinColumn(name = "library_name")
    private Library library;


}