package com.luccas.dsmovie.repository;

import com.luccas.dsmovie.entities.Score;
import com.luccas.dsmovie.entities.ScorePk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePk>{

}
