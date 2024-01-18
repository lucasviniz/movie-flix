package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repository;

    @Transactional
    public ReviewDTO insert(ReviewDTO dto){
        Review entity = new Review();
        entity.setMovie(new Movie(dto.getMovieId(), null, null, null, null, null, null, null));
        entity.setUser(new User(dto.getUserId(), null, null, null));
        entity.setText(dto.getText());
        entity = repository.save(entity);

        return new ReviewDTO(entity);
    }

}
