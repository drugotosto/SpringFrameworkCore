package spittr.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spittr.model.Spittle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by drugo on 31/05/2017.
 */
@Repository
/*
All public methods of the class become transactional
 */
@Transactional
public class JpaSpittleRepository implements SpittleRepository{

    /*
    At run time, Spring Container creates an EntityManager bound to the currently
    active transaction and injects that instance into this field.
    */
    @PersistenceContext
    private EntityManager em;

    public List<Spittle> findRecentSpittles() {
       return this.findRecent(10);
    }

    public List<Spittle> findRecent(int count) {
        // Utilizzo del linguaggio di interrogazione JPA QL
        TypedQuery<Spittle> query = em.createQuery("select s from Spittle as  s order by s.time desc",Spittle.class).setFirstResult(0).setMaxResults(count);
        List<Spittle> results = query.getResultList();
        return results;
    }

    public List<Spittle> findSpittles(long max, int count) {
        return null;
    }

    public Spittle findOne(long id) {
        return null;
    }

    public void save(Spittle spittle) {
        em.persist(spittle);
        System.out.println("\nSpittle salvato!");
    }
}
