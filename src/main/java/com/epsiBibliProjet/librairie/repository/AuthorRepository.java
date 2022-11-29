package com.epsiBibliProjet.librairie.repository;

import com.epsiBibliProjet.librairie.model.Author;
import com.epsiBibliProjet.librairie.model.BookItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author , Long> {

    List<BookItem> findByName(String name);
}