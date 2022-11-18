package com.epsiBibliProjet.librairie.controller;

import com.epsiBibliProjet.librairie.model.Book;
import com.epsiBibliProjet.librairie.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/ajout_livre")
    public void saveBook(@RequestBody Book book){
        bookService.addBook(book);
    }
}
