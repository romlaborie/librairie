package com.epsiBibliProjet.librairie.service;

import com.epsiBibliProjet.librairie.model.Account;
import com.epsiBibliProjet.librairie.model.Book;
import com.epsiBibliProjet.librairie.model.BookItem;
import com.epsiBibliProjet.librairie.repository.AccountRepository;
import com.epsiBibliProjet.librairie.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AccountRepository accountRepository;


    public void createBorrow(Long bookId,  Long idUserConnected){
        List<BookItem> bookItems = new ArrayList<>();
        Optional<Account> borrower = accountRepository.findById(idUserConnected);
        Optional<Book> book = bookRepository.findById(bookId);


    }
}
