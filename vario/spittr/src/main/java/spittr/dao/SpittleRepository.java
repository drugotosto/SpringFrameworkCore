package spittr.dao;

import spittr.model.Spittle;
import java.util.List;

/**
 * Created by drugo on 18/05/2017.
 */

/*
    Interfaccia relativa al repository per accesso ai dati nel DB
*/
public interface SpittleRepository {

    /*Ritorna i 10 Spittles più recenti*/
    List findRecentSpittles();

    /*Ritorna i primi "count" Spittles più recenti*/
    List<Spittle> findRecent(int count);

    /*
        The findSpittles() method takes two parameters. The max parameter is a Spittle
        ID that represents the maximum ID of any Spittle that should be returned. As for the
        count parameter, it indicates how many Spittle objects to return.
        Usato per recuperare "tot" Spittles alla volta paginandoli opportunamente
    */
    List<Spittle> findSpittles(long max, int count);

    /*Ritona lo Spittle con il particolare "id"*/
    Spittle findOne(long id);

    /*Salvataggio dello Spittle sul DB*/
    void save(Spittle spittle);

}
