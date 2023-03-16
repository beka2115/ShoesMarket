package com.example.shoesmarket

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.PopupMenu
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.example.shoesmarket.databinding.FragmentTestBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class TestFragment : Fragment() {

    private lateinit var binding: FragmentTestBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTestBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        binding.btnMore.setOnClickListener {
            showPopupMenu()
        }
    }

    private fun showPopupMenu() {
        val popupMenu = PopupMenu(requireContext(),binding.btnMore)
        val inflater = popupMenu.menuInflater
        inflater.inflate(R.menu.popup_menu,popupMenu.menu)
        popupMenu.show()
    }

    private fun initListener() {
        var emailAnswer: Boolean
        var nameAnswer: Boolean
        var reviewAnswer: Boolean
        with(binding) {
            btnSend.setOnClickListener {
                emailAnswer = emailChecker()
                nameAnswer = nameReviewChecker(editText = editName, editContainer = editNameContainer, errorHelperText = "Write your name")
                reviewAnswer = nameReviewChecker(editText = editReview,editContainer = editReviewContainer,errorHelperText = "Write review")

                if (emailAnswer&& nameAnswer&&reviewAnswer){
                    Toast.makeText(requireContext(), "good", Toast.LENGTH_SHORT).show()
                }else Toast.makeText(requireContext(), "bad", Toast.LENGTH_SHORT).show()
            }
            editReviewNameCheck(editText = editName, editTextContainer = editNameContainer,20)
            editReviewNameCheck(editText = editReview, editTextContainer = editReviewContainer,300)
            editEmailCheck()
        }
    }

    private fun editReviewNameCheck(editText: TextInputEditText,editTextContainer: TextInputLayout,maxLength: Int) {
        editText.doOnTextChanged { text, _, _, _ ->
            if (nameReviewCheck(editText)) {
                if (text!!.length < maxLength) {
                    editTextContainer.boxStrokeWidth = 0
                    editTextContainer.helperText = null
                    editText.background = ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.bg_review_edittext
                    )
                } else {
                    editTextContainer.boxStrokeWidth = 3
                    editTextContainer.helperText = "Max length of simvols"
                    editText.background = ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.bg_error_edittext
                    )
                }
            }

        }
    }

    private fun editEmailCheck(){
        with(binding) {
            editEmail.doOnTextChanged { _, _, _, _ ->
                if (emailCheck()) {
                    editEmailConteiner.boxStrokeWidth = 0
                    editEmailConteiner.helperText = null
                    editEmail.background =
                        ContextCompat.getDrawable(requireContext(), R.drawable.bg_review_edittext)
                }
            }
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun emailChecker(): Boolean {
        var answer = false
        with(binding) {
            if (!emailCheck()) {
                editEmailConteiner.boxStrokeWidth = 3
                editEmailConteiner.helperText = "invalid E-mail address"
                editEmail.background = ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.bg_error_edittext
                )
                answer = false
            } else if (emailCheck()) {
                editEmailConteiner.boxStrokeWidth = 0
                editEmailConteiner.helperText = null
                editEmail.background = ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.bg_review_edittext
                )
                answer = true
            }
        }
        return answer
    }

    private fun nameReviewChecker(
        editText: TextInputEditText,
        editContainer: TextInputLayout,
        errorHelperText: String,
    ): Boolean {
        var answer = false

        if (!nameReviewCheck(editText)) {
            editContainer.boxStrokeWidth = 3
            editContainer.helperText = errorHelperText
            editText.background = ContextCompat.getDrawable(
                requireContext(),
                R.drawable.bg_error_edittext
            )
            answer = false
        } else if (nameReviewCheck(editText)) {
            editContainer.boxStrokeWidth = 0
            editContainer.helperText = null
            editText.background = ContextCompat.getDrawable(
                requireContext(),
                R.drawable.bg_review_edittext
            )
            answer = true
        }
        return answer
    }

    private fun emailCheck(): Boolean {
        var answer: Boolean
        with(binding) {
            val emailColor = editEmail.text.toString()
            answer = Patterns.EMAIL_ADDRESS.matcher(emailColor).matches()
        }
        return answer
    }

    private fun nameReviewCheck(editText: EditText): Boolean {
        return editText.text?.isNotEmpty() == true
    }
}