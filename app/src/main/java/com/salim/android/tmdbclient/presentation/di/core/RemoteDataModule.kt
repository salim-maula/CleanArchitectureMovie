package com.salim.android.tmdbclient.presentation.di.core

import com.salim.android.tmdbclient.data.api.TMDBService
import com.salim.android.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.salim.android.tmdbclient.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import com.salim.android.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.salim.android.tmdbclient.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.salim.android.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.salim.android.tmdbclient.data.repository.tvshow.datasourceimpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDatasource {
        return MovieRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDatasource {
        return TvShowRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDatasource {
        return ArtistRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }
}