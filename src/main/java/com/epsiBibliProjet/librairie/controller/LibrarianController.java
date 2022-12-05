package com.epsiBibliProjet.librairie.controller;

import com.epsiBibliProjet.librairie.model.Librarian;
import com.epsiBibliProjet.librairie.service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibrarianController {

    @Autowired
    private LibrarianService librarianService;

    @PostMapping("/librarian")
    public void add(@RequestBody Librarian librarian){
        librarianService.addLibrarian(librarian);
    }
}
