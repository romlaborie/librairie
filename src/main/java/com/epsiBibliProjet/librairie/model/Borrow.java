package com.epsiBibliProjet.librairie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Account borrower;

    private LocalDate borrowed;

    private int loanPeriod;

    private boolean isOverdue;

    private LocalDate dueDate;

    @ManyToOne
    private Book book;

  /**  public Borrow(Account borrower,  int loanPeriod) {
        this.borrower = borrower;
        this.borrowed = Calendar.getInstance();
        this.loanPeriod = loanPeriod;
        this.isOverdue = false;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, loanPeriod);
        this.dueDate = calendar;
    }

   **/


}
