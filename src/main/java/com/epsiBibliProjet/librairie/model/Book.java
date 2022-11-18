package com.epsiBibliProjet.librairie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String ISBN;

    private String name;

    private String subject;

    private String overview;

    private String publisher;

    private Date publicationDate;

    private String lang;

    @ManyToMany
    @JoinTable(name = "T_Book_Author_Associations", joinColumns = @JoinColumn(name="id"), inverseJoinColumns = @JoinColumn(name="id"))
    @NotBlank
    private List<Author> authors = new ArrayList<>();

}
