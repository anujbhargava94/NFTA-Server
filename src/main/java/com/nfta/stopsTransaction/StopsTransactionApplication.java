package com.nfta.stopsTransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import com.nfta.stopsTransaction.service.RouteService;
import com.nfta.stopsTransaction.service.TransactionService;
import com.nfta.stopsTransaction.serviceImpl.RouteServiceImpl;
import com.nfta.stopsTransaction.serviceImpl.TransactionServiceImpl;

@ComponentScan("com.nfta.stopsTransaction")
@SpringBootApplication
public class StopsTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(StopsTransactionApplication.class, args);
	}
	
	
	@Bean
	@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public TransactionService getQueryBuilder()
	{
		return new TransactionServiceImpl();
	}
	
	@Bean
	@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public RouteService getRouteService()
	{
		return new RouteServiceImpl();
	}

}
