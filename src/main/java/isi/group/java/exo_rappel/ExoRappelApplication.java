package isi.group.java.exo_rappel;

import isi.group.java.exo_rappel.entity.Depute;
import isi.group.java.exo_rappel.service.DeputeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ExoRappelApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExoRappelApplication.class, args);

		List<Depute> deputes = DeputeService.getDeputes();

		deputes.stream().filter(depute -> depute.getNom().equals("Diop")).toList();
	}

}
