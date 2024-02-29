package net.javaguides.springboot;

import net.javaguides.springboot.model.Movie;
import net.javaguides.springboot.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public void run(String... args) throws Exception {
		Movie movie = new Movie();
		movie.setTitle("The Shawshank Redemption");
		movie.setRating(9);
		movie.setYear("1994");
		movie.setMonth("September");
		movie.setCertificate("R");
		movie.setRuntime("142 minutes");
		movie.setDirector("Frank Darabont");
		movie.setStars("Tim Robbins, Morgan Freeman");
		movie.setGenre("Drama");
		movie.setFilming_location("Ohio, USA");
		movie.setBudget(25000000);
		movie.setIncome(58700000);
		movie.setCountry_of_origin("United States");
		movieRepository.save(movie);


		Movie movie1 = new Movie();
		movie.setRating(10);
		movie1.setTitle("Kimi no nawa");
		movie1.setYear("2018");
		movie1.setMonth("September");
		movie1.setCertificate("R");
		movie1.setRuntime("142 minutes");
		movie1.setDirector("Frank Darabont");
		movie1.setStars("Tim Robbins, Morgan Freeman");
		movie1.setGenre("Anime");
		movie1.setFilming_location("Jepang");
		movie1.setBudget(25000000);
		movie1.setIncome(58700000);
		movie1.setCountry_of_origin("Jepang");
		movieRepository.save(movie1);


	}
}
