package com.proiect.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.proiect.demo.repository.SistemeElectroniceSpringDataJpaRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	@Autowired
	SistemeElectroniceSpringDataJpaRepository repository;

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("--------Spring Data JPA--------");
		System.out.println("\nContinutul initial al tabelei Sisteme Electronice:");
		repository.findAll().forEach(System.out::println);
	}
}
