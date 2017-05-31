package spittr.dao;

import org.springframework.stereotype.Repository;
import spittr.model.Spittle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by drugo on 31/05/2017.
 */
@Repository
public class JpaSpittleRepository implements SpittleRepository{

    @PersistenceContext
    private EntityManager em;

    public List<Spittle> findRecentSpittles() {
        return null;
    }

    public List<Spittle> findSpittles(long max, int count) {
        return null;
    }

    public Spittle findOne(long id) {
        return null;
    }
}
