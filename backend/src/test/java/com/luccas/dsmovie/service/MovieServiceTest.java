package com.luccas.dsmovie.service;

import com.luccas.dsmovie.DTO.MovieDto;
import com.luccas.dsmovie.entities.Movie;
import com.luccas.dsmovie.repository.MovieRepository;
import com.luccas.dsmovie.util.MovieCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
class MovieServiceTest {

    @InjectMocks
    private MovieService movieService;

    @Mock
    private MovieRepository movieRepository;



    @BeforeEach
    void setUp(){
        PageImpl<Movie> moviePage = new PageImpl<>(
                List.of(MovieCreator.createAnimeValidAnime()));
        BDDMockito.when(movieRepository.findAll(ArgumentMatchers.any(PageRequest.class)))
                .thenReturn(moviePage);

        BDDMockito.when(movieRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(MovieCreator.createAnimeValidAnime()));
    }


    @Test
    @DisplayName("listAll Return list of movie in page object when successful")
    void listAll_ReturnsList0fMovieInsidePageObject_WhenSuccessful(){
        String title = MovieCreator.createAnimeValidAnime().getTitle();
        Page<MovieDto> all = movieService.findAll(PageRequest.of(1, 1));
        Assertions.assertThat(all).isNotNull();
        Assertions.assertThat(all.toList()).isNotEmpty().hasSize(1);
        Assertions.assertThat(all.toList().get(0).getTitle()).isEqualTo(title);
    }
    
    @Test
    @DisplayName("FindById Return list of Movie when SuccessFull")
    void findById_ReturnMovie_WhenSuccesFull(){
        Long id = MovieCreator.createAnimeValidAnime().getId();
        MovieDto movieId = movieService.findById(id);
        Assertions.assertThat(movieId).isNotNull();
        Assertions.assertThat(movieId.getId()).isNotNull().isEqualTo(id);
    }


}