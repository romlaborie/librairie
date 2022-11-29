package com.epsiBibliProjet.librairie.model;

import com.epsiBibliProjet.librairie.service.Manage;
import com.epsiBibliProjet.librairie.service.Search;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patron  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Embedded
    private FullName name;

    @Embedded
    private Address address;
    @Transient
    private Search search;

    @Transient
     private Manage manage;

    public List<Book> searchByAuthor(String authorName){
    return this.search.searchByTitle(authorName);
    }

    public List<Book> searchByTitle(String term) {
        return this.search.searchByTitle(term);
    }

    public List<Book> searchByAuthorName(String nameAuthor) {
        return this.search.searchByAuthorName(nameAuthor);
    }
    public void add(Book book) {
         this.manage.addBook(book);
    }

    public Book edit(Book book, long id) {
        return this.manage.edit(book, id);
    }
    public void delete(long id) {
      this.manage.delete(id);
    }

}