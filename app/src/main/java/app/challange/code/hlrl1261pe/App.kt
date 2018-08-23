package app.challange.code.hlrl1261pe

import dagger.android.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector() = DaggerAppComponent.builder()
        .application(this)
        .build()

}
