package com.epsiBibliProjet.librairie.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Entity
@NoArgsConstructor
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Account account;

    private Calendar borrowed;

    private int loanPeriod;

    private boolean isOverdue;

    private Calendar dueDate;

    public Borrow(Account account,  int loanPeriod) {
        this.account = account;
        this.borrowed = Calendar.getInstance();
        this.loanPeriod = loanPeriod;
        this.isOverdue = false;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, loanPeriod);
        this.dueDate = calendar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Calendar getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(Calendar borrowed) {
        this.borrowed = borrowed;
    }

    public int getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(int loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public boolean isOverdue() {
        return isOverdue;
    }

    public void setOverdue(boolean overdue) {
        isOverdue = overdue;
    }

    public Calendar getDueDate() {
        return dueDate;
    }

    public void setDueDate(Calendar dueDate) {
        this.dueDate = dueDate;
    }
}
