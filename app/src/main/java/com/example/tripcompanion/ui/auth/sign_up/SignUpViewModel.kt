package com.example.tripcompanion.ui.auth.sign_up

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tripcompanion.data.api.UserApi
import com.example.tripcompanion.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okhttp3.internal.userAgent
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
   private val userApi: UserApi
) : ViewModel() {
    val loginInputText = mutableStateOf("")
    val passwordInputText = mutableStateOf("")
    val repeatPasswordInputText = mutableStateOf("")
    val isLoading = mutableStateOf(false)
    private val user = mutableStateOf<User?>(null)
    var isRegistered: Boolean = false
    val isLoginValid = mutableStateOf(true)
    val isPasswordValid = mutableStateOf(true)
    val isRepeatPasswordValid = mutableStateOf(true)
    fun register() {
        if (
            loginInputText.value.isNotBlank() &&
            passwordInputText.value.isNotBlank() &&
            repeatPasswordInputText.value.isNotBlank()
        ) {
            if(passwordInputText.value==repeatPasswordInputText.value){
                viewModelScope.launch (Dispatchers.IO){
                    try {
                        isLoading.value = true
                        val user = User(
                            name = loginInputText.value,
                            password = passwordInputText.value
                        )
                        userApi.addUser(user)
                        isRegistered = true
                    } catch (e:HttpException){
                        //todo
                    }finally {
                        isLoading.value = false
                    }
                }
            }
            else{
                //todo
            }

        }
        else{
            isLoginValid.value = false
            isPasswordValid.value = false
            isRepeatPasswordValid.value = false
        }
    }
}