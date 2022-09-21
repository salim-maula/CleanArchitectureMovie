package com.salim.android.tmdbclient.presentation.di.movie

import com.salim.android.tmdbclient.domain.usecase.GetArtistsUseCase
import com.salim.android.tmdbclient.domain.usecase.GetMoviesUseCase
import com.salim.android.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.salim.android.tmdbclient.domain.usecase.UpdateMovieUsecase
import com.salim.android.tmdbclient.presentation.artist.ArtistViewModelFactory
import com.salim.android.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMovieUsecase: UpdateMovieUsecase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMovieUsecase)
    }
}