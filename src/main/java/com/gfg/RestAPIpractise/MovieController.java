package com.gfg.RestAPIpractise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private List<Movie> movieList;

    // CREATE
    @PostMapping("/v1/movie/createMovie")
    String create(@RequestBody Movie movie){
        try {
            this.movieList.add(movie);
            return "Movie Got Created";
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    // RETRIEVE
    @GetMapping("/v1/movie/retrieveMovie")
    Object read(@RequestParam("name") String name){
        try {
            for(Movie movie : movieList){
                if (movie.getName().equals(name))
                    return movie;
            }
            return "No Movie Found";
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    // UPDATE (modify)
    @PatchMapping("/v1/movie/updateMovie/{name}")
    String patchUpdate(@PathVariable("name") String name, @RequestBody Movie movieUpdateRequest){
        try {
            for (Movie movie : movieList) {
                if (movie.getName().equals(name)) {
                    movie.setRating(movieUpdateRequest.getRating());
                    return "Movie Rating Got Updated";
                }
            }
            return "No Movie Found";
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    // UPDATE (replace)
    @PutMapping("/v1/movie/updateMovie/{name}")
    String putUpdate(@PathVariable("name") String name, @RequestBody Movie movieUpdateRequest){
        try {
            for (Movie movie : movieList) {
                if (movie.getName().equals(name)) {
                    movieList.remove(movie);
                    movieList.add(movieUpdateRequest);
                    return "Movie Got Updated";
                }
            }
            return "No Movie Found";
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    // DELETE
    @DeleteMapping("/v1/movie/deleteMovie")
    Object delete(@RequestParam("name") String name){
        try {
            for (Movie movie : movieList) {
                if (movie.getName().equals(name)) {
                    movieList.remove(movie);
                    return "Movie Got Deleted";
                }
            }
            return "No Movie Found";
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return e.getMessage();
        }
    }

}
