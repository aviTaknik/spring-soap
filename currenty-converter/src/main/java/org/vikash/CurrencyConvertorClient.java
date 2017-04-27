package org.vikash;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.vikash.wsdl.ConversionRate;
import org.vikash.wsdl.ConversionRateResponse;
import org.vikash.wsdl.Currency;

public class CurrencyConvertorClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(CurrencyConvertorClient.class);

	public double getConversionRate(Currency currency1, Currency currency2) {
		ConversionRate conversionRate = new ConversionRate();
		conversionRate.setFromCurrency(currency1);
		conversionRate.setToCurrency(currency2);

		log.info("Requesting Currency Conversion");

		ConversionRateResponse response = (ConversionRateResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://www.webservicex.net/CurrencyConvertor.asmx?WSDL", conversionRate,
				new SoapActionCallback("http://www.webserviceX.NET/ConversionRate"));

		return response.getConversionRateResult();
	}

}
