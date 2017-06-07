package spittr.dao;

import spittr.model.Spitter;

/**
 * Created by drugo on 19/05/2017.
 */
public interface SpitterRepository {

    /*Salvataggio del nuovo Spitter*/
    Spitter save(Spitter spitter);

    /*Ritona dello Spitter che presenta il certo "username"*/
    Spitter findByUsername(String username);

}
