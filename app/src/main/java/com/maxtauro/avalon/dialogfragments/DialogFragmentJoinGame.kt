package com.maxtauro.monopolywallet.DialogFragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.maxtauro.avalon.dialogfragments.validate
import com.maxtauro.avalon.R

/**
 * DialogFragment class for joining a game lobby
 */
class DialogFragmentJoinGame(private val onSuccess: (String, String) -> Unit) : DialogFragment() {

    private lateinit var gameIdInput: EditText
    private lateinit var playerNameInput: EditText

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val joinBtnLabel: String = getString(R.string.join_game_button_label)

        val builder = AlertDialog.Builder(activity)
            .setView(createView())
            .setPositiveButton(joinBtnLabel) { _, _ -> onJoinButtonClicked() }
            .setNegativeButton("Cancel") { _, _ -> dismiss() }

        return builder.create()
    }

    private fun onJoinButtonClicked() {
        Log.d(TAG, CLICKED_JOIN)
        val gameIdInputTxt = gameIdInput.text.toString()
        val playerNameInputTxt = playerNameInput.text.toString()

        if (gameIdInput.error == null && playerNameInput.error == null) {
            Log.d(TAG, INPUT_SUCCESS)
            onSuccess(gameIdInputTxt, playerNameInputTxt)
            dismiss()
        }

    }

    private fun createView(): View {
        val inflater = activity!!.layoutInflater
        val layout = inflater.inflate(R.layout.dialog_join_game, null)

        gameIdInput = layout.findViewById<EditText>(R.id.game_id_input)
        playerNameInput = layout.findViewById<EditText>(R.id.nickname_input)

        //Strings for messages
        val invalidGameIdFormatMsg: String = getString(R.string.invalid_game_id_format_msg)
        val invalidPlayerNameMessage: String = getString(R.string.invalid_name_msg)

        // TODO, only validate on submit
        gameIdInput.validate({ s -> isValidGameIdInput(s) }, invalidGameIdFormatMsg)
        playerNameInput.validate(
            { s -> s.isNotEmpty() && s.length < 255 },
            invalidPlayerNameMessage
        )

        return layout
    }

    private fun isValidGameIdInput(gameIdInput: String): Boolean {
        val isCorrectLength = gameIdInput.length == 6
        val isAlphaNumeric = gameIdInput.matches(Regex("[A-Za-z0-9]+"))

        return isCorrectLength && isAlphaNumeric
    }

    companion object {
        private const val TAG = "DialogFragmentJoinGame"
        private const val CLICKED_JOIN = "User clicked Join button"
        private const val INPUT_SUCCESS = "Valid Input, dismissing Fragment"

        fun createInstance(onSuccess: (String, String) -> Unit): DialogFragmentJoinGame {
            return DialogFragmentJoinGame(onSuccess)
        }
    }
}


