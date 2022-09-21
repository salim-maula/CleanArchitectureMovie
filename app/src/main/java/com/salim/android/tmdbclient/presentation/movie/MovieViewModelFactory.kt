package com.salim.android.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.salim.android.tmdbclient.domain.usecase.GetMoviesUseCase
import com.salim.android.tmdbclient.domain.usecase.UpdateMovieUsecase

class MovieViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMovieUsecase: UpdateMovieUsecase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getMoviesUseCase, updateMovieUsecase) as T
    }
}