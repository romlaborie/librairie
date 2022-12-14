package com.epsiBibliProjet.librairie.controller;

import com.epsiBibliProjet.librairie.dto.BookDto;
import com.epsiBibliProjet.librairie.model.Book;
import com.epsiBibliProjet.librairie.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/ajout_livre")
   // @PostAuthorize("hasAuthority('LIBRA_RIAN')")
    public void saveBook(@RequestBody BookDto book){
        bookService.addBook(book);
    }

    @GetMapping("/listeBook")
    public List<Book> listBooks(){
        return bookService.getAll();
    }
    @GetMapping("/recherche_par_titre")
    public List<Book> recherche(@RequestParam String titre){
        List<Book> books = bookService.searchByTitle(titre);
        return books;
    }

    @GetMapping("/recherche_par_nom_auteur")
    public List<Book> chearchByAuthorName(@RequestParam String auteurName){
        List<Book> books = bookService.searchByAuthorName(auteurName);
        return books;
    }


    @GetMapping("/allBooks")
    public List<Book> allBooks(){
        List<Book> books = bookService.getAllBooks();
        return books;
    }
}
