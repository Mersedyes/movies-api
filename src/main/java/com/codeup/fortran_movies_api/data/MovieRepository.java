package com.codeup.fortran_movies_api.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// TODO: JpaRepository<Entity, PrimaryKeyType>
public interface MovieRepository extends JpaRepository<Movie, Integer>{
    // TODO: Spring Data is pretty neat in that it reads your method name and interprets how to build the actual implementation of the query!
    List<Movie> findBytitle(String title);
    // TODO: If your query gets more complex, you could use the @Query annotation!
    @Query(nativeQuery = true, value = "SELECT * FROM movies m WHERE m.year = ? AND m.year <= ?;")
    List<Movie> findByYearRange(String year, Integer endYear);
}