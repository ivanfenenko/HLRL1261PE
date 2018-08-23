package app.challange.code.hlrl1261pe.domain.di

import app.challange.code.hlrl1261pe.domain.Rx
import app.challange.code.hlrl1261pe.domain.RxSchedulers
import dagger.Module
import dagger.Provides

@Module
class SchedulersModule {

    @Provides
    fun provideDefaultRxSchedulers(): RxSchedulers = Rx.defaultSchedulers()

}
