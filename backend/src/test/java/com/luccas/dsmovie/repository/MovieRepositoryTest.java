package com.luccas.dsmovie.repository;

import com.luccas.dsmovie.entities.Movie;
import com.luccas.dsmovie.util.MovieCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@DisplayName("Test For MovieRepositorys")
class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;


    @Test
    @DisplayName("Saved Persist movie when SuccessFull")
    public void save_PersistMovie_WhenSuccessFull(){
        Movie movie = MovieCreator.createdMovieToBeSaved();
        Movie savedMovie = movieRepository.save(movie);
        Assertions.assertThat(savedMovie).isNotNull();
        Assertions.assertThat(savedMovie.getId()).isNotNull();
        Assertions.assertThat(savedMovie.getTitle()).isEqualTo(savedMovie.getTitle());
        Assertions.assertThat(savedMovie.getCount()).isEqualTo(savedMovie.getCount());
    }

    @Test
    @DisplayName("Saved updates movie when SuccessFull")
    public void save_UpdateMovie_WhenSuccessFull(){
        Movie movie = MovieCreator.createdMovieToBeSaved();
        Movie savedMovie = movieRepository.save(movie);
        savedMovie.setTitle("Homem formiga");
        Movie updateMovie = movieRepository.save(movie);
        Assertions.assertThat(updateMovie).isNotNull();
        Assertions.assertThat(updateMovie.getId()).isNotNull();
        Assertions.assertThat(updateMovie.getTitle()).isEqualTo(updateMovie.getTitle());
    }

    @Test
    @DisplayName("Delete removes movie when SuccessFull")
    public void delete_RemovesMovie_WhenSuccessFull(){
        Movie movie = MovieCreator.createdMovieToBeSaved();
        Movie savedMovie = movieRepository.save(movie);
        this.movieRepository.delete(savedMovie);
        Optional<Movie> movieOptional = this.movieRepository.findById(savedMovie.getId());
        Assertions.assertThat(movieOptional.isEmpty());
    }

}