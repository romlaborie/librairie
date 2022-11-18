package com.epsiBibliProjet.librairie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank
    private FullName name;

    private Address address;
    @Basic(optional = false)
    public FullName getName() {
        return name;
    }
    @Basic(optional = false)
    public Address getAddress() {
        return address;
    }
}