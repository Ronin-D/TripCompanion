package com.example.tripcompanion.ui.trip_catalog

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tripcompanion.data.api.TripApi
import com.example.tripcompanion.models.Trip
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TripCatalogViewModel @Inject constructor(
    private val tripApi: TripApi
):ViewModel() {

    private val _trips = MutableStateFlow<List<Trip>>(emptyList())
    val trips = _trips.asStateFlow()

    fun loadTrips(){
        viewModelScope.launch(Dispatchers.IO) {
            _trips.emit(tripApi.fetchTrips())
        }
    }

}