package com.epsiBibliProjet.librairie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@DiscriminatorValue("librarian")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Librarian  extends Account{

    private  String  position;

    @Embedded
    private FullName name;

    @Embedded
    private Address address;


}