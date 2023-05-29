package kz.bitlab.movielab.services;

import kz.bitlab.movielab.dtos.MovieCreate;
import kz.bitlab.movielab.dtos.MovieUpdate;
import kz.bitlab.movielab.dtos.MovieView;
import static kz.bitlab.movielab.mappers.MovieMapper.*;
import kz.bitlab.movielab.models.Movie;
import kz.bitlab.movielab.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    public MovieView addMovie(MovieCreate movieCreate) {
        Movie movie = INSTANCE.toEntity(movieCreate);
        return INSTANCE.toView(movieRepository.save(movie));
    }

    public List<MovieView> getMovies(String search) {
        return INSTANCE.toViewList(movieRepository.findAll(search));
    }

    public MovieView getMovieById(Long id) {
        return INSTANCE.toView(movieRepository.findById(id).orElseThrow());
    }

    public MovieView editMovie(MovieUpdate movieUpdate) {
        Movie movie = INSTANCE.toEntity(movieUpdate);
        return INSTANCE.toView(movieRepository.save(movie));
    }

    public List<MovieView> deleteMovie(Long id) {
        movieRepository.deleteById(id);
        return getMovies("");
    }
}
