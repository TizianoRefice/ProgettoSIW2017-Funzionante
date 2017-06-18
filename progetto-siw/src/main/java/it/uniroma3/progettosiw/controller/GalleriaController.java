package it.uniroma3.progettosiw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class GalleriaController {

	//Spring Security see this :
		@RequestMapping("/vediGalleria")
		public String vediGalleria() {
			return "vediGalleria";
		}
}