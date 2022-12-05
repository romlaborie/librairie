package com.epsiBibliProjet.librairie.service;


import com.epsiBibliProjet.librairie.model.Library;
import com.epsiBibliProjet.librairie.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    public void addLibrary(Library boody){

        Library library = new Library();
        library.setAddress(boody.getAddress());
        library.setName(boody.getName());

        libraryRepository.save(library);
    }
}
