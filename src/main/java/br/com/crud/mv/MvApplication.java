package br.com.crud.mv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.crud.mv")
public class MvApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvApplication.class, args);
	}

}
