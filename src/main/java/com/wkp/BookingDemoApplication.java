package com.wkp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.jsondoc.spring.boot.starter.EnableJSONDoc;


@SpringBootApplication
@EnableJSONDoc
public class BookingDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingDemoApplication.class, args);
	}
}
