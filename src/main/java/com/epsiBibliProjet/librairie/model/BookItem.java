package com.epsiBibliProjet.librairie.model;

import com.epsiBibliProjet.librairie.enumator.Format;
import com.epsiBibliProjet.librairie.enumator.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String ISBN;

    private String RFID;
    private String barcode;

    private String subject;
    private String title;
    private boolean isReferenceOnly;
    private Language lang;
    private int numberOfPages;
    private Format format;
    private Date borrowed;
    private int loanPeriod;
    private boolean isOverdue;
    private Date dueDate;


}