package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long>{
//    all crud database method

}
