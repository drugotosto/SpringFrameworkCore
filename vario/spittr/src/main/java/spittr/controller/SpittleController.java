package spittr.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spittr.model.Spittle;
import spittr.dao.SpittleRepository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by drugo on 18/05/2017.
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private static final String MAX_LONG_AS_STRING = "9223372036854775807";
    static Logger logger = Logger.getLogger(SpittleController.class);

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }


    /*
        Gestisce tutte le richieste che arrivano senza parametri
    */
    /*
        Notice that the spittles() method is given a Model as a parameter. This is so that
        spittles() can populate the model with the Spittle list it retrieves from the repository.
        The Model is essentially a map (that is, a collection of key-value pairs).
        The last thing spittles() does is return "spittles" as the name of the view that will
        render the model.
     */
     @RequestMapping(method= RequestMethod.GET)
     public ModelAndView spittles() {
        logger.debug("Richiesta di visualizzazione degli Spittles!");
        for (Spittle spit:  spittleRepository.findFirst5ByOrderByTimeDesc()) {
            logger.debug(String.format("Messaggio: %s \n", spit.getMessage()));
        }

        /*
            A list of Spittle objects is stored in the model with a key of spittleList
            and given to the view whose name is spittles. Given the way you’ve configured
            InternalResourceViewResolver, that view is a JSP at /WEB-INF/views/spittles.jsp.
         */
         ModelAndView mav = new ModelAndView("spittles");
         mav.addObject("spittleList",spittleRepository.findFirst5ByOrderByTimeDesc());
         return mav;
    }


    /*
       Da notare come in questo caso rispetto all'inserimento di un nuovo utente in SpitterController ora
       viene utilizzata l'apposita classe SpittleForm per immagazzinare i valori che arrivano dal form
       che l'utente ha popolato relativo all'inserimento dello Spittle.
       Da questa istanza di SpittleForm si và a creare e salvare l'oggetto Spittle vero e proprio.
   */
    @RequestMapping(method=RequestMethod.POST)
    public String processInsertSplittle(SpittleForm form) throws Exception {
        logger.debug("Richiesta di inserimento di uno Spittle!");
        spittleRepository.save(new Spittle(null, form.getMessage(),new Date(), form.getLatitude(), form.getLongitude()));
        return "home";
    }


    /*
        Ritorna una lista di Spittles a partire da quello che presenta ID=max (1° parametro della richiesta) a ritroso andandone a prelevare "count" (2° parametro della richiesta).
        Da notare in questo caso la richiesta dei Query parameters "max" e "count" per mappare oppurtanamente la richiesta GET che arriva.
        Es: .../spittles?max=238900&count=50
    */
    /*
        Now, if the max parameter isn’t specified, it will default to the maximum value of Long.
        Because query parameters are always of type String, the defaultValue attribute requires a String value.
        Even though the defaultValue is given as a String, it will be converted to a Long
        when bound to the method’s max parameter
    */
    @RequestMapping(params = {"max","count"},method=RequestMethod.GET)
    public ModelAndView spittles(@RequestParam(value="max", defaultValue=MAX_LONG_AS_STRING) long max, @RequestParam(value="count", defaultValue="20") int count) {
        logger.debug(String.format("Recupero di un gruppo di %d Spittles che seguono da quello con id %d",count,max));

        ModelAndView mav = new ModelAndView("spittles");
        mav.addObject("spittleList",spittleRepository.trovaSpittles(max, count));
        return mav;
    }


    /*
        Esempio di gestione degli input utente attraverso paramteri passati via PATH anzichè parametri di query
        Viene richiesto il recupero di un preciso spittle con dato ID.
        Es: .../spittles/12345
    */
    @RequestMapping(value="/{spittleId}", method=RequestMethod.GET)
    public ModelAndView spittle(@PathVariable("spittleId") long spittleId) {
        logger.debug(String.format("Recupero del particolare Spittle con id %d",spittleId));

        ModelAndView mav = new ModelAndView("spittle");
        mav.addObject("spittle",spittleRepository.findById(spittleId));
        return mav;
    }
}
