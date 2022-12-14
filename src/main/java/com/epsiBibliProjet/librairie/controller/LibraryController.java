package com.epsiBibliProjet.librairie.controller;

import com.epsiBibliProjet.librairie.model.Library;
import com.epsiBibliProjet.librairie.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping("/library")
    public void addLibrary(@RequestBody Library library){
        libraryService.addLibrary(library);
    }
}
