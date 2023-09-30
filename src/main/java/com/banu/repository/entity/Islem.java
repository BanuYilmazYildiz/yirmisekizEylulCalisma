package com.banu.repository.entity;

import com.banu.enums.EIslemTur;
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
@Table(name = "tbl_islem")
public class Islem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated(EnumType.STRING)
    private EIslemTur islemTur;

    private Long uyeId;

    private Long kitapId;

    private BaseEntity baseEntity;


}
