package kz.bitlab.movielab.mappers;

import kz.bitlab.movielab.dtos.MovieCreate;
import kz.bitlab.movielab.dtos.MovieUpdate;
import kz.bitlab.movielab.dtos.MovieView;
import kz.bitlab.movielab.models.Movie;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(builder = @Builder(disableBuilder = true))
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    Movie toEntity(MovieCreate dto);

    Movie toEntity(MovieUpdate dto);

    MovieView toView(Movie entity);

    List<MovieView> toViewList(List<Movie> movieList);
}
