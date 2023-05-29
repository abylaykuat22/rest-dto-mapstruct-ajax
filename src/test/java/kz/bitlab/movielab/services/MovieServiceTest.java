package kz.bitlab.movielab.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.util.Assert.notEmpty;

import java.util.List;
import kz.bitlab.movielab.dtos.MovieCreate;
import kz.bitlab.movielab.dtos.MovieUpdate;
import kz.bitlab.movielab.dtos.MovieView;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MovieServiceTest {

  @Autowired
  private MovieService movieService;

  @Test
  void addMovie() {
    MovieCreate movieCreate = MovieCreate.builder()
        .name("Бесславные ублюдки")
        .description("Торонтино гений")
        .rating(9.5)
        .build();
    MovieView movieView = movieService.addMovie(movieCreate);
    assertNotNull(movieView.getId());
    assertNotNull(movieView.getName());
    assertNotNull(movieView.getDescription());
    assertEquals(movieCreate.getName(), movieView.getName());
    assertEquals(movieCreate.getDescription(), movieView.getDescription());
    assertEquals(movieCreate.getRating(), movieView.getRating());
  }

  @Test
  void getMovies() {
    List<MovieView> movies = movieService.getMovies("asd");
    assertNotNull(movies, "object is null");
    notEmpty(movies, "список пустой");
  }

  @Test
  void getMovieById() {
    MovieView movieView = movieService.getMovieById(1L);
    assertNotNull(movieView);
    assertNotNull(movieView.getId());
  }

  @Test
  void editMovie() {
    MovieUpdate movieUpdate = MovieUpdate.builder()
        .id(1L)
        .name("Тарзан")
        .description("это мультфильм")
        .rating(8.1)
        .build();
    MovieView movieView = movieService.editMovie(movieUpdate);
    assertNotNull(movieView.getName());
    assertNotNull(movieView.getDescription());
    assertEquals(movieUpdate.getName(), movieView.getName());
    assertEquals(movieUpdate.getDescription(), movieView.getDescription());
    assertEquals(movieUpdate.getRating(), movieView.getRating());
  }
}