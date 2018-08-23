package app.challange.code.hlrl1261pe.presentation.user

import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import app.challange.code.hlrl1261pe.R
import app.challange.code.hlrl1261pe.presentation.user.view.BottomDialog

fun AppCompatActivity.showDeleteUserDialog(positiveAction: () -> Unit) {
    BottomDialog()
        .title(getString(R.string.dialog_title_delete_user))
        .message(getString(R.string.dialog_message_delete_user))
        .positiveButton(getString(R.string.dialog_button_yes), positiveAction)
        .negativeButton(getString(R.string.dialog_button_no), {})
        .show(supportFragmentManager, "BottomDialog")
}

fun AppCompatActivity.showUserDeletedMessage() {
    Snackbar.make(findViewById(android.R.id.content), getString(R.string.message_user_deleted), Snackbar.LENGTH_LONG).show()
}

fun AppCompatActivity.showUserNotDeletedError() {
    Toast.makeText(this, getString(R.string.message_user_not_deleted), Toast.LENGTH_LONG).show()
}

fun AppCompatActivity.showUserFailedToLoadError() {
    Toast.makeText(this, getString(R.string.message_user_not_loaded), Toast.LENGTH_LONG).show()
}
