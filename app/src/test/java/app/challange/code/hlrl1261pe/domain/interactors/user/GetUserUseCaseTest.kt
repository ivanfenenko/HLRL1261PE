package app.challange.code.hlrl1261pe.domain.interactors.user

import app.challange.code.hlrl1261pe.TestRxProvider.Companion.provideRxSchedulers
import app.challange.code.hlrl1261pe.domain.repository.UserRepository
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test

class GetUserUseCaseTest {

    private val userRepositoryMock = mock<UserRepository>()

    private lateinit var testedClass: GetUserUseCase

    @Before
    fun setUp() {
        testedClass = GetUserUseCase(userRepositoryMock, provideRxSchedulers())
    }

    @Test
    fun `When use case is built, then get user repository is triggered`() {
        val params = Unit

        testedClass.buildUseCaseObservable(params)

        verify(userRepositoryMock).getUser()
    }

}
