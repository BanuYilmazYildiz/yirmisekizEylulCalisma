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
public class Iletisim {

    String cepTelefonu;
    String evTelefonu;
    String isTelefonu;
    String email;
}
