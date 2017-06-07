package spittr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spittr.model.Spittle;
import java.util.List;

/**
 * Created by drugo on 18/05/2017.
 */

/*
    The key to writing a Spring Data JPA repository is to extend one of a handful of interfaces.
    You won’t be writing any implementations of SpitterRepository. Instead, you’ll let Spring Data do it for you.
    It creates an implementation of SpitterRepository, including an implementation of all 18 methods inherited from
    JpaRepository, PagingAndSortingRepository, and CrudRepository
*/
public interface SpittleRepository extends JpaRepository<Spittle,Long>, SpittleRepositoryOther {

//    public List<Spittle> findFirst5ByOrderByTimeDesc();

    public Spittle findById(long id);

}
