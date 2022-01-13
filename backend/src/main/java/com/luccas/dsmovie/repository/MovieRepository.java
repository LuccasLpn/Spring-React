package com.luccas.dsmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luccas.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
}
