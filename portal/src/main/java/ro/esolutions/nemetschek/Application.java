package ro.esolutions.nemetschek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;

/**
 * Created by Bogdan Stoean on 15.04.2015.
 */
@SpringBootApplication(exclude = SpringDataWebAutoConfiguration.class)
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
}
