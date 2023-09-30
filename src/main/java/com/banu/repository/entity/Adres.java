package com.banu.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class Adres {

    private String il;
    private String ilce;
    private String Sokak;
    private String No;
    private String Daire;
}
