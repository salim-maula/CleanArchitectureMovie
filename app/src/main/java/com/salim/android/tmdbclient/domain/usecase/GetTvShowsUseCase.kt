package com.salim.android.tmdbclient.domain.usecase

import com.salim.android.tmdbclient.data.model.tv.TvShow
import com.salim.android.tmdbclient.domain.repository.TvShowRepository

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun excute(): List<TvShow>? = tvShowRepository.getTvShows()
}