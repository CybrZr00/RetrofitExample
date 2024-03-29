package uk.co.digitaljeeves.retrofitexample

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IAlbumService {
    @GET("/albums")
    suspend fun getAlbums() : Response<Albums>

    @GET("/albums")
    suspend fun getUsersAlbums(@Query("userId") userId: Int) : Response<Albums>

    @GET("/albums/{id}")
    suspend fun getAlbum(@Path("id") albumId: Int) : Response<AlbumsItem>
}