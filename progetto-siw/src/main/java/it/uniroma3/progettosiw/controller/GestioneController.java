package it.uniroma3.progettosiw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GestioneController {

	//Spring Security see this :
		@RequestMapping(value = "/gestione")
		public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
	 
			ModelAndView model = new ModelAndView();
			if (error != null) {
				model.addObject("error", "Utente o password non validi!");
			}
	 
			if (logout != null) {
				model.addObject("msg", "Logout eseguito con successo");
			}
			model.setViewName("gestioneUtente");
	 
			return model;
	 
		}
}