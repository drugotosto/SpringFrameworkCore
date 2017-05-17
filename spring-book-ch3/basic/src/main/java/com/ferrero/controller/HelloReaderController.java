package com.ferrero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloReaderController {
	
    @RequestMapping(value = "/hello")
    public ModelAndView sayHello() {
        /*
        The handler method of the matching controller, sayHello, creates an instance of the ModelAndView class,
        sets the object to be passed to the view with a key (message), sets the name of the view (helloReader),
        and returns it for the servlet to resolve the view that will be rendered to the user as the response
         */
    	ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Hello Reader!");
        mv.setViewName("helloReader");
        return mv;
    }
}

