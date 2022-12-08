package com.epsiBibliProjet.librairie.repository;

import com.epsiBibliProjet.librairie.model.Librarian;
import com.epsiBibliProjet.librairie.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrarianRepository extends JpaRepository<Librarian, Long> {


}
