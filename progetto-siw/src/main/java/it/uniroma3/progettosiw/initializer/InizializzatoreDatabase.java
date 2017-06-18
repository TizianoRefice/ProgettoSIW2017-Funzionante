package it.uniroma3.progettosiw.initializer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.uniroma3.progettosiw.model.Autore;
import it.uniroma3.progettosiw.model.Opera;
import it.uniroma3.progettosiw.repository.AutoreRepository;
import it.uniroma3.progettosiw.repository.OperaRepository;

@Component
public class InizializzatoreDatabase  implements ApplicationRunner {
	
	@Autowired
	private OperaRepository operaRepository;
	@Autowired
	private AutoreRepository autoreRepository;
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		Opera operaTest1 = new Opera("Nascita di Venere", 1485, "Rinascimentale", 172, 278, "https://it.wikipedia.org/wiki/Nascita_di_Venere");
		Opera operaTest2 = new Opera("Primavera", 1482, "Rinascimentale", 203, 314, "https://it.wikipedia.org/wiki/Primavera_(Botticelli)");
		Opera operaTest3 = new Opera("Ultima Cena", 1498, "Rinascimentale", 460, 880, "https://it.wikipedia.org/wiki/Ultima_Cena_(Leonardo)");
		
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Autore autoreTest1 = new Autore("Sandro", "Botticelli", "Italiano", format.parse("01-03-1445") , format.parse("17-05-1510"));
		Autore autoreTest2 = new Autore("Leonardo", "da Vinci", "Italiano", format.parse("15-04-1452") , format.parse("02-05-1519"));
		
		operaTest1.setAutore(autoreTest1);
		operaTest2.setAutore(autoreTest1);
		operaTest3.setAutore(autoreTest2);
		
		
		this.autoreRepository.save(autoreTest1);
		this.autoreRepository.save(autoreTest2);
		this.operaRepository.save(operaTest1);
		this.operaRepository.save(operaTest2);
		this.operaRepository.save(operaTest3);
	}
}
