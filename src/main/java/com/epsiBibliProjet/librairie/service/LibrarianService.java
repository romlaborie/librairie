package com.epsiBibliProjet.librairie.service;


import com.epsiBibliProjet.librairie.model.Librarian;
import com.epsiBibliProjet.librairie.model.Library;
import com.epsiBibliProjet.librairie.repository.LibrarianRepository;
import com.epsiBibliProjet.librairie.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibrarianService {

    @Autowired
    private LibrarianRepository librarianRepository;

    @Autowired
    private LibraryRepository libraryRepository;

    public void addLibrarian(Librarian librarianSaved){
        Optional<Library> library = libraryRepository.findById(librarianSaved.getLibrary().getId());
        Librarian librarian = new Librarian();
        librarian.setAddress(librarianSaved.getAddress());
        librarian.setName(librarianSaved.getName());
        librarian.setLibrary(library.get());

        librarianRepository.save(librarian);
    }
}
