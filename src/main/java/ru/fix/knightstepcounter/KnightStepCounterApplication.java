package ru.fix.knightstepcounter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class KnightStepCounterApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnightStepCounterApplication.class, args);
	}

}
