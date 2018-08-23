package app.challange.code.hlrl1261pe.domain.interactors.user

import app.challange.code.hlrl1261pe.domain.RxSchedulers
import app.challange.code.hlrl1261pe.domain.interactors.UseCaseSingle
import app.challange.code.hlrl1261pe.domain.repository.UserRepository
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject

class DeleteUserUseCase @Inject constructor(
    private val gitRepoRepository: UserRepository,
    rxSchedulers: RxSchedulers
) : UseCaseSingle<Response<Void>, DeleteUserUseCase.Params>(rxSchedulers) {

    override fun buildUseCaseObservable(params: Params): Single<Response<Void>> {
        return gitRepoRepository.deleteUser(params.userId)
    }

    class Params constructor(val userId: String) {

        companion object {

            fun withId(userId: String): Params {
                return Params(userId)
            }

        }

    }

}
