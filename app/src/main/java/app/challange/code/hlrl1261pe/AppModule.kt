package app.challange.code.hlrl1261pe

import android.content.Context
import app.challange.code.hlrl1261pe.App
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideContext(app: App): Context = app

}
