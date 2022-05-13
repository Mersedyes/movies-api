package com.codeup.fortran_movies_api.web;

import com.codeup.fortran_movies_api.data.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/movies", headers = "Accept=application/json")
public class MoviesController {

    private final MovieRepository movieRepository;
    private final DirectorsRepository directorsRepository;
    private final GenresRepository genresRepository;

    public MoviesController(MovieRepository movieRepository, DirectorsRepository directorsRepository, GenresRepository genresRepository) {
        this.movieRepository = movieRepository;
        this.directorsRepository = directorsRepository;
        this.genresRepository = genresRepository;
    }

    // TODO: put the expected path out to the side of the method annotation
    //  -> this helps to keep track so we don't have to guess if methods conflict on the same path
    @GetMapping("all") // /api/movies/all
    public List<Movie_DTO> getAll() {
        List<Movie> MovieList = movieRepository.findAll(); //getting all the movies from the database
        List<Movie_DTO> Movie_DTO_List = new ArrayList<>(); // created a new movie object
        for(Movie movie : MovieList){
            //get all the information from the database and send it to the array of Movie list
            Movie_DTO_List.add(new Movie_DTO(
            movie.getId(),
            movie.getTitle(),
            movie.getYear(),
            movie.getPlot(),
            movie.getPoster(),
            movie.getRating(),
            movie.getDirector().getName(),
            movie.getGenres().stream().map(Genre::getName).collect(Collectors.joining(", "))));
        }
        return Movie_DTO_List;
    }

    @GetMapping("{id}")
    public Movie getById(@PathVariable int id) {
        return movieRepository.findById(id).orElse(null);
    }

    @GetMapping("search")
    public List<Movie> getByTitle(@PathVariable String title) {
        // TODO: we need to create the findByTitle() method in our MoviesRepository - magic!
        return movieRepository.findByTitle(title);
    }

    @GetMapping("search/year")
    public List<Movie> getByYearRange(@PathVariable("startYear") int startYear, @PathVariable("endYear") int endYear) {
        // TODO: @RequestParam expects a query parameter in the request URL
        //  to have a param matching what is in the annotation (ie: @RequestParam("startYear"))
        return movieRepository.findByYearRange(startYear, endYear);
    }

    @GetMapping("search/director")
    public List<Director> getByDirector(@RequestParam("name") String directorName) {
        List<Director> directors = directorsRepository.findByName(directorName);
        return directors;
    }

    @PostMapping
    public <LIST> void create(@RequestBody Movie_DTO movieDto) {
        //add to our movies list (fake db)
        Movie movieToAdd = new Movie(
                movieDto.getTitle(),
                movieDto.getYear(),
                movieDto.getPlot(),
                movieDto.getPoster(),
                movieDto.getRating();
        )

        LIST directorsInDb = (LIST) directorsRepository.findByName(movieDto.getDirector());
        if(((List<?>) directorsInDb).isEmpty()){
            Director newDirector = new Director(movieDto.getDirector());
            movieToAdd.setDirector(directorsRepository.save(newDirector));
        } else {
            movieToAdd.setDirector((Director) ((List<?>) directorsInDb).get(0)); //cast
        }

        String[] genres = movieDto.getGenre().split(", ");
        List<Genre> movieGenre = new ArrayList<>();
        for (String genre : genres){
            Genre genreInDb = genresRepository.findGenreByName(genre);
            System.out.println(genreInDb);
            if(genreInDb == null){
                Genre newGenre = new Genre(genre);
                movieGenre.add(genresRepository.save(newGenre));
            } else {
                movieGenre.add(genreInDb);
            }
        }
        movieToAdd.setGenres(movieGenre);
        movieRepository.save(movieToAdd);

    }

    @PostMapping
    public void create(@RequestBody Movie movie) {
        movieRepository.save(movie);
    }

    @PostMapping("many")
    public void createMany(@RequestBody List<Movie> movies) {
        movieRepository.saveAll(movies);
    }

    @PutMapping
    public void update(@RequestBody Movie movie) {
        movieRepository.save(movie);
    }

    // TODO: make a delete request method here!
    @DeleteMapping("{id}")
    public void deleteId(@PathVariable int id) throws IOException {
        try {
            movieRepository.deleteById(id);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is not movie with this ID: " + id);
        }
    }
}


