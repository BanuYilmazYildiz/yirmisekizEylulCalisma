package com.banu.utility;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class MyFactoryRepository <T> implements ICrud<T>{

    private Session session;
    private Transaction transaction;

    private void openSession(){
        session = HibernateUtility.getSessionFactory().openSession();
        transaction= session.beginTransaction();
    }

    private void closeSession (){
        transaction.commit();
        session.close();
    }
    @Override
    public void save(T t) {
        openSession();
        session.save(t);
        closeSession();

    }

    @Override
    public void update(T t) {
        openSession();
        session.update(t);
        closeSession();

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public T findById() {
        return null;
    }
}
