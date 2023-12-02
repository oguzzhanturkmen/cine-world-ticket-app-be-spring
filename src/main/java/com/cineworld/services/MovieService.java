package com.cineworld.services;

import com.cineworld.entity.Movie;
import com.cineworld.repos.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    // Create
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Read
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Update
    public Movie updateMovie(Long id, Movie movieDetails) {
        Movie movie = movieRepository.findById(id).orElse(null);
        if (movie != null) {
            movie.setTitle(movieDetails.getTitle());
            // set other fields
            movieRepository.save(movie);
        }
        return movie;
    }

    // Delete
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}

