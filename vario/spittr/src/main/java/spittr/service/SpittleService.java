package spittr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spittr.dao.SpittleRepository;
import spittr.model.Spittle;

import java.util.List;

/**
 * Created by drugo on 13/06/2017.
 */
@Service
public class SpittleService implements LoggerAspectInfo {

    @Autowired
    private SpittleRepository spittleRepository;

    public void printMessage() {
    }

    public List<Spittle> getRecentSpittles(){
        printMessage();
        return spittleRepository.findFirst5ByOrderByTimeDesc();
    }
}
