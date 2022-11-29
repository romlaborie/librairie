package com.epsiBibliProjet.librairie.service;

import com.epsiBibliProjet.librairie.model.Book;

public interface Manage {

   void addBook(Book book);
   Book edit(Book book, long id);
   void delete(long bookId);




}
