package com.example.travelagency.createTrip.ui.dashboard.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.travelagency.R
import com.example.travelagency.ui.theme.DarkGreen
import com.example.travelagency.ui.theme.LightGreen

/**
 * trip = {
 *          id: 1,
 *          name: "Trip 1",
 *          imageUrls: ["/assets/images/sample.jpeg"],
 *          itinerary: [{ location: "New York" }],
 *          tags: ["Adventure", "Culture"],
 *          travelStyle: "Solo",
 *          estimatedPrice: "$1,000"
 *          }
 */

@Composable
fun TripCard(
    name: String,
    estimatedPrice: Int,
    location: String,
    tags: List<String>,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Image(
                painter = painterResource(id = R.drawable.sample),
                contentDescription = "trip location image",
                contentScale = ContentScale.Crop, // Important: fills and crops nicely
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))
            Column(
                Modifier.padding(16.dp)
            ) {
                Text(
                    text = "$name",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(12.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.location_mark),
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = "$location",
                        modifier = Modifier.alpha(0.8f),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                Spacer(Modifier.height(20.dp))
                LazyRow (
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(tags) { it ->
                        TagChip(
                            backgroundColor = LightGreen
                        ) { Text(
                            text = it,
                            color = DarkGreen
                        ) }
                    }
                }
            }
        }

        TagChip(
            backgroundColor = Color.White,
            modifier = Modifier
            .align(Alignment.TopEnd)
            .padding(top = 16.dp, end = 16.dp)
        ) {
            Text(text = "$${estimatedPrice}")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewTripCard() {
    TripCard(
        name = "Thronridge Cir.Shiloh",
        location = "St George's Ln Singapore",
        tags = listOf("Adventure", "Culture"),
        estimatedPrice = 300,
        modifier = Modifier
    )
}