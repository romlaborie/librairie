package com.epsiBibliProjet.librairie.model;

import com.epsiBibliProjet.librairie.enumator.BookStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Data
@NoArgsConstructor
public abstract class  Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    private String isbn;

    private String name;

    private String subject;

    private String overview;

    private String publisher;

    private Date publicationDate;

    private String lang;

    @Enumerated(EnumType.STRING)
    private BookStatus status;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    @JsonBackReference
    private List<Author> authors = new ArrayList<>();

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void deleteAuthor(Author author) {
        authors.remove(author);
    }
}
