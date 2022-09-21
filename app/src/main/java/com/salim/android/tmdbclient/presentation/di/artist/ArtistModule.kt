package com.salim.android.tmdbclient.presentation.di.artist

import com.salim.android.tmdbclient.domain.usecase.GetArtistsUseCase
import com.salim.android.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.salim.android.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }
}