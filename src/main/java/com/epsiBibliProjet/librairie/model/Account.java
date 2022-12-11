package com.epsiBibliProjet.librairie.model;

import com.epsiBibliProjet.librairie.enumator.AccountState;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type", discriminatorType = DiscriminatorType.STRING)
@Data
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Enumerated(EnumType.STRING)
    private AccountState state;

    private Date opened;

    @Embedded
    private FullName name;

    @Embedded

    private Address address;

    public Account(){
        this.opened = new Date();
    }

    @ManyToOne()
    private Library library;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRole> appRoles;
}
