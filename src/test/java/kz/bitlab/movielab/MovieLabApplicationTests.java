package kz.bitlab.movielab;

import kz.bitlab.movielab.dtos.MovieCreate;
import kz.bitlab.movielab.mappers.MovieMapper;
import kz.bitlab.movielab.models.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MovieLabApplicationTests {

  @Test
  void contextLoads() {
    MovieCreate movieCreate = new MovieCreate();
    movieCreate.setName("Блэйд");
    movieCreate.setDescription("про вампиров");
    movieCreate.setRating(7.5);
    Movie movie = MovieMapper.INSTANCE.toEntity(movieCreate);
    Assertions.assertNotNull(movie.getName());
    Assertions.assertNotNull(movie.getDescription());
    Assertions.assertEquals(movieCreate.getName(), movie.getName());
    Assertions.assertEquals(movieCreate.getDescription(), movie.getDescription());
    Assertions.assertEquals(movieCreate.getRating(), movie.getRating());
  }
}
