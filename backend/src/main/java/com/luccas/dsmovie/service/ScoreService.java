package com.luccas.dsmovie.service;

import com.luccas.dsmovie.DTO.MovieDto;
import com.luccas.dsmovie.DTO.ScoreDto;
import com.luccas.dsmovie.entities.Movie;
import com.luccas.dsmovie.entities.Score;
import com.luccas.dsmovie.entities.User;
import com.luccas.dsmovie.repository.MovieRepository;
import com.luccas.dsmovie.repository.ScoreRepository;
import com.luccas.dsmovie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;


@Service
public class ScoreService implements Serializable{

	private static final long serialVersionUID = 1L;

	
	@Autowired
	MovieRepository movieRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ScoreRepository scoreRepository;

	@Transactional
	public MovieDto saveScore(ScoreDto scoreDto){
	User user = userRepository.findByEmail(scoreDto.getEmail());
		if(user == null){
		user = new User ();
		user.setEmail(scoreDto.getEmail());
		user = userRepository.saveAndFlush(user);
	}
		Movie movie = movieRepository.findById(scoreDto.getMovieId()).get();

		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(scoreDto.getScore());
		score = scoreRepository.saveAndFlush(score);
		double sum = 0;
		for(Score s : movie.getScores()){
			sum += s.getValue();
		}
		double avg = sum / movie.getScores().size();
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		movie = movieRepository.save(movie);
		return new MovieDto(movie);
	}


}
