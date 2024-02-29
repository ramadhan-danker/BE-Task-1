package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResouceNotFoundException;
import net.javaguides.springboot.model.Movie;
import net.javaguides.springboot.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

//    build create movie RESTAPI
    @PostMapping()
    public Movie createMovie(@RequestBody Movie movie){
        return movieRepository.save(movie);
    }

//    build get movie by id RESTAPI
    @GetMapping("{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id){
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new ResouceNotFoundException("Movie not exist with id:" + id));

        return  ResponseEntity.ok(movie);
        
    }

//    build update movie REST API
    @PutMapping("{id}")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movieDetails, @PathVariable Long id){
        Movie updateMovie = movieRepository.findById(id).orElseThrow(() -> new ResouceNotFoundException("Movie not exist with id: " + id));
        updateMovie.setTitle(movieDetails.getTitle());
        updateMovie.setRating(movieDetails.getRating());
        updateMovie.setYear(movieDetails.getYear());
        updateMovie.setMonth(movieDetails.getMonth());
        updateMovie.setCertificate(movieDetails.getCertificate());
        updateMovie.setRuntime(movieDetails.getRuntime());
        updateMovie.setDirector(movieDetails.getDirector());
        updateMovie.setStars(movieDetails.getStars());
        updateMovie.setGenre(movieDetails.getGenre());
        updateMovie.setFilming_location(movieDetails.getFilming_location());
        updateMovie.setBudget(movieDetails.getBudget());
        updateMovie.setIncome(movieDetails.getIncome());
        updateMovie.setCountry_of_origin(movieDetails.getCountry_of_origin());

        Movie update = movieRepository.save(updateMovie);

        return ResponseEntity.ok(update);

//        delete data movie



    }
    @DeleteMapping("{id}")
     public ResponseEntity<HttpStatus> deleteMovie(@PathVariable long id){
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new ResouceNotFoundException("Movies nox exist with id " + id));
        movieRepository.delete(movie);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

     }
    


}
