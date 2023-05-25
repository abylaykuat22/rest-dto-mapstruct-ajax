package kz.bitlab.movielab.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieUpdate {
    private Long id;
    private String name;
    private String description;
    private double rating;
    private String promoCode;
}
