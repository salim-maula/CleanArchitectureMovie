package com.salim.android.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.salim.android.tmdbclient.domain.usecase.GetMoviesUseCase
import com.salim.android.tmdbclient.domain.usecase.UpdateMovieUsecase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMovieUsecase: UpdateMovieUsecase
): ViewModel() {

    fun getMovies()  = liveData {
        val movieList = getMoviesUseCase.excute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMovieUsecase.excute()
        emit(movieList)
    }
}