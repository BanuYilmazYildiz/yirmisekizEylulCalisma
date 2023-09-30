package com.banu;

import com.banu.repository.entity.Kitap;
import com.banu.utility.HibernateUtility;
import org.hibernate.Session;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class Odev {

    public static void main(String[] args) {
        /**
         * NativeQuery, SQL sorgu dilinin direkt olarak kullanılarak sorgu yapılmasını sağlayan programlama dilidir.
         */

        EntityManager entityManager = HibernateUtility.getSessionFactory().createEntityManager();
        //CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();


        System.out.println("********** Native Query *********");

        String sql = "SELECT * FROM tbl_kitap WHERE basimYili > :deger";
        List<Kitap> kitapList = entityManager.createNativeQuery(sql, Kitap.class).setParameter("deger",2000).getResultList();

        // Sonucu kullanmak için kitapList'i kullanabilirsiniz.
        for (Kitap kitap : kitapList) {
            System.out.println(kitap.getId() + " - " + kitap.getAd() + " - " + kitap.getBasimYili());
        }



        /**
         *  HQL, Hibernate isimli bir ORM (Object-Relational Mapping) çerçevesinin özgün sorgu diliyken
         *  Entity sinifi ile seslenilir
         */
        Session session = HibernateUtility.getSessionFactory().openSession();

        String hql = "FROM Kitap WHERE basimYili > :deger"; // "Kitap" sınıf adını kullanın
        Query query = session.createQuery(hql);
        List<Kitap> kitapList1 = query.setParameter("deger", 2000).getResultList();

        System.out.println("********** HQL Query *********");

        for (Kitap kitap : kitapList1) {
            System.out.println(kitap.getId() + " - " + kitap.getAd() + " - " + kitap.getBasimYili());
        }



        /**
         * JPQL (Java Persistence Query Language) JPA kullanılan bir proje için kullanılır, HQL ile benzerdir
         * Entity sinifi ile seslenilir
         */


        String jpql = "SELECT k FROM Kitap k WHERE k.basimYili > :deger";
        TypedQuery<Kitap> query2 = entityManager.createQuery(jpql, Kitap.class);

        List<Kitap> kitapList2 = query2.setParameter("deger", 2000).getResultList();

        System.out.println("********** JPQL Query *********");

        for (Kitap kitap : kitapList2) {
            System.out.println(kitap.getId() + " - " + kitap.getAd() + " - " + kitap.getBasimYili());
        }

        /**
         * NamedQuery, JPA  tarafından sunulan bir özelliktir ve isimlendirilmiş sorguları
         * tanımlamak ve kullanmak için kullanılır.
         * Bu, sıkça kullanılan sorguları önceden tanımlamanıza ve kodunuzu daha okunaklı hale getirmenize olanak tanır.
         */

       // EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate.cfg.xml");
       // EntityManager em = emf.createEntityManager();

        Query query4 = session.createNamedQuery("basimYilinaGoreBul",Kitap.class);
        List<Kitap> kitapList3 = query4.setParameter("deger", 2000).getResultList();

        System.out.println("********** Named Query *********");

        for (Kitap kitap : kitapList3) {
            System.out.println(kitap.getId() + " - " + kitap.getAd() + " - " + kitap.getBasimYili());
        }
    }
}
