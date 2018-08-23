package app.challange.code.hlrl1261pe.presentation.user.view

import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.challange.code.hlrl1261pe.R
import kotlinx.android.synthetic.main.bottom_dialog.*

class BottomDialog : BottomSheetDialogFragment() {

    private var title: String? = null
    private var message: String? = null
    private var positiveLabel: String? = null
    private var negativeLabel: String? = null
    private lateinit var positiveAction: () -> Unit
    private lateinit var negativeAction: () -> Unit

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.bottom_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindTitle()
        bindMessage()
        bindPositiveButton()
        bindNegativeAction()
    }

    private fun bindTitle() {
        tv_title.text = title
    }

    private fun bindMessage() {
        tv_message.text = message
    }

    private fun bindPositiveButton() {
        btn_positive.text = positiveLabel
        btn_positive.setOnClickListener {
            positiveAction()
            dismiss()

        }
    }

    private fun bindNegativeAction() {
        btn_negative.text = negativeLabel
        btn_negative.setOnClickListener {
            negativeAction()
            dismiss()
        }
    }

    fun title(title: String): BottomDialog {
        this.title = title
        return this
    }

    fun message(message: String): BottomDialog {
        this.message = message
        return this
    }

    fun positiveButton(label: String, action: () -> Unit): BottomDialog {
        this.positiveLabel = label
        this.positiveAction = action
        return this
    }

    fun negativeButton(label: String, action: () -> Unit): BottomDialog {
        this.negativeLabel = label
        this.negativeAction = action
        return this
    }

}
