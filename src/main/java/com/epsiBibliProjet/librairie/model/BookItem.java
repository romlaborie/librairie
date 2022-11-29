package com.epsiBibliProjet.librairie.model;

import com.epsiBibliProjet.librairie.enumator.Format;
import com.epsiBibliProjet.librairie.enumator.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookItem extends Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String ISBN;

    private String RFID;

    private String barcode;

    private String subject;

    private String title; //nom du livre

    private boolean isReferenceOnly;

    @Enumerated(EnumType.STRING)
    private Language language;

    private int numberOfPages;

    @Enumerated(EnumType.STRING)
    private Format format;

    private Date borrowed;

    private int loanPeriod;

    private boolean isOverdue;

    //Pas de setter
    private Date dueDate;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;




}