package app.challange.code.hlrl1261pe.presentation.user

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import app.challange.code.hlrl1261pe.data.model.WavyUser
import app.challange.code.hlrl1261pe.domain.interactors.user.DeleteUserUseCase
import app.challange.code.hlrl1261pe.domain.interactors.user.GetUserUseCase
import app.challange.code.hlrl1261pe.presentation.user.model.DeleteUserState
import app.challange.code.hlrl1261pe.presentation.user.model.LoadUserState
import app.challange.code.hlrl1261pe.presentation.user.model.UserLiveData
import io.reactivex.observers.DisposableSingleObserver
import retrofit2.Response
import javax.inject.Inject

open class UserDetailActivityViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val deleteUserUseCase: DeleteUserUseCase
) : ViewModel() {

    internal val loadUserObservable = MutableLiveData<UserLiveData>()
    internal val deleteUserObservable = MutableLiveData<DeleteUserState>()

    internal val userLiveData = UserLiveData()
    internal var deleteUserLiveData = DeleteUserState.STATE_DEFAULT

    fun loadUser() {
        userLiveData.userState = LoadUserState.STATE_LOADING
        loadUserObservable.postValue(userLiveData)
        getUserUseCase.execute(GetUserUseCaseSubscriber())
    }

    fun deleteUser() {
        userLiveData.user?.let {
            deleteUserLiveData = DeleteUserState.STATE_LOADING
            deleteUserObservable.postValue(deleteUserLiveData)
            deleteUserUseCase.execute(DeleteUserUseCaseSubscriber(), DeleteUserUseCase.Params.withId(it.id))
        }
    }

    internal inner class GetUserUseCaseSubscriber : DisposableSingleObserver<WavyUser>() {

        override fun onSuccess(user: WavyUser) {
            userLiveData.userState = LoadUserState.STATE_DEFAULT
            userLiveData.user = user
            loadUserObservable.postValue(userLiveData)
        }

        override fun onError(exception: Throwable) {
            userLiveData.userState = LoadUserState.STATE_ERROR
            userLiveData.user = null
            loadUserObservable.postValue(userLiveData)
        }

    }

    internal inner class DeleteUserUseCaseSubscriber : DisposableSingleObserver<Response<Void>>() {

        override fun onSuccess(ignore: Response<Void>) {
            deleteUserLiveData = DeleteUserState.STATE_DELETED
            deleteUserObservable.postValue(deleteUserLiveData)
        }

        override fun onError(exception: Throwable) {
            deleteUserLiveData = DeleteUserState.STATE_ERROR
            deleteUserObservable.postValue(deleteUserLiveData)
        }

    }

    public override fun onCleared() {
        super.onCleared()
        getUserUseCase.dispose()
        deleteUserUseCase.dispose()
    }

}
