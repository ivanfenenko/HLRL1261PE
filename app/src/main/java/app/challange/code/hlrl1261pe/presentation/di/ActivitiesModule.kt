package app.challange.code.hlrl1261pe.presentation.di

import android.arch.lifecycle.ViewModelProvider
import app.challange.code.hlrl1261pe.presentation.core.ViewModelFactory
import app.challange.code.hlrl1261pe.presentation.user.UserDetailActivity
import app.challange.code.hlrl1261pe.presentation.user.UserDetailActivitySubModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {

    @ContributesAndroidInjector(modules = [UserDetailActivitySubModule::class])
    abstract fun bindSearchRepositoryActivity(): UserDetailActivity

    /* VIEW MODEL FACTORY */

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}
