package it.uniroma3.progettosiw.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.progettosiw.model.Autore;
import it.uniroma3.progettosiw.model.Opera;
import it.uniroma3.progettosiw.service.AutoreService;


@Controller
public class AutoreController {


	@Autowired
	private AutoreService autoreService;

	@GetMapping ("/autore")
	public String showForm(Autore autore){
		return "formAutore";
	}

	@PostMapping ("/autore")
	public String checkAutoreInfo (@Valid @ModelAttribute Autore autore, BindingResult bindingResult, 
			Model model){

		if (bindingResult.hasErrors()) {
			return "formAutore";                                                          
		}
		else {
			model.addAttribute(autore);
			autoreService.add(autore); 
		}
		return "datiAutore";               
	}
	@GetMapping("/autori")
	public String getAutori(Model model){
		model.addAttribute("autori",this.autoreService.findAll());
		return "listaAutori";
	}
	@RequestMapping("/autori/{id}")
	public String getAutore(@PathVariable Long id,Model model){
		model.addAttribute("autore",this.autoreService.findById(id));
		return "datiAutore";
	}
	@RequestMapping(value="/autori/{id}",method=RequestMethod.DELETE)
	public String deleteAutore(@PathVariable Long id){
		this.autoreService.deleteById(id);
		return "redirect:/autori";
	}
	
	@GetMapping("/autoriUtente")
	public String getAutoriUtente(Model model){
		model.addAttribute("autori",this.autoreService.findAll());
		return "listaAutoriUtente";
	}
	
	@GetMapping("/listaAutoriPerOpere")
	public String autoriPerOpere(Model model) {
		model.addAttribute("autori", this.autoreService.findAll());
		return "listaAutoriPerOpere";
	}
	
//	@GetMapping("/opereByAutore")
//	public String opereByAutore(@PathVariable Long id, Model model) {
//		Autore autore = this.autoreService.findById(id);
//		model.addAttribute("opereByAutore", autore.getOpereRealizzate());
//		return "opereByAutore";
//	}

}
