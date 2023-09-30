package com.banu.repository.entity;

import com.banu.enums.ECinsiyet;
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
@Table(name = "tbl_uye")
public class Uye {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String ad;
    private String soyad;

    @Enumerated(EnumType.STRING)
    private ECinsiyet cinsiyet;

    @Embedded
    private Iletisim iletisim;


    @Embedded
    private Adres adres;

    @Embedded
    private BaseEntity baseEntity;


}
