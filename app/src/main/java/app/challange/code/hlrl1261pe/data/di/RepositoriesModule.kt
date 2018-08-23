package app.challange.code.hlrl1261pe.data.di

import app.challange.code.hlrl1261pe.data.repository.UserRepositoryImpl
import app.challange.code.hlrl1261pe.domain.repository.UserRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoriesModule {

    @Binds
    abstract fun bindGitRepoRepository(gitRepoRepository: UserRepositoryImpl): UserRepository

}
