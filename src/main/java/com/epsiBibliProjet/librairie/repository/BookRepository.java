package com.epsiBibliProjet.librairie.repository;

import com.epsiBibliProjet.librairie.enumator.BookStatus;
import com.epsiBibliProjet.librairie.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findById(long id);
    List<Book> findBookByName(String name);

    List<Book>findByStatusAndUserId(BookStatus status, Long userId);
    List<Book> findByUserIdAndDeletedFalse(Integer id);
}
