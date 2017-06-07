package spittr.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spittr.model.Spitter;

import javax.persistence.*;

/**
 * Created by drugo on 29/05/2017.
 */
@Repository
@Transactional
public class JpaSpitterRepository implements SpitterRepository{

    /*
    EntityManager is called a persistence context because it’s available at run time.
    The persistence context is the bridge between application and database run times.
    Using persistence context, you can solely operate on entities, load them, change their states,
    persist new ones, or delete already loaded ones. It helps you to manage transactions and so on...
     */
    @PersistenceContext
    private EntityManager em;

    public Spitter save(Spitter spitter) {
        em.persist(spitter);
        System.out.println("\nUtente salvato!");
        return spitter;
    }

    public Spitter findByUsername(String username) {
        return null;
    }
}
