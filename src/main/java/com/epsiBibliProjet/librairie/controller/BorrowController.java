package com.epsiBibliProjet.librairie.controller;

import com.epsiBibliProjet.librairie.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @PostMapping("/emprunter/{bookId}")
    @PostAuthorize("hasAuthority('PATRON')")
    public void createBorrow(@PathVariable Long bookId, Principal principal){
        borrowService.createBorrow(bookId, principal.getName());
    }
    @PostMapping("/reserver/{bookId}")
    @PostAuthorize("hasAuthority('PATRON')")
    public void reservation(@PathVariable Long bookId, Principal principal){
        borrowService.reserver(bookId,  principal.getName());
    }
}
