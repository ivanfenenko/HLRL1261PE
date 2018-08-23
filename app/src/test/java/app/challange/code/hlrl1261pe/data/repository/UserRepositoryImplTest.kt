package app.challange.code.hlrl1261pe.data.repository

import app.challange.code.hlrl1261pe.data.datasource.ApiInterface
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test

class UserRepositoryImplTest {

    private val apiServiceMock = mock<ApiInterface>()

    private lateinit var testedClass: UserRepositoryImpl

    @Before
    fun setUp() {
        testedClass = UserRepositoryImpl(apiServiceMock)
    }

    @Test
    fun `When get user is called, then get user api is executed`() {
        testedClass.getUser()

        verify(apiServiceMock).getUser()
    }

    @Test
    fun `Given user id, when delete user is called, then delete user api is executed with params`() {
        val userId = "hash"

        testedClass.deleteUser(userId)

        verify(apiServiceMock).deleteUser(userId)
    }

}
