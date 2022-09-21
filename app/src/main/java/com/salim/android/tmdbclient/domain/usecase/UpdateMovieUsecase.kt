package com.salim.android.tmdbclient.domain.usecase

import com.salim.android.tmdbclient.data.model.movie.Movie
import com.salim.android.tmdbclient.domain.repository.MovieRepository

class UpdateMovieUsecase(private val movieRepository: MovieRepository) {

    suspend fun excute(): List<Movie>? = movieRepository.updateMovies()
}