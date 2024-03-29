package com.codeup.fortran_movies_api.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String year;
    @ManyToOne
    @JsonIgnoreProperties("directedMovies")
    private Director director;
    private String plot;
    private String poster;
    private String rating;

    // TODO: We need to defined the same many-to-many relationship, but from the Movie side (with a little less annotation fun)
    @ManyToMany(mappedBy = "movies")
    @JsonIgnoreProperties("movies")
    private List<Genre> genres;


    public Movie() {
    }

    public Movie( int id, String title, String year, String plot, String poster, String rating){
            this.id = id;
            this.title = title;
            this.year = year;
            this.plot = plot;
            this.poster = poster;
            this.rating = rating;
        }

    public Movie(String title, String year, String plot, String poster, String rating) {

    }


    public int getId () {
            return id;
        }

        public void setId ( int id){
            this.id = id;
        }

        public String getTitle () {
            return title;
        }

        public void setTitle (String title){
            this.title = title;
        }

        public String getYear () {
            return year;
        }

        public void setYear (String year){
            this.year = year;
        }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPlot () {
            return plot;
        }

        public void setPlot (String plot){
            this.plot = plot;
        }

    // TODO: GETTERS!

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", director=" + director +
                ", plot='" + plot + '\'' +
                ", poster='" + poster + '\'' +
                ", rating='" + rating + '\'' +
                ", genres=" + genres +
                '}';
    }
}