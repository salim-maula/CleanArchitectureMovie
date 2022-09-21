package com.salim.android.tmdbclient.presentation.di

import com.salim.android.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.salim.android.tmdbclient.presentation.di.movie.MovieSubComponent
import com.salim.android.tmdbclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}