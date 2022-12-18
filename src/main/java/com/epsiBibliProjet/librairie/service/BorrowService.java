package com.epsiBibliProjet.librairie.service;

import com.epsiBibliProjet.librairie.enumator.BookStatus;
import com.epsiBibliProjet.librairie.model.Account;
import com.epsiBibliProjet.librairie.model.Book;
import com.epsiBibliProjet.librairie.model.BookItem;
import com.epsiBibliProjet.librairie.model.Borrow;
import com.epsiBibliProjet.librairie.repository.AccountRepository;
import com.epsiBibliProjet.librairie.repository.BookRepository;
import com.epsiBibliProjet.librairie.repository.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private BorrowRepository borrowRepository;

    public List<Book> createBorrow(Long bookId, String name){
        List<Book> bookborrowed = new ArrayList<>();
        Optional<Book> book = bookRepository.findById(bookId);
        Account account = accountRepository.findByUsername(name);

        if(book.isPresent() && book.get().getStatus().equals(BookStatus.FREE)){
            Borrow borrow = new Borrow();
            borrow.setOverdue(false);
            Book bookEntity = book.get();
            borrow.setBook(bookEntity);
            borrow.setBorrower(account);
            borrow.setBorrowed(LocalDate.now());
            borrow.setDueDate(LocalDate.now());
            borrow.setOverdue(true);
            book.get().setStatus(BookStatus.BORROWED);
            if(bookborrowed.size() > 12){
                System.out.println("Vous avez atteint le nombre d'emprunt");
            }
            bookborrowed.add(bookEntity);
            borrowRepository.save(borrow);
            bookRepository.save(bookEntity);
        }


        return bookborrowed;
    }

    public List<Book> reserver(Long bookId, String name){
        List<Book> bookReserved = new ArrayList<>();
        Optional<Book> book = bookRepository.findById(bookId);
       Account account = accountRepository.findByUsername(name);
        if(book.isPresent() && book.get().getStatus().equals(BookStatus.FREE)){
            Borrow borrow = new Borrow();
            borrow.setOverdue(false);
            Book bookEntity = book.get();
            borrow.setBook(bookEntity);
            borrow.setBorrower(account);
            borrow.setBorrowed(LocalDate.now());
            borrow.setDueDate(LocalDate.now());
            borrow.setOverdue(true);
            book.get().setStatus(BookStatus.RESERVED);
            if(bookReserved.size() > 3){
                System.out.println("Vous avez atteint le nombre de reservation");
            }
            bookReserved.add(bookEntity);
            borrowRepository.save(borrow);
            bookRepository.save(bookEntity);
        }


        return bookReserved;
    }
}
