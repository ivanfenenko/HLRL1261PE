package app.challange.code.hlrl1261pe.presentation.di

import android.support.v7.app.AppCompatActivity
import dagger.Binds
import dagger.Module

@Module
interface BaseActivityBindingModule<in T : AppCompatActivity> {

    @Binds
    fun bindActivity(activity: T): AppCompatActivity

}
