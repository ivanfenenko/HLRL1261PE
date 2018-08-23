package app.challange.code.hlrl1261pe.data.repository

import app.challange.code.hlrl1261pe.data.datasource.ApiInterface
import app.challange.code.hlrl1261pe.data.model.WavyUser
import app.challange.code.hlrl1261pe.domain.repository.UserRepository
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private var apiService: ApiInterface) : UserRepository {

    override fun getUser(): Single<WavyUser> {
        return apiService.getUser()
    }

    override fun deleteUser(userId: String): Single<Response<Void>> {
        return apiService.deleteUser(userId)
    }

}
