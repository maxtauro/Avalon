package com.maxtauro.monopolywallet.DialogFragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.maxtauro.avalon.DialogFragments.validate
import com.maxtauro.avalon.R

/**
 * Dialog Fragment for creating/hosting A Game Lobby
 */
class DialogFragmentCreateGame(private val onSuccess: (String) -> Unit) : DialogFragment() {

    private lateinit var hostNameInput: EditText

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Button label
        val createGameBtnLabel: String = getString(R.string.create_game_button_label)
        val cancelBtnLabel: String = getString(R.string.cancel_button_label)

        val builder = AlertDialog.Builder(activity)
            .setView(createView())
            .setPositiveButton(createGameBtnLabel) { _, _ -> onSuccess(hostNameInput.toString()) }
            .setNegativeButton(cancelBtnLabel) { _, _ -> dismiss() }

        return builder.create()
    }

    private fun createView(): View {
        val inflater = activity!!.layoutInflater
        val layout = inflater.inflate(R.layout.dialog_create_game, null)

        hostNameInput = layout.findViewById<EditText>(R.id.host_name_input)
        val invalidNameMsg = getString(R.string.invalid_name_msg)

        hostNameInput.validate({ s -> s.isNotEmpty() && s.length < 255 }, invalidNameMsg)

        return layout
    }

    companion object {
        private const val TAG = "Fragment CreateGame"
        private const val CLICKED_CREATE = "User clicked Create button"
        private const val INPUT_SUCCESS = "Valid Input, dismissing Fragment"


        fun createInstance(onSuccess: (String) -> Unit): DialogFragmentCreateGame {
            return DialogFragmentCreateGame(onSuccess)
        }
    }
}