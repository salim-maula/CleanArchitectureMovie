package com.salim.android.tmdbclient.presentation.di.movie

import com.salim.android.tmdbclient.presentation.artist.ArtistActivity
import com.salim.android.tmdbclient.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)
    @Subcomponent.Factory
    interface Factory{
        fun create(): MovieSubComponent
    }
}