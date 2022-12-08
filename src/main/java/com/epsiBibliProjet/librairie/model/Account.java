package com.epsiBibliProjet.librairie.model;

import com.epsiBibliProjet.librairie.enumator.AccountState;
import com.epsiBibliProjet.librairie.enumator.Language;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type", discriminatorType = DiscriminatorType.STRING)
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private AccountState state;

    private Date opened;

    public Account(){
        this.opened = new Date();
    }

    @ManyToOne()
    private Library library;

  /**  @OneToMany
    private List<BookItem> borrowed = new ArrayList<>();

    @OneToMany
    private List<BookItem> reserved = new ArrayList<>();

    public void addBookItem(BookItem bookItem){
        if(borrowed.size() < 12){
            borrowed.add(bookItem);
        }
    }

    public void addBookItReserved(BookItem bookItem){
        if(reserved.size() < 3){
            //TODO EXCEPTION boolen pour indiquer si ca marché ou pas!
            reserved.add(bookItem);
        }
    }
    **/
}
