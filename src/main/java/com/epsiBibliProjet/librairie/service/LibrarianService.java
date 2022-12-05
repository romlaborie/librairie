package com.epsiBibliProjet.librairie.service;


import com.epsiBibliProjet.librairie.model.Librarian;
import com.epsiBibliProjet.librairie.repository.LibrarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibrarianService {

    @Autowired
    private LibrarianRepository librarianRepository;

    public void addLibrarian(Librarian librarian){
        Librarian librarian1 = new Librarian();
        librarian1.setAddress(librarian.getAddress());
        librarian1.setName(librarian.getName());

        librarianRepository.save(librarian1);
    }
}
