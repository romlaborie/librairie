package com.epsiBibliProjet.librairie.model;

import java.util.ArrayList;
import java.util.List;

public class History {

    private List<Book> borrowed = new ArrayList<>();
    private List<Book> reserved = new ArrayList<>();

    public int getNombreBorrowed(){

        return this.borrowed.size();
    }
    public int getNombreReserved(){

        return this.reserved.size();
    }

    public boolean tooManyBooksBorrowed(){

        if (this.getNombreBorrowed()>12){
            return true;
        }
        return false;
    }
    public boolean tooManyBooksReserved(){

        if (this.getNombreReserved()>3){
            return true;
        }
        return false;
    }

}
