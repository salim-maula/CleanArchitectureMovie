package com.salim.android.tmdbclient.presentation.di.tvshow

import com.salim.android.tmdbclient.domain.usecase.*
import com.salim.android.tmdbclient.presentation.artist.ArtistViewModelFactory
import com.salim.android.tmdbclient.presentation.movie.MovieViewModelFactory
import com.salim.android.tmdbclient.presentation.tv.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowUseCase: UpdateTvShowUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowUseCase)
    }
}