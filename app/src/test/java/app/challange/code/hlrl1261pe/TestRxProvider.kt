package app.challange.code.hlrl1261pe

import app.challange.code.hlrl1261pe.domain.RxSchedulers
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class TestRxProvider {

    companion object {

        fun provideRxSchedulers(
            io: Scheduler = Schedulers.trampoline(),
            androidMainThread: Scheduler = Schedulers.trampoline()
        ): RxSchedulers {
            return RxSchedulers(io, androidMainThread)
        }

    }

}
