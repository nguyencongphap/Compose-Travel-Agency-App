package com.example.travelagency.createTrip.ui.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.travelagency.createTrip.ui.dashboard.components.StatsCard
import com.example.travelagency.createTrip.ui.dashboard.components.TagChip
import com.example.travelagency.createTrip.ui.dashboard.components.TripCard
import com.example.travelagency.ui.theme.DarkGreen



@Composable
fun DashboardScreenRoot(
//    viewModel: DashboardViewModel, // TODO: DashboardViewModel = koinViewModel()
    modifier: Modifier = Modifier
) {

    DashboardScreen()
}

@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = "Welcome",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(16.dp))
                Text(text = "Track activity, trends, and popular destinations in real time",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.alpha(0.8f))
            }
        }
        Spacer(Modifier.height(32.dp))

        // TODO: Data struct for stat cards
        /**
         * const dashboardStats = {
         *      totalUsers: 12450,
         *      usersJoined: { currentMonth: 218, lastMonth: 176 },
         *      totalTrips: 3210,
         *      tripsCreated: { currentMonth: 150, lastMonth: 250 },
         *      userRole: { total: 62, currentMonth: 25, lastMonth: 15 }
         */

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            StatsCard(
                title = "Total Users",
                count = 12490,
                percentage = 12,
                isIncrement = true,
            )
            Spacer(Modifier.height(STATS_CARD_SPACE))
            StatsCard(
                title = "Total Trips",
                count = 3210,
                percentage = 2,
                isIncrement = false,
            )
            Spacer(Modifier.height(STATS_CARD_SPACE))
            StatsCard(
                title = "Active Users Today",
                count = 520,
                percentage = 2,
                isIncrement = true,
            )
        }

        // TODO: Data struct for trip card
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
        Spacer(Modifier.height(56.dp))
        Text(
            text = "Created Trips",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(16.dp))
        Column( // TODO: use Flow row
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            TripCard(
                name = "Thornridge Cir. Shiloh",
                location = "St George's Ln, Singapore",
                tags = listOf("Adventure", "Culture"),
                estimatedPrice = 300,
                modifier = Modifier
            )
            TripCard(
                name = "Sunny Beach Escape",
                location = "Bondi Beach, Australia",
                tags = listOf("Relaxation", "Beach"),
                estimatedPrice = 450,
                modifier = Modifier
            )
        }

    }
}

private val STATS_CARD_SPACE = 16.dp

@Preview(showBackground = true)
@Composable
fun Preview() {
    DashboardScreen(
        modifier = Modifier,
    )
}