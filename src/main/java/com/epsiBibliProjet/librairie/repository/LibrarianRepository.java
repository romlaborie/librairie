package com.epsiBibliProjet.librairie.repository;

import com.epsiBibliProjet.librairie.model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrarianRepository extends JpaRepository<Librarian, Long> {
}
