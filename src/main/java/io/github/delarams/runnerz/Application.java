package io.github.delarams.runnerz;

//import io.github.delarams.runnerz.WelcomeMessage;
import io.github.delarams.runnerz.run.Location;
import io.github.delarams.runnerz.run.Run;
import io.github.delarams.runnerz.run.RunRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {



		SpringApplication.run(Application.class, args);

	}
//	@Bean
//	CommandLineRunner runner(RunRepository runRepository){
//		return args -> {
//			Run run = new Run(1, "First Run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 3, Location.OUTDOOR );
//			runRepository.create(run);
//		};
	}

