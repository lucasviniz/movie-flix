package com.devsuperior.movieflix.dto;

import java.util.ArrayList;
import java.util.List;

import com.devsuperior.movieflix.entities.Movie;

public class MovieReviewsDTO {
	
	private Long id;
	private String title;
	private String subTitle;
	
	private List<ReviewDTO> reviews = new ArrayList<>();
	
	public MovieReviewsDTO() {
	}
	
	public MovieReviewsDTO(Long id, String title, String subTitle, List<ReviewDTO> reviews) {
		this.id = id;
		this.title = title;
		this.subTitle = subTitle;
		this.reviews = reviews;
	}

	public MovieReviewsDTO(Movie entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.subTitle = entity.getSubTitle();
		entity.getReviews().forEach(rev -> this.reviews.add(new ReviewDTO(rev)));

	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public List<ReviewDTO> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewDTO> reviews) {
		this.reviews = reviews;
	}
	

}
