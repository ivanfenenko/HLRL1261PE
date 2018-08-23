package app.challange.code.hlrl1261pe.domain.interactors.user

import app.challange.code.hlrl1261pe.data.model.WavyUser
import app.challange.code.hlrl1261pe.domain.RxSchedulers
import app.challange.code.hlrl1261pe.domain.interactors.UseCaseSingle
import app.challange.code.hlrl1261pe.domain.repository.UserRepository
import io.reactivex.Single
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val gitRepoRepository: UserRepository,
    rxSchedulers: RxSchedulers
) : UseCaseSingle<WavyUser, Unit>(rxSchedulers) {

    override fun buildUseCaseObservable(params: Unit): Single<WavyUser> {
        return gitRepoRepository.getUser()
    }

}
