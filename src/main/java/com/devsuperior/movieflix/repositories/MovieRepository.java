package com.devsuperior.movieflix.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.movieflix.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

	@Query("SELECT DISTINCT obj FROM Movie obj WHERE obj.genre.id = :genre ")
	Page<Movie> find(Long genre, Pageable pageable);
	
	
	@Query("SELECT DISTINCT obj FROM Movie obj JOIN FETCH obj.reviews rev WHERE "
			+ "rev.movie.id = :id")
	Optional<Movie> findReviews(Long id);
	
}
