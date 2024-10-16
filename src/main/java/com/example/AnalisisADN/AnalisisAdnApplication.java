package com.example.AnalisisADN;

import com.example.AnalisisADN.Entities.Humano;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.stream.IntStream;

@SpringBootApplication
public class AnalisisAdnApplication {

	public static void main(String[] args) {
		Humano noMutante = Humano.builder()
				.nombre("Matias")
				.apellido("Telo")
				.build();
		noMutante.setdna(new String[]{"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"});
		Humano Mutante = Humano.builder()
				.nombre("Alberto")
				.apellido("Cortez")
				.build();
		Mutante.setdna(new String[]{"ATGCCA","CAGTGC","TTATGT","AGAAGG","CCGCTA","TCACTG"});
		if (noMutante.isMutant()) {
			System.out.println(noMutante.getNombre()+" Es mutante");
		} else {
			System.out.println(noMutante.getNombre()+" No es mutante");
		}
		if (Mutante.isMutant()) {
			System.out.println(Mutante.getNombre()+" Es mutante");
		} else {
			System.out.println(Mutante.getNombre()+" No es mutante");
		}

		SpringApplication.run(AnalisisAdnApplication.class, args);

	}


}
