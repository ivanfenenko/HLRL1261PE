package app.challange.code.hlrl1261pe.domain.interactors.user

import app.challange.code.hlrl1261pe.TestRxProvider.Companion.provideRxSchedulers
import app.challange.code.hlrl1261pe.domain.repository.UserRepository
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test

class DeleteUserUseCaseTest {

    private val userRepositoryMock = mock<UserRepository>()

    private lateinit var testedClass: DeleteUserUseCase

    @Before
    fun setUp() {
        testedClass = DeleteUserUseCase(userRepositoryMock, provideRxSchedulers())
    }

    @Test
    fun `Given user id, when use case is built, then delete user repository is triggered with params`() {
        val userId = "hash"
        val params = DeleteUserUseCase.Params.withId(userId)

        testedClass.buildUseCaseObservable(params)

        verify(userRepositoryMock).deleteUser(userId)
    }

}
