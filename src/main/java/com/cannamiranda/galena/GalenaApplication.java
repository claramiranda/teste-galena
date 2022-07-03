package com.cannamiranda.galena;

import com.cannamiranda.galena.controller.PlanilhaController;
import com.cannamiranda.galena.model.Galener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.util.List;

@SpringBootApplication
public class GalenaApplication {

	public static void main(String[] args) throws FileNotFoundException {

		SpringApplication.run(GalenaApplication.class, args);

		System.out.println("Comecando aqui");
		PlanilhaController planilhaController = new PlanilhaController();
		List<Galener> galeners = planilhaController.readPlanilha();
		Galener gal = galeners.get(0);
		System.out.println(gal);
		System.out.println("fim");

	}

}
