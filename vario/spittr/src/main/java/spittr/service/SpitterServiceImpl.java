package spittr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spittr.dao.SpitterRepository;
import spittr.dao.SpittleRepository;
import spittr.model.Spitter;

/**
 * Created by drugo on 13/06/2017.
 */
@Service
public class SpitterServiceImpl implements SpitterService {

    @Autowired
    private SpitterRepository spitterRepository;

    public Spitter saveUser(Spitter spitter) {
        return spitterRepository.save(spitter);
    }

    public Spitter trovaSpitter(String username) {
        return spitterRepository.findByUsername(username);
    }
}
