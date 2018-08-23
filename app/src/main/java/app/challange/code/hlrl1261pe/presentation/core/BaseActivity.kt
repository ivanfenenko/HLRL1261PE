package app.challange.code.hlrl1261pe.presentation.core

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

abstract class BaseActivity<T : ViewModel> : AppCompatActivity() {

    @Inject protected lateinit var viewModel: T
    @Inject protected lateinit var viewModelFactory: ViewModelProvider.Factory

    /* LIFECYCLE */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initInjector()
        setContentView(getLayoutId())
        setViewModel()
    }

    private fun initInjector() {
        AndroidInjection.inject(this)
    }

    private fun setViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(constructViewModel())
    }

    protected abstract fun getLayoutId(): Int

    protected abstract fun constructViewModel(): Class<T>

}
