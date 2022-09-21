package com.salim.android.tmdbclient.presentation.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.salim.android.tmdbclient.domain.usecase.GetMoviesUseCase
import com.salim.android.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.salim.android.tmdbclient.domain.usecase.UpdateMovieUsecase
import com.salim.android.tmdbclient.domain.usecase.UpdateTvShowUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
): ViewModel() {

    fun getTvShow()  = liveData {
        val tvShowList = getTvShowsUseCase.excute()
        emit(tvShowList)
    }

    fun updateTvShow() = liveData {
        val tvShowList = updateTvShowUseCase.excute()
        emit(tvShowList)
    }
}