package com.banu.repository.entity;

import com.banu.enums.ETur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tbl_kitap")

@NamedQuery(
        name = "basimYilinaGoreBul",
        query = " FROM Kitap WHERE basimYili > :deger")



public class Kitap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ad;

    private Integer basimYili;

    private Integer rafNo;

    private Integer sayfaSayisi;

    private Long ISBN;

    @Enumerated(EnumType.STRING)
    private ETur tur;

    @Embedded
    private BaseEntity baseEntity;
}
