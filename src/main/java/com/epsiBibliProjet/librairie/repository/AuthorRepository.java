package com.epsiBibliProjet.librairie.repository;

import com.epsiBibliProjet.librairie.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author , Long> {
}
