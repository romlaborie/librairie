package com.epsiBibliProjet.librairie.service;

import com.epsiBibliProjet.librairie.model.Author;
import com.epsiBibliProjet.librairie.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public void addAuthor(Author author){
        authorRepository.save(author);

    }
}
