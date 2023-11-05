package com.example.tripcompanion.ui.auth

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tripcompanion.ui.auth.sign_up.SignUpViewModel
import com.example.tripcompanion.ui.auth.sign_up.TextInput
import com.example.tripcompanion.ui.theme.DarkBlue
import com.example.tripcompanion.ui.theme.SilverBlue
import com.example.tripcompanion.ui.theme.SkyBlue

@Composable
fun SignUpScreen(
    viewModel:SignUpViewModel = hiltViewModel(),
    onNavigateBack:()->Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Icon(
            painter = rememberVectorPainter(Icons.Default.ArrowBack),
            contentDescription = "arrow back",
            modifier = Modifier
                .align(Alignment.Start)
                .padding(8.dp)
                .clickable {
                    onNavigateBack()
                }
        )
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
                    viewModel.isLoginValid.value = true
                },
                placeholder =  "Login",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                isValidState = viewModel.isLoginValid.value,
                keyboardOptions = KeyboardOptions.Default
            )
            TextInput(
                value = viewModel.passwordInputText.value,
                onValueChange = {
                    viewModel.passwordInputText.value = it
                    viewModel.isPasswordValid.value = true
                },
                placeholder = "Password"
                ,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 16.dp),
                isValidState = viewModel.isPasswordValid.value,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            TextInput(
                value = viewModel.repeatPasswordInputText.value,
                onValueChange = {
                    viewModel.repeatPasswordInputText.value = it
                    viewModel.isRepeatPasswordValid.value = true
                },
                placeholder = "repeat password"
                ,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                isValidState = viewModel.isRepeatPasswordValid.value,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            if(viewModel.isLoading.value){
                CircularProgressIndicator(Modifier.scale(0.8f))
            }
            else{
                if (viewModel.isRegistered){
                    onNavigateBack()
                }
                viewModel.isRegistered= false
                Button(
                    onClick = {
                        viewModel.register()
                        //onNavigateBack()
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
            }
        }
    }
}