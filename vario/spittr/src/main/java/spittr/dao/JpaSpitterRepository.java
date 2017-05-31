package spittr.dao;

import org.springframework.stereotype.Repository;
import spittr.model.Spitter;

import javax.persistence.*;

/**
 * Created by drugo on 29/05/2017.
 */
@Repository
public class JpaSpitterRepository implements SpitterRepository{

    @PersistenceContext
    private EntityManager em;

    public Spitter save(Spitter spitter) {
        em.persist(spitter);
        em.close();
        System.out.println("\nUtente salvato!");
        return spitter;
    }

    public Spitter findByUsername(String username) {
        return null;
    }
}
