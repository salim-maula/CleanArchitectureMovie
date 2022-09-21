package com.salim.android.tmdbclient.presentation.di.core

import com.salim.android.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.salim.android.tmdbclient.data.repository.artist.datasourceimpl.ArtistCacheDataSourceImpl
import com.salim.android.tmdbclient.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import com.salim.android.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.salim.android.tmdbclient.data.repository.movie.datasourceimpl.MovieCacheDataSourceImpl
import com.salim.android.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.salim.android.tmdbclient.data.repository.tvshow.datasourceimpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource{
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource{
        return ArtistCacheDataSourceImpl()
    }

}