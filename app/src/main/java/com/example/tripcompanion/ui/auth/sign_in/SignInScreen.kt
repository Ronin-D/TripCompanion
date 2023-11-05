package com.example.tripcompanion.ui.auth

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tripcompanion.ui.auth.sign_in.SignInViewModel
import com.example.tripcompanion.ui.auth.sign_up.TextInput
import com.example.tripcompanion.ui.theme.DarkBlue
import com.example.tripcompanion.ui.theme.SilverBlue
import com.example.tripcompanion.ui.theme.SkyBlue

@Composable
fun SignInScreen(
    viewModel:SignInViewModel = hiltViewModel(),
    onNavigateToMainScreen:()->Unit,
    onNavigateToSignUp:()->Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val context=  LocalContext.current
        TextInput(
            value = viewModel.loginInputText.value,
            onValueChange ={
                viewModel.loginInputText.value = it
            },
            placeholder =  "Login",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp, start = 16.dp, end = 16.dp),
            isValidState = viewModel.isLoginValid.value,
            keyboardOptions = KeyboardOptions.Default
        )
        TextInput(
            value = viewModel.passwordInputText.value,
            onValueChange = {
                viewModel.passwordInputText.value = it
            },
            placeholder = "Password"
            ,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            isValidState = viewModel.isPasswordValid.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        if(viewModel.isLoading.value){
            CircularProgressIndicator(Modifier.scale(0.8f))
        }
        else{
            if (viewModel.isFound!=null&&viewModel.isFound!!){
                onNavigateToMainScreen()
            }
            else if (viewModel.isFound!=null){
                Toast.makeText(
                    context,
                    "user not found",
                    Toast.LENGTH_SHORT
                ).show()
            }
            viewModel.isFound = null
            Button(
                onClick = {
                    viewModel.logIn()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(60.dp)),
                colors = ButtonDefaults.buttonColors(SkyBlue)
            ) {
                Text(
                    text = "Confirm",
                    color = Color.White,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Text(
                text = "Register",
                color = DarkBlue,
                modifier = Modifier.clickable {
                    onNavigateToSignUp()
                }
            )
        }
    }
}
