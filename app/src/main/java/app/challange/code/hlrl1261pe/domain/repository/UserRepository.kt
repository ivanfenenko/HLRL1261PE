package app.challange.code.hlrl1261pe.domain.repository

import app.challange.code.hlrl1261pe.data.model.WavyUser
import io.reactivex.Single
import retrofit2.Response

interface UserRepository {

    fun getUser(): Single<WavyUser>

    fun deleteUser(userId: String): Single<Response<Void>>

}
