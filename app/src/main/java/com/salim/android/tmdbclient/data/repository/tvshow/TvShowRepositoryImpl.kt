package com.salim.android.tmdbclient.data.repository.tvshow

import android.util.Log
import com.salim.android.tmdbclient.data.model.artist.Artist
import com.salim.android.tmdbclient.data.model.tv.TvShow
import com.salim.android.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.salim.android.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.salim.android.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.salim.android.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.salim.android.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.salim.android.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.salim.android.tmdbclient.domain.repository.ArtistRepository
import com.salim.android.tmdbclient.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDatasource: TvShowRemoteDatasource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository {

    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
       val newListOfTvShows = getTvShowFromApi()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShows)
        return newListOfTvShows
    }

    //add new function
    suspend fun getTvShowFromApi(): List<TvShow>{

        lateinit var tvShowList: List<TvShow>

        try {
            val response = tvShowRemoteDatasource.getTvShows()
            val body = response.body()
            if (body!=null){
                tvShowList = body.results
            }
        }catch (exception:Exception){
            Log.i("TAG", "getMoviesFromApi: ${exception.message.toString()}")
        }
        return tvShowList
    }

    suspend fun getTvShowFromDB(): List<TvShow>{

        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDB()
        }catch (exception:Exception){
            Log.i("TAG", "getMoviesFromApi: ${exception.message.toString()}")
        }

        if (tvShowList.size>0){
            return tvShowList
        }else{
            tvShowList = getTvShowFromApi()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowFromCache(): List<TvShow>{

        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()
        }catch (exception:Exception){
            Log.i("TAG", "getMoviesFromApi: ${exception.message.toString()}")
        }

        if (tvShowList.size>0){
            return tvShowList
        }else{
            tvShowList = getTvShowFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
        }
        return tvShowList
    }

}