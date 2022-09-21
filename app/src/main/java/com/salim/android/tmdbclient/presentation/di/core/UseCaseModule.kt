package com.salim.android.tmdbclient.presentation.di.core

import com.salim.android.tmdbclient.domain.repository.ArtistRepository
import com.salim.android.tmdbclient.domain.repository.MovieRepository
import com.salim.android.tmdbclient.domain.repository.TvShowRepository
import com.salim.android.tmdbclient.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository) : GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository) : UpdateMovieUsecase{
        return UpdateMovieUsecase(movieRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository) : GetTvShowsUseCase{
        return GetTvShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository) : UpdateTvShowUseCase{
        return UpdateTvShowUseCase(tvShowRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository) : GetArtistsUseCase{
        return GetArtistsUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository) : UpdateArtistsUseCase{
        return UpdateArtistsUseCase(artistRepository)
    }
}