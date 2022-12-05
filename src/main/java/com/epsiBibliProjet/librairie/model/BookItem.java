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
    private String rfid;

    private String barcode;

    private boolean isReferenceOnly;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Language.class)
    private List<Language> language;

    private int numberOfPages;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Format.class)
    private List<Format> formats;

    private Date borrowed;

    private int loanPeriod;

    private boolean isOverdue;

    private Date dueDate;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;


}