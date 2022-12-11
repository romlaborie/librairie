package com.epsiBibliProjet.librairie.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@DiscriminatorValue("patron")
@Data

public class Patron extends Account  {



}