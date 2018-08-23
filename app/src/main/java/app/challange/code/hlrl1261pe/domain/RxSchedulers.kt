package app.challange.code.hlrl1261pe.domain

import io.reactivex.Scheduler
import javax.inject.Inject

class RxSchedulers @Inject constructor(val io: Scheduler, val androidMainThread: Scheduler)
