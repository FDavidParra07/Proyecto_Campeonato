package com.proyecto.torneo;

import com.proyecto.torneo.entidades.Equipo;
import com.proyecto.torneo.repositorios.EquipoRepositorio;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@Log4j2
public class TorneoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TorneoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		// Espacio para acciones locales

	}
}