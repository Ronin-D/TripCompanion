package com.example.tripcompanion.ui.trip_catalog

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tripcompanion.R
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tripcompanion.models.Trip
import com.example.tripcompanion.ui.theme.DarkBlue
import com.example.tripcompanion.ui.theme.LightBlue

@Composable
fun TripCatalogScreen(
    viewModel: TripCatalogViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = null){
        viewModel.loadTrips()
    }
    val trips = viewModel.trips.collectAsState()
    TripsBar(trips = trips.value)

}

@Composable
fun TripsBar(
    trips:List<Trip>
){
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally){
        items(trips){ trip->
            Spacer(modifier = Modifier.size(16.dp))
            TripItem(trip)
        }
    }
}

@Composable
fun TripItem(trip: Trip) {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .clip(shape = RoundedCornerShape(16.dp))
    ) {
        Column(
            modifier = Modifier
                .background(LightBlue)
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = trip.name)
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_people_alt_24),
                    contentDescription = "people count image",
                    modifier = Modifier
                )
                Text(
                    text = "${trip.peopleCount}/${trip.availableCount}",
                    color = Color.White
                )
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(50.dp)),
                    colors = ButtonDefaults.buttonColors(DarkBlue),
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        text = "Join",
                        color = Color.White
                    )
                }

            }
        }

    }
}
