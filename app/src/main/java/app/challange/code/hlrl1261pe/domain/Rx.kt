package app.challange.code.hlrl1261pe.domain

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object Rx {

    fun defaultSchedulers(): RxSchedulers = RxSchedulers(Schedulers.io(), AndroidSchedulers.mainThread())

}
