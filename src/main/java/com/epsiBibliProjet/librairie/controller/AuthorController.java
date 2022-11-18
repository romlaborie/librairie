package com.epsiBibliProjet.librairie.controller;

import com.epsiBibliProjet.librairie.model.Author;
import com.epsiBibliProjet.librairie.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/add_auteur")
    public void saveAuthor(@RequestBody Author author){
        authorService.addAuthor(author);
    }
}
