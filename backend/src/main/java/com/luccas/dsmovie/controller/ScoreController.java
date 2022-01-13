package com.luccas.dsmovie.controller;

import com.luccas.dsmovie.DTO.MovieDto;
import com.luccas.dsmovie.DTO.ScoreDto;
import com.luccas.dsmovie.service.MovieService;
import com.luccas.dsmovie.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;


    @PutMapping
    public MovieDto saveScore(@RequestBody ScoreDto Dto){
        MovieDto movieDto = scoreService.saveScore(Dto);
        return movieDto;
    }
    
}
