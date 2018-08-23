package app.challange.code.hlrl1261pe.presentation.user

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.View
import app.challange.code.hlrl1261pe.R
import app.challange.code.hlrl1261pe.presentation.core.BaseActivity
import app.challange.code.hlrl1261pe.presentation.user.model.DeleteUserState
import app.challange.code.hlrl1261pe.presentation.user.model.LoadUserState
import kotlinx.android.synthetic.main.activity_user_detail.*
import timber.log.Timber

class UserDetailActivity : BaseActivity<UserDetailActivityViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initObservables()
        initViewModel()
        setDeleteButton()
    }

    private fun initViewModel() {
        viewModel.loadUser()
    }

    private fun initObservables() {
        initLoadingUserObservable()
        initDeleteUserObservable()
    }

    private fun initLoadingUserObservable() {
        viewModel.loadUserObservable.observe(this, Observer {
            it?.let {
                when (it.userState) {
                    LoadUserState.STATE_DEFAULT -> {
                        btn_delete.isEnabled = true
                        vw_user_card.visibility = View.VISIBLE
                        pb_profile_progress.visibility = View.GONE
                        it.user?.let { vw_user_card.bind(it) }
                    }
                    LoadUserState.STATE_ERROR -> {
                        btn_delete.isEnabled = false
                        vw_user_card.visibility = View.GONE
                        pb_profile_progress.visibility = View.GONE
                        showUserFailedToLoadError()
                    }
                    LoadUserState.STATE_LOADING -> {
                        btn_delete.isEnabled = false
                        vw_user_card.visibility = View.GONE
                        pb_profile_progress.visibility = View.VISIBLE
                    }
                }
            }
        })
    }

    private fun initDeleteUserObservable() {
        viewModel.deleteUserObservable.observe(this, Observer {
            when (it) {
                DeleteUserState.STATE_DEFAULT -> {
                    Timber.d("Doing nothing here DeleteUserState:$it")
                }
                DeleteUserState.STATE_DELETED -> {
                    showUserDeletedMessage()
                }
                DeleteUserState.STATE_LOADING -> {
                    Timber.d("Implement progress here DeleteUserState:$it")
                }
                DeleteUserState.STATE_ERROR -> {
                    showUserNotDeletedError()
                }
                else -> {
                    Timber.d("State is null! DeleteUserState:$it")
                }
            }
        })
    }

    private fun setDeleteButton() {
        btn_delete.setOnClickListener {
            showDeleteUserDialog({
                viewModel.deleteUser()
            })
        }
    }

    override fun getLayoutId() = R.layout.activity_user_detail

    override fun constructViewModel() = UserDetailActivityViewModel::class.java
}
