package app.challange.code.hlrl1261pe.presentation.user

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.Observer
import app.challange.code.hlrl1261pe.data.model.WavyUser
import app.challange.code.hlrl1261pe.domain.interactors.user.DeleteUserUseCase
import app.challange.code.hlrl1261pe.domain.interactors.user.GetUserUseCase
import app.challange.code.hlrl1261pe.presentation.user.model.DeleteUserState
import app.challange.code.hlrl1261pe.presentation.user.model.LoadUserState
import app.challange.code.hlrl1261pe.presentation.user.model.UserLiveData
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.anyOrNull
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentCaptor

class UserDetailActivityViewModelTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private val getUserUseCaseMock = mock<GetUserUseCase>()
    private val deleteUserUseCaseMock = mock<DeleteUserUseCase>()

    private val loadUserLiveDataObservableMock = mock<Observer<UserLiveData>>()
    private val deleteUserLiveDataObservableMock = mock<Observer<DeleteUserState>>()

    private val deleteUserUseCaseCaptor = ArgumentCaptor.forClass(DeleteUserUseCase.Params::class.java)
    private val userLiveDataCaptor = ArgumentCaptor.forClass(UserLiveData::class.java)
    private val deleteUserStateCaptor = ArgumentCaptor.forClass(DeleteUserState::class.java)

    private lateinit var testedClass: UserDetailActivityViewModel
    private lateinit var getUserUseCaseObserver: UserDetailActivityViewModel.GetUserUseCaseSubscriber
    private lateinit var deleteUserUseCaseObserver: UserDetailActivityViewModel.DeleteUserUseCaseSubscriber

    @Before
    fun setUp() {
        testedClass = UserDetailActivityViewModel(getUserUseCaseMock, deleteUserUseCaseMock)
        testedClass.loadUserObservable.observeForever(loadUserLiveDataObservableMock)
        testedClass.deleteUserObservable.observeForever(deleteUserLiveDataObservableMock)
        getUserUseCaseObserver = testedClass.GetUserUseCaseSubscriber()
        deleteUserUseCaseObserver = testedClass.Delgit eteUserUseCaseSubscriber()
    }

    // Load user

    @Test
    fun `When get user is called, then get user use case is executed`() {
        testedClass.loadUser()

        verify(getUserUseCaseMock).execute(any(), anyOrNull())
        verify(loadUserLiveDataObservableMock).onChanged(userLiveDataCaptor.capture())
        assertThat(userLiveDataCaptor.value.userState).isEqualTo(LoadUserState.STATE_LOADING)
    }

    @Test
    fun `Given successful response, when user is loaded, then data is being posted`() {
        val user = WavyUser(
            "id",
            "firstName",
            "lastName",
            "phone",
            "email",
            "avatar"
        )

        getUserUseCaseObserver.onSuccess(user)

        verify(loadUserLiveDataObservableMock).onChanged(userLiveDataCaptor.capture())
        assertThat(userLiveDataCaptor.value.user).isEqualTo(user)
        assertThat(userLiveDataCaptor.value.userState).isEqualTo(LoadUserState.STATE_DEFAULT)
    }

    @Test
    fun `Given error response, when user failed to load, then error is posted`() {
        val exception = UnsupportedOperationException()

        getUserUseCaseObserver.onError(exception)

        verify(loadUserLiveDataObservableMock).onChanged(userLiveDataCaptor.capture())
        assertThat(userLiveDataCaptor.value.userState).isEqualTo(LoadUserState.STATE_ERROR)
    }

    // Delete user

    @Test
    fun `Given user, when delete user is called, then delete user use case is executed with params`() {
        val user = WavyUser(
            "id",
            "firstName",
            "lastName",
            "phone",
            "email",
            "avatar"
        )
        testedClass.userLiveData.user = user

        testedClass.deleteUser()

        verify(deleteUserUseCaseMock).execute(any(), deleteUserUseCaseCaptor.capture())
        assertThat(deleteUserUseCaseCaptor.value.userId).isEqualTo(user.id)
        verify(deleteUserLiveDataObservableMock).onChanged(deleteUserStateCaptor.capture())
        assertThat(deleteUserStateCaptor.value).isEqualTo(DeleteUserState.STATE_LOADING)
    }

    @Test
    fun `Given successful response, when user is deleted, then delete state is being posted`() {
        deleteUserUseCaseObserver.onSuccess(mock())

        verify(deleteUserLiveDataObservableMock).onChanged(deleteUserStateCaptor.capture())
        assertThat(deleteUserStateCaptor.value).isEqualTo(DeleteUserState.STATE_DELETED)
    }

    @Test
    fun `Given error response, when user failed to delete, then error is posted`() {
        val exception = UnsupportedOperationException()

        deleteUserUseCaseObserver.onError(exception)

        verify(deleteUserLiveDataObservableMock).onChanged(deleteUserStateCaptor.capture())
        assertThat(deleteUserStateCaptor.value).isEqualTo(DeleteUserState.STATE_ERROR)
    }

    @Test
    fun `When view model is cleared, then use cases are disposed`() {
        testedClass.onCleared()

        verify(getUserUseCaseMock).dispose()
        verify(deleteUserUseCaseMock).dispose()
    }

}
