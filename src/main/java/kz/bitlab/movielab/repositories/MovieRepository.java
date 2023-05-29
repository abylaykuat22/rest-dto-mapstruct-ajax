package kz.bitlab.movielab.repositories;

import java.util.List;
import kz.bitlab.movielab.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

  @Query("select m from Movie m where m.name ilike concat('%', :search, '%') ")
  List<Movie> findAll(String search);
}
