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

}
