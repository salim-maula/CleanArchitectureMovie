package com.salim.android.tmdbclient.presentation

import android.app.Application
import com.salim.android.tmdbclient.BuildConfig
import com.salim.android.tmdbclient.presentation.di.Injector
import com.salim.android.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.salim.android.tmdbclient.presentation.di.movie.MovieSubComponent
import com.salim.android.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import com.salim.android.tmdbclient.presentation.di.core.*

class App : Application(), Injector{

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
//        appComponent = DaggerAppComponent.builder()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
       return appComponent.artistSubComponent().create()
    }
}