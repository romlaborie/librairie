package com.epsiBibliProjet.librairie.repository;

import com.epsiBibliProjet.librairie.model.BookItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookItemRepository extends JpaRepository<BookItem, Long> {

    BookItem findByTitle(String name);
}
