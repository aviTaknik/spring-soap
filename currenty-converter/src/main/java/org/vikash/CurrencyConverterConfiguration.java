package org.vikash;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CurrencyConverterConfiguration {
	@Bean
	public Jaxb2Marshaller marshaller(){
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setContextPath("org.vikash.wsdl");
		return jaxb2Marshaller;
	}
	
	@Bean
	public CurrencyConvertorClient mortgageClient(Jaxb2Marshaller marshaller){
		CurrencyConvertorClient client = new CurrencyConvertorClient();
		client.setDefaultUri("http://www.webservicex.net/CurrencyConvertor.asmx?WSDL");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
