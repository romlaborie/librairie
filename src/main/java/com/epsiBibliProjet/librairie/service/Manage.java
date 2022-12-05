package com.epsiBibliProjet.librairie.service;

import com.epsiBibliProjet.librairie.dto.BookDto;
import com.epsiBibliProjet.librairie.model.Book;

public interface Manage {

   void addBook(BookDto book);
   Book edit(Book book, long id);
   void delete(long bookId);




}
