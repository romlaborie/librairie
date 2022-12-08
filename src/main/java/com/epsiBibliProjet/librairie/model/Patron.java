package com.epsiBibliProjet.librairie.model;

import com.epsiBibliProjet.librairie.dto.BookDto;
import com.epsiBibliProjet.librairie.service.Manage;
import com.epsiBibliProjet.librairie.service.Search;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@DiscriminatorValue("patron")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patron extends Account  {

    @Embedded
    @NotBlank
    private FullName name;

    @Embedded
    @NotBlank
    private Address address;

}