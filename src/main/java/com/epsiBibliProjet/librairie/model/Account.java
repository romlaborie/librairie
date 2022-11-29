package com.epsiBibliProjet.librairie.model;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    private long id;
    private Date opened;
    //AcountSte
    @ManyToOne()
    private Library library;

    @OneToMany
    private List<BookItem> borrowed = new ArrayList<>();

    @OneToMany
    private List<BookItem> reserved = new ArrayList<>();

    public void addBookItem(BookItem bookItem){
        if(borrowed.size() <= 12){
            borrowed.add(bookItem);
        }
    }

    public void addBookItReserved(BookItem bookItem){
        if(reserved.size() <= 3){
            //TODO EXCEPTION boolen pour indiquer si ca marché ou pas!
            reserved.add(bookItem);
        }
    }
}
