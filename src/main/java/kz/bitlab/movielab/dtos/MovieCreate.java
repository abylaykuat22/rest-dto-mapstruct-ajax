package kz.bitlab.movielab.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieCreate {
    private String name;
    private String description;
    private double rating;
}
