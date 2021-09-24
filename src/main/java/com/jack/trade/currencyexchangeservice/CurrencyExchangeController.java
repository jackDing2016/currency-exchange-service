package com.jack.trade.currencyexchangeservice;

import com.feignInterface.ExchangeValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    private static Logger logger = LoggerFactory.getLogger( CurrencyExchangeController.class );

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to)  //from map to USD and to map to INR
    {
        logger.info( "retrieveExchangeValue method github" );
        int x = ThreadLocalRandom.current().nextInt(1, 100 );
        return new  ExchangeValue(1000L, from, to, BigDecimal.valueOf( x ), Integer.parseInt( environment.getProperty( "local.server.port" ) ));
    }

}
