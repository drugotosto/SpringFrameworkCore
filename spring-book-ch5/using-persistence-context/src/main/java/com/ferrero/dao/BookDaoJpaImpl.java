package com.ferrero.dao;

import com.ferrero.model.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BookDaoJpaImpl implements BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Book book) { entityManager.persist(book); }
}
