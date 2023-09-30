package com.banu;

import com.banu.enums.ECinsiyet;
import com.banu.enums.EIslemTur;
import com.banu.enums.ETur;
import com.banu.repository.IslemRepository;
import com.banu.repository.KitapRepository;
import com.banu.repository.UyeRepository;
import com.banu.repository.YazarRepository;
import com.banu.repository.entity.*;

public class Main {
    public static void main(String[] args) {

        BaseEntity baseEntity = BaseEntity.builder()
                .createAt(System.currentTimeMillis())
                .state(1)
                .updateAt(System.currentTimeMillis())
                .isActive(true).build();

        YazarRepository yazarRepository = new YazarRepository();
        yazarRepository.save(Yazar.builder()
                .ad("Ebubekir")
                .soyad("Soyad")
                .kitapId(1L)
                .baseEntity(baseEntity).build());
        yazarRepository.save(Yazar.builder()
                .ad("Hatice")
                .soyad("Ergin")
                .kitapId(2L)
                .baseEntity(baseEntity).build());
        yazarRepository.save(Yazar.builder()
                .ad("Murat")
                .soyad("Can")
                .kitapId(3L)
                .baseEntity(baseEntity).build());
        yazarRepository.save(Yazar.builder()
                .ad("Ali")
                .soyad("Feyiz")
                .kitapId(4L)
                .baseEntity(baseEntity).build());

        KitapRepository kitapRepository = new KitapRepository();
        kitapRepository.save(Kitap.builder()
                .ad("Internet")
                .rafNo(2)
                .basimYili(2000)
                .ISBN(123456780L)
                .tur(ETur.BILGI)
                .baseEntity(baseEntity).build());
        kitapRepository.save(Kitap.builder()
                .ad("Algoritma")
                .rafNo(2)
                .basimYili(2010)
                .ISBN(123456781L)
                .tur(ETur.BILGI)
                .baseEntity(baseEntity).build());

        kitapRepository.save(Kitap.builder()
                .ad("Gelisim Psikolojisi")
                .rafNo(3)
                .basimYili(2017)
                .ISBN(123456786L)
                .tur(ETur.PISIKOLOJI)
                .baseEntity(baseEntity).build());

        kitapRepository.save(Kitap.builder()
                .ad("Cinayet Nedeni")
                .rafNo(5)
                .basimYili(2021)
                .ISBN(1234567834L)
                .tur(ETur.POLISIYE)
                .baseEntity(baseEntity).build());

        UyeRepository uyeRepository = new UyeRepository();
        uyeRepository.save(Uye.builder()
                .ad("Ayşe")
                .soyad("Kara")
                .cinsiyet(ECinsiyet.KADIN)
                .adres(Adres.builder().il("Kocaeli").ilce("Kartepe").build())
                .iletisim(Iletisim.builder().email("ak@mail.com").cepTelefonu("123456789").build())
                .baseEntity(baseEntity)
                .build());

        uyeRepository.save(Uye.builder()
                .ad("Ali")
                .soyad("Uçar")
                .cinsiyet(ECinsiyet.ERKEK)
                .adres(Adres.builder().il("İstanbul").ilce("Satıyer").build())
                .iletisim(Iletisim.builder().email("au@mail.com").cepTelefonu("123456780").build())
                .baseEntity(baseEntity)
                .build());

        uyeRepository.save(Uye.builder()
                .ad("Ahmet")
                .soyad("Davut")
                .cinsiyet(ECinsiyet.ERKEK)
                .adres(Adres.builder().il("İzmir").ilce("Bornovo").build())
                .iletisim(Iletisim.builder().email("ad@mail.com").cepTelefonu("123456781").build())
                .baseEntity(baseEntity)
                .build());

        uyeRepository.save(Uye.builder()
                .ad("Elif")
                .soyad("Uymaz")
                .cinsiyet(ECinsiyet.KADIN)
                .adres(Adres.builder().il("Kocaeli").ilce("İzmit").build())
                .iletisim(Iletisim.builder().email("eu@mail.com").cepTelefonu("123456787").build())
                .baseEntity(baseEntity)
                .build());

        IslemRepository islemRepository=new IslemRepository();
        islemRepository.save(Islem.builder()
                .uyeId(1L)
                .islemTur(EIslemTur.KIRALAMA)
                .kitapId(1L)
                .baseEntity(baseEntity)
                .build());

        islemRepository.save(Islem.builder()
                .uyeId(2L)
                .islemTur(EIslemTur.KIRALAMA)
                .kitapId(2L)
                .baseEntity(baseEntity)
                .build());

        islemRepository.save(Islem.builder()
                .uyeId(3L)
                .islemTur(EIslemTur.KIRALAMA)
                .kitapId(3L)
                .baseEntity(baseEntity)
                .build());
        islemRepository.save(Islem.builder()
                .uyeId(4L)
                .islemTur(EIslemTur.KIRALAMA)
                .kitapId(4L)
                .baseEntity(baseEntity)
                .build());








    }
}
