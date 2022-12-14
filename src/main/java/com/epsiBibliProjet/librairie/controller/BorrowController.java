package com.epsiBibliProjet.librairie.controller;

import com.epsiBibliProjet.librairie.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @PostMapping("/emprunter/{bookId}")
    public void createBorrow(@PathVariable Long bookId, Principal principal){
        borrowService.createBorrow(bookId);
    }


    @PostMapping("/reserver/{bookId}")
    public void reservation(@PathVariable Long bookId, Principal principal){
        borrowService.reserver(bookId);
    }
}
