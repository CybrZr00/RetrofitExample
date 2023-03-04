package uk.co.digitaljeeves.retrofitexample

import retrofit2.Response
import retrofit2.http.GET

interface IAlbumService {
    @GET("/albums")
    suspend fun getAlbums() : Response<Albums>
}