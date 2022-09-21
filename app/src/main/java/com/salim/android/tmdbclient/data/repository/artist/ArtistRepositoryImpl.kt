package com.salim.android.tmdbclient.data.repository.artist

import android.util.Log
import com.salim.android.tmdbclient.data.model.artist.Artist
import com.salim.android.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.salim.android.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.salim.android.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.salim.android.tmdbclient.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDatasource: ArtistRemoteDatasource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {

    override suspend fun getArtists(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
       val newListOfArtists = getArtistFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        artistCacheDataSource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }

    //add new function
    suspend fun getArtistFromApi(): List<Artist>{

        lateinit var artistList: List<Artist>

        try {
            val response = artistRemoteDatasource.getArtists()
            val body = response.body()
            if (body!=null){
                artistList = body.artists
            }
        }catch (exception:Exception){
            Log.i("TAG", "getMoviesFromApi: ${exception.message.toString()}")
        }
        return artistList
    }

    suspend fun getArtistFromDB(): List<Artist>{

        lateinit var artistList: List<Artist>

        try {
            artistList = artistLocalDataSource.getArtistsFromDB()
        }catch (exception:Exception){
            Log.i("TAG", "getMoviesFromApi: ${exception.message.toString()}")
        }

        if (artistList.size>0){
            return artistList
        }else{
            artistList = getArtistFromApi()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistFromCache(): List<Artist>{

        lateinit var artistList: List<Artist>

        try {
            artistList = artistCacheDataSource.getArtistsFromCache()
        }catch (exception:Exception){
            Log.i("TAG", "getMoviesFromApi: ${exception.message.toString()}")
        }

        if (artistList.size>0){
            return artistList
        }else{
            artistList = getArtistFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }
        return artistList
    }

}