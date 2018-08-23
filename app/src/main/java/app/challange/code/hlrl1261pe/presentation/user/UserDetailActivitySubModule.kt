package app.challange.code.hlrl1261pe.presentation.user

import android.arch.lifecycle.ViewModel
import app.challange.code.hlrl1261pe.presentation.core.ViewModelKey
import app.challange.code.hlrl1261pe.presentation.di.BaseActivityBindingModule
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class UserDetailActivitySubModule :
    BaseActivityBindingModule<UserDetailActivity> {

    @Binds
    @IntoMap
    @ViewModelKey(UserDetailActivityViewModel::class)
    abstract fun bindUserDetailActivityViewModel(userDetailActivityViewModel: UserDetailActivityViewModel): ViewModel

}
