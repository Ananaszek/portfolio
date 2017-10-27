package pl.agataanaszewicz.portfolioAgataAnaszewicz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PortfolioAgataAnaszewiczApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioAgataAnaszewiczApplication.class, args);
	}
}
