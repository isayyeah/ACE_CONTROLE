package com.car.Car;

import com.car.Car.entities.Car;
import com.car.Car.repositories.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class CarApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarApplication.class, args);
	}


	@Bean
	public RestTemplate restTemplate(){
		RestTemplate restTemplate = new RestTemplate();
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		requestFactory.setConnectTimeout(5000);
		requestFactory.setReadTimeout((5000));
		restTemplate.setRequestFactory(requestFactory);

		return restTemplate;
	}

	@Bean
	CommandLineRunner initializer(CarRepository cr){
		return args ->{
			cr.save(new Car(1, "Ford", "FOCUS TITANIUM", "42638A55", 1));
			cr.save(new Car(2, "Ford", "DODGE", "63638W1", 2));
			cr.save(new Car(3, "TOYOTA", "HILUX", "63638A55", 3));
			cr.save(new Car(4, "MERCEDES", "BRABUS ROCKET 900", "52627W1", 1));
		};
	}


}
