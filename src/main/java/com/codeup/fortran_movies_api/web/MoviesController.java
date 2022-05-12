package com.codeup.fortran_movies_api.web;

import com.codeup.fortran_movies_api.data.DirectorsRepository;
import com.codeup.fortran_movies_api.data.Movie;
import com.codeup.fortran_movies_api.data.MovieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value="/api/movies", headers="Accept=application/json")
public class MoviesController {

       private final MovieRepository movieRepository;
       private final DirectorsRepository directorsRepository;

       public MoviesController(MovieRepository movieRepository, DirectorsRepository directorsRepository){
               this.movieRepository = movieRepository;
               this.directorsRepository = directorsRepository;
       }

        // TODO: put the expected path out to the side of the method annotation
        //  -> this helps to keep track so we don't have to guess if methods conflict on the same path
        @GetMapping("all") // /api/movies/all




//        @GetMapping
//        public Movie one() {
//                return sampleMovies.get(1);
//        }
//
//        @GetMapping("all") // Path becomes: /api/movies/all
//        public List<Movie> getAll() {
//                return sampleMovies;
//        }
//
//
//        // /api/movies/3 <- 3 is the path variable for id
//        @GetMapping("{id}") // Define the path variable to use here
//        public Movie getById(@PathVariable int id) { // Actually use the path variable here by annotating a parameter with @PathVariable
//                return sampleMovies.stream().filter((movie) -> {
//                                return movie.getId() == id; // filter out non-matching movies
//                        })
//                        .findFirst() // isolate to first match
//                        .orElse(null); // prevent errors by returning null... not the greatest practice, but it'll do for now
//        }
//
//        @PostMapping("many")
//        public void create(@RequestBody List<Movie> movies){
//                // add to our movies list (fake db)
//                System.out.println(movies.getClass());
//                sampleMovies.addAll(movies);
//        }
//
//        // This utility method simply sets up and populates our sampleMovies backing field
//        // Will remove once we integrate with the database
//        private List<Movie> setMovies() {
//                List<Movie> movies = new ArrayList<>();
//
////                movies.add(new Movie(2, "Pulp Fiction", "1994", "Quentin Tarantino",
////                        "Samuel L. Jackson, Uma Therman, Bruce Willis, John Travolta, Ving Rhames",
////                        "action, drama, suspense, cult classic, crime",
////                        "Vincent Vega (John Travolta) and Jules Winnfield (Samuel L. Jackson) are hitmen with a penchant for philosophical discussions. " +
////                                "In this ultra-hip, multi-strand crime movie, their storyline is interwoven with those of their boss, " +
////                                "gangster Marsellus Wallace (Ving Rhames) ; his actress wife, Mia (Uma Thurman) ; " +
////                                "struggling boxer Butch Coolidge (Bruce Willis) ; master fixer Winston Wolfe (Harvey Keitel) and a nervous pair of armed robbers, " +
////                                "\"Pumpkin\" (Tim Roth) and \"Honey Bunny\" (Amanda Plummer)."));
////                movies.add(new Movie(1, "The Big Lebowski",
////                        "1995", "The Cohen Bros",
////                        "Jeff Bridges, John Goodman, Steve Buscemi",
////                        "comedy, drama?",
////                        "the dude just wanted to relax and go bowling"));
//
//                return movies;
//        }
}
