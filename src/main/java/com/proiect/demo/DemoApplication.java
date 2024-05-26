package com.proiect.demo;

import com.proiect.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	ElectronicSystemRepository repository1;
	@Autowired
	UserRepository repository2;
	@Autowired
	ReviewRepository repository3;
	@Autowired
	OrdersRepository repository4;
	@Autowired
	BasketRepository repository5;
	@Autowired
	ServiceRequestRepository repository6;
	@Autowired
	ProductDiscountRepository repository7;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("--------Spring Data JPA SISTEME ELECTRONICE--------");
		System.out.println("\nContinutul initial al tabelei:");
		repository1.findAll().forEach(System.out::println);

		System.out.println("--------Spring Data JPA USER --------");
		System.out.println("\nContinutul initial al tabelei:");
		repository2.findAll().forEach(System.out::println);

		System.out.println("--------Spring Data JPA REVIEW --------");
		System.out.println("\nContinutul initial al tabelei :");
		repository3.findAll().forEach(System.out::println);

		System.out.println("--------Spring Data JPA ORDER --------");
		System.out.println("\nContinutul initial al tabelei ");
		repository4.findAll().forEach(System.out::println);

		System.out.println("--------Spring Data JPA Basket --------");
		System.out.println("\nContinutul initial al tabelei ");
		repository5.findAll().forEach(System.out::println);

		System.out.println("--------Spring Data JPA SERVICE REQUEST --------");
		System.out.println("\nContinutul initial al tabelei ");
		repository6.findAll().forEach(System.out::println);

		System.out.println("--------Spring Data JPA PRODUCT DISCOUNT--------");
		System.out.println("\nContinutul initial al tabelei ");
		repository7.findAll().forEach(System.out::println);
	}
}