package com.ferrero.dao;

/**
 * Created by drugo on 31/05/2017.
 */
import com.ferrero.model.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

@Repository
public class StudentDaoJpaImpl implements StudentDao{

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    public void save(Student student) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(student);
        transaction.commit();
        entityManager.close();
    }
}