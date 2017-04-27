package org.vikash;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.vikash.wsdl.Currency;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	CommandLineRunner lookup(CurrencyConvertorClient client) {
		return args -> {
			Currency from = Currency.USD;
			Currency to = Currency.INR;

			double rate = client.getConversionRate(from, to);
			System.err.println(from +" : "+to+" = "+ "1 : "+ rate);
		};

	}
}