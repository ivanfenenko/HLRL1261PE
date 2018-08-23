package app.challange.code.hlrl1261pe.presentation.user.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import app.challange.code.hlrl1261pe.R
import app.challange.code.hlrl1261pe.data.model.WavyUser
import app.challange.code.hlrl1261pe.presentation.core.glide.GlideApp
import kotlinx.android.synthetic.main.user_card_view.view.*

class UserCard : FrameLayout {

    constructor(ctx: Context) : super(ctx) {
        init()
    }

    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs) {
        init()
    }

    private fun init() {
        View.inflate(context, R.layout.user_card_view, this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(user: WavyUser) {
        tv_user_name.text = "${user.firstName} ${user.lastName}"
        tv_phone_number.text = user.phoneNumber
        tv_email.text = user.email
        GlideApp
            .with(this)
            .load(user.profilePicture)
            .placeholder(R.drawable.ic_avatar_placeholder)
            .circleCrop()
            .into(iv_profile_pic)
    }

}
