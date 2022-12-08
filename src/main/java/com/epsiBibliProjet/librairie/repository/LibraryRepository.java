package com.epsiBibliProjet.librairie.repository;

import com.epsiBibliProjet.librairie.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Long> {

    Library findLibraryByName(String name);
}
