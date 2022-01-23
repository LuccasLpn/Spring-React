package com.luccas.dsmovie.util;

import com.luccas.dsmovie.entities.Movie;

public class MovieCreator {

    public static Movie createdMovieToBeSaved(){
        Movie mv = new Movie();
        mv.setTitle("Homem de Ferro");
        mv.setScore(4.5);
        mv.setCount(4);
        return mv;
    }

    public static Movie createAnimeValidAnime(){
        Movie mv = new Movie();
        mv.setTitle("Homem de Ferro");
        mv.setScore(4.5);
        mv.setCount(4);
        mv.setId(55L);
        return mv;
    }
}
