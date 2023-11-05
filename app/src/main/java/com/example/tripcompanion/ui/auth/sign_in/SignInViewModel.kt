package com.example.tripcompanion.ui.auth.sign_in

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tripcompanion.data.api.UserApi
import com.example.tripcompanion.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val userApi: UserApi
) : ViewModel() {
    val loginInputText = mutableStateOf("")
    val passwordInputText = mutableStateOf("")
    val isLoading = mutableStateOf(false)
    private val user = mutableStateOf<User?>(null)
    var isFound:Boolean? = null
    val isLoginValid = mutableStateOf(true)
    val isPasswordValid = mutableStateOf(true)


    fun logIn() {
        if (loginInputText.value.isNotEmpty() && passwordInputText.value.isNotEmpty()) {
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    isLoading.value = true
                    userApi.logIn().let { users->//mock
                        users.forEach(){
                            if (it.value.password==passwordInputText.value&&
                                it.value.name==loginInputText.value){
                                user.value= it.value
                            }
                        }
                    }
                    isFound = user.value!=null
                } catch (e: HttpException) {
                    //todo
                } finally {
                    isLoading.value = false
                }

            }
        } else {
            isLoginValid.value = false
            isPasswordValid.value = false
        }
    }

}