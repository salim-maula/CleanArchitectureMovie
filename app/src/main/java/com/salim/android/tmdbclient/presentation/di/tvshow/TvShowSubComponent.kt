package com.salim.android.tmdbclient.presentation.di.tvshow

import com.salim.android.tmdbclient.presentation.artist.ArtistActivity
import com.salim.android.tmdbclient.presentation.tv.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvShowActivity)
    @Subcomponent.Factory
    interface Factory{
        fun create(): TvShowSubComponent
    }
}