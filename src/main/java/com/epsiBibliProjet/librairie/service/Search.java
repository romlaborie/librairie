package com.epsiBibliProjet.librairie.service;

import com.epsiBibliProjet.librairie.model.Book;
import com.epsiBibliProjet.librairie.model.BookItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Search {

    List<Book> searchByTitle(String term);

   List<Book> searchByAuthorName(String nameAuthor);

}
