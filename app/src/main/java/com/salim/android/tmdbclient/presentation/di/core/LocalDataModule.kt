package com.salim.android.tmdbclient.presentation.di.core

import com.salim.android.tmdbclient.data.db.ArtistDao
import com.salim.android.tmdbclient.data.db.MovieDao
import com.salim.android.tmdbclient.data.db.TvShowDao
import com.salim.android.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.salim.android.tmdbclient.data.repository.artist.datasourceimpl.ArtistLocalDataSourceImpl
import com.salim.android.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.salim.android.tmdbclient.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import com.salim.android.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.salim.android.tmdbclient.data.repository.tvshow.datasourceimpl.TvShowLocalDataSourceImpl
import com.salim.android.tmdbclient.data.repository.tvshow.datasourceimpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource{
        return TvShowLocalDataSourceImpl(tvShowDao)
    }
    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource{
        return ArtistLocalDataSourceImpl(artistDao)
    }

}