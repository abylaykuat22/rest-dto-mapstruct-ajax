package kz.bitlab.movielab.controllers;

import kz.bitlab.movielab.dtos.MovieCreate;
import kz.bitlab.movielab.dtos.MovieUpdate;
import kz.bitlab.movielab.dtos.MovieView;
import kz.bitlab.movielab.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping
    public MovieView addMovie(@RequestBody MovieCreate movieCreate) {
        return movieService.addMovie(movieCreate);
    }

    @GetMapping
    public List<MovieView> movies(@RequestParam(required = false, defaultValue = "") String search) {
        return movieService.getMovies(search);
    }

    @GetMapping("{id}")
    public MovieView getMovie(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @PutMapping
    public MovieView editMovie(@RequestBody MovieUpdate movieUpdate) {
        return movieService.editMovie(movieUpdate);
    }

    @DeleteMapping("{id}")
    public List<MovieView> deleteMovie(@PathVariable Long id) {
        return movieService.deleteMovie(id);
    }
}
