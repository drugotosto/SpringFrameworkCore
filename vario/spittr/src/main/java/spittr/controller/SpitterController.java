package spittr.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;
import spittr.model.Spitter;
import spittr.dao.SpitterRepository;
import spittr.service.SpitterService;

import java.util.Map;

/**
 * Created by drugo on 19/05/2017.
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController {

    static Logger logger = Logger.getLogger(SpitterController.class);

    private SpitterService spitterService;

    @Autowired
    public SpitterController(SpitterService spitterService) {
        this.spitterService= spitterService;
    }


    @RequestMapping(value="/register", method=RequestMethod.GET)
    public ModelAndView showRegistrationForm() {
        logger.debug(String.format("Richiesta pagina di registrazione utente!"));
        ModelAndView mav = new ModelAndView("registerForm");
        return mav;
    }

    /*
        The new processRegistration() method: it’s given a Spitter object as a parameter.
        This object has firstName, lastName, username, and password properties that will be populated from
        the request parameters of the same name.
        Once it’s called with the Spitter object, processRegistration() calls the save()
        method on the SpitterRepository that is now injected into SpitterController in
        the constructor.
     */
    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String processRegistration(Spitter spitter) {
        logger.debug(String.format("Salvataggio utente NOME: %s COGNOME: %s" ,spitter.getFirstName(),spitter.getLastName()));
        spitterService.saveUser(spitter);
        /*
          When InternalResourceViewResolver sees the redirect: prefix on the view specification,
          it knows to interpret it as a redirect specification instead of as a view name
        */
        return "redirect:/spitter/"+spitter.getUsername();
    }

    /*
        Viene azionato quando viene eseguito il redirect da parte di "processRegistration()".
        Ha il compito di andare a recuperare dal DB i valori dell'utente richiesto e visualizzare la relativa pagina profilo utente.
        Es: ... /spitter/pippo
    */
    @RequestMapping(value="/{username}", method=RequestMethod.GET)
    public ModelAndView showSpitterProfile(@PathVariable String username) {
        logger.debug(String.format("Visualizzazione pagina dell'utente %s",username));

        ModelAndView mav = new ModelAndView("profile");
        Spitter spitter = spitterService.trovaSpitter(username);
        mav.addObject("spitter",spitter);
        return mav;
    }
}

