package com.epsiBibliProjet.librairie.service;

import com.epsiBibliProjet.librairie.model.Author;
import com.epsiBibliProjet.librairie.model.Book;
import com.epsiBibliProjet.librairie.repository.AuthorRepository;
import com.epsiBibliProjet.librairie.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public void addBook(Book transBook){
        List<Author> authors = authorRepository.findAll();
        Book book = new Book();
        book.setISBN(transBook.getISBN());
        book.setName(transBook.getName());
        book.setOverview(transBook.getOverview());
        book.setPublisher(transBook.getPublisher());
        book.setPublicationDate(transBook.getPublicationDate());
        book.setAuthors(authors);

        bookRepository.save(book);
    }
}
