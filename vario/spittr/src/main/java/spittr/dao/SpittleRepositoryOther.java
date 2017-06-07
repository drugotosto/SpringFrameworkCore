package spittr.dao;

import spittr.model.Spittle;

import java.util.List;

/**
 * Created by drugo on 07/06/2017.
 */
public interface SpittleRepositoryOther {

    List<Spittle> trovaSpittles(long max, int count);

    public List<Spittle> findRecentSpittles(int count);

    public List<Spittle> findFirst5ByOrderByTimeDesc();

}
