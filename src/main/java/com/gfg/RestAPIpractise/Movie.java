package com.gfg.RestAPIpractise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movie {
    private String name;
    private String genre;
    private String language;
    private float rating;
    private List<Cast> castList;
}
