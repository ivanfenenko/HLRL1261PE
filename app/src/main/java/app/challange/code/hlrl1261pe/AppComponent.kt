package app.challange.code.hlrl1261pe

import app.challange.code.hlrl1261pe.data.di.NetworkModule
import app.challange.code.hlrl1261pe.data.di.RepositoriesModule
import app.challange.code.hlrl1261pe.domain.di.SchedulersModule
import app.challange.code.hlrl1261pe.presentation.di.ActivitiesModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivitiesModule::class,
        RepositoriesModule::class,
        SchedulersModule::class,
        NetworkModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: App): Builder

        fun build(): AppComponent

    }

}
