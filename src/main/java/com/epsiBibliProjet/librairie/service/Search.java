package com.epsiBibliProjet.librairie.service;

import com.epsiBibliProjet.librairie.model.Book;
import com.epsiBibliProjet.librairie.model.BookItem;

import java.util.List;

public interface Search {

    List<Book>searchByTitle(String term);

   List<Book> searchByAuthorName(String nameAuthor);

}
