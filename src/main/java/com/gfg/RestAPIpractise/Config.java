package com.gfg.RestAPIpractise;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@org.springframework.context.annotation.Configuration
public class Config {

    @Bean
    List<Movie> movieList(){
        return new ArrayList<>();
    }
}
