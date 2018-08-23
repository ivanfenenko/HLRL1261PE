package app.challange.code.hlrl1261pe.data.datasource

import app.challange.code.hlrl1261pe.data.model.WavyUser
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("user/all")
    fun getUser(): Single<WavyUser>

    @DELETE("user/{id}")
    fun deleteUser(@Path("id") userId: String): Single<Response<Void>>

}
