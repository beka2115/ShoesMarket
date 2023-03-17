package com.example.shoesmarket.core.extension

import android.util.Patterns
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText

fun RecyclerView.initHorizontalAdapter(){
    layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
}


fun TextInputEditText.emailCheck(): Boolean{
 return Patterns.EMAIL_ADDRESS.matcher(text.toString()).matches()
}

fun EditText.nameReviewCheck():Boolean{
    return text?.isNotEmpty()==true
}
