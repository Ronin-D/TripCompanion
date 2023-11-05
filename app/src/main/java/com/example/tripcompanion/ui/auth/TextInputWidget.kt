package com.example.tripcompanion.ui.auth.sign_up

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.tripcompanion.ui.theme.DarkBlue
import com.example.tripcompanion.ui.theme.SilverBlue
import com.example.tripcompanion.ui.theme.SkyBlue

@Composable
fun TextInput (
    value:String,
    placeholder:String,
    modifier: Modifier,
    isValidState:Boolean,
    keyboardOptions:KeyboardOptions,
    onValueChange:(String)->Unit
){

    val unfocusedBorderColor: Color = if (isValidState){
        DarkBlue
    }
    else{
        Color.Red
    }
    Column(modifier = modifier) {
        OutlinedTextField(
            value =value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .background(SilverBlue),
            singleLine = true,
            keyboardOptions = keyboardOptions,
            placeholder = {
                Text(text = placeholder, color = Color.Black)
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = unfocusedBorderColor,
                focusedBorderColor = SkyBlue,
                disabledBorderColor = SkyBlue,
                focusedLabelColor = SkyBlue,
                unfocusedLabelColor = unfocusedBorderColor
            ),
        )
        AnimatedVisibility(visible = !isValidState) {
            Text(text = "field mast be filled", color = unfocusedBorderColor)
        }
    }
}