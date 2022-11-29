package com.epsiBibliProjet.librairie.controller;

import com.epsiBibliProjet.librairie.model.Book;
import com.epsiBibliProjet.librairie.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/ajout_livre")
    public void saveBook(@RequestBody Book book){
        bookService.addBook(book);
    }

    @GetMapping("/books")
    public List<Book> recherche(@RequestParam String titre){
        List<Book> books = bookService.searchByTitle(titre);
        return books;
    }

    @GetMapping("/all")
    public List<Book> recherche(){
        List<Book> books = bookService.getAllBooks();
        return books;
    }
}
