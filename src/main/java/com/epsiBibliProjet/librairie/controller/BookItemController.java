package com.epsiBibliProjet.librairie.controller;

import com.epsiBibliProjet.librairie.dto.BookDto;
import com.epsiBibliProjet.librairie.dto.BookItemDto;
import com.epsiBibliProjet.librairie.model.BookItem;
import com.epsiBibliProjet.librairie.service.BookItemService;
import com.epsiBibliProjet.librairie.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookItemController {

    @Autowired
    private BookItemService bookItemService;

    @Autowired
    private BookService bookService;

    @PostMapping("/bookItem")
    public void add(@RequestBody BookDto book){

       bookItemService.addBookItem(book);
    }

    @GetMapping("/bookItems")
    public List<BookItem> all(){
        return bookItemService.getAll();

    }
}
