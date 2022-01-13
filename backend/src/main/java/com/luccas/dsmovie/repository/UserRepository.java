package com.luccas.dsmovie.repository;

import com.luccas.dsmovie.DTO.ScoreDto;
import com.luccas.dsmovie.entities.Movie;
import com.luccas.dsmovie.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

    User findByEmail(String email);
}
