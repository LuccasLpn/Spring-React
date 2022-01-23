package com.luccas.dsmovie.service;

import com.luccas.dsmovie.DTO.MovieDto;
import com.luccas.dsmovie.entities.Movie;
import com.luccas.dsmovie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;


@Service
public class MovieService implements Serializable{

	private static final long serialVersionUID = 1L;

	
	@Autowired
	private MovieRepository movieRepository;

	@Transactional(readOnly = true)
	public Page<MovieDto> findAll(Pageable pageable) {
	Page<Movie> result = movieRepository.findAll(pageable);
	return result.map(MovieDto::new);
	}

	@Transactional(readOnly = true)
	public MovieDto findById(Long id) {
		Movie result = movieRepository.findById(id).get();
		return new MovieDto(result);
	}





}
