package kz.bitlab.movielab.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MovieUpdate {
    private Long id;
    private String name;
    private String description;
    private double rating;
    private String promoCode;
}
