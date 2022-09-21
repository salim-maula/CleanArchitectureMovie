package com.salim.android.tmdbclient.presentation.di.core

import com.salim.android.tmdbclient.data.repository.artist.ArtistRepositoryImpl
import com.salim.android.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.salim.android.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.salim.android.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.salim.android.tmdbclient.data.repository.movie.MovieRepositoryImpl
import com.salim.android.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.salim.android.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.salim.android.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.salim.android.tmdbclient.data.repository.tvshow.TvShowRepositoryImpl
import com.salim.android.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.salim.android.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.salim.android.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.salim.android.tmdbclient.domain.repository.ArtistRepository
import com.salim.android.tmdbclient.domain.repository.MovieRepository
import com.salim.android.tmdbclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowRemoteDatasource: TvShowRemoteDatasource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(
           tvShowRemoteDatasource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDatasource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDatasource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }
}