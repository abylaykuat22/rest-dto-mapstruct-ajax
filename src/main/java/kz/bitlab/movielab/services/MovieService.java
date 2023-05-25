package kz.bitlab.movielab.services;

import kz.bitlab.movielab.dtos.MovieCreate;
import kz.bitlab.movielab.dtos.MovieUpdate;
import kz.bitlab.movielab.dtos.MovieView;
import kz.bitlab.movielab.mappers.MovieMapper;
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
        Movie movie = MovieMapper.INSTANCE.toEntity(movieCreate);
        return MovieMapper.INSTANCE.toView(movieRepository.save(movie));
    }

    public List<MovieView> getMovies() {
        return MovieMapper.INSTANCE.toViewList(movieRepository.findAll());
    }

    public MovieView getMovieById(Long id) {
        return MovieMapper.INSTANCE.toView(movieRepository.findById(id).orElseThrow());
    }

    public MovieView editMovie(MovieUpdate movieUpdate) {
        Movie movie = MovieMapper.INSTANCE.toEntity(movieUpdate);
        return MovieMapper.INSTANCE.toView(movieRepository.save(movie));
    }

    public List<MovieView> deleteMovie(Long id) {
        movieRepository.deleteById(id);
        return getMovies();
    }
}
