package com.epsiBibliProjet.librairie.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@NoArgsConstructor
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Account borrower;

    private Calendar borrowed;

    private int loanPeriod;

    private boolean isOverdue;

    private Calendar dueDate;

    @ManyToOne
    private BookItem bookItem;

    public Borrow(Account borrower,  int loanPeriod) {
        this.borrower = borrower;
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

    public Account getBorrower() {
        return borrower;
    }

    public void setBorrower(Account borrower) {
        this.borrower = borrower;
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
