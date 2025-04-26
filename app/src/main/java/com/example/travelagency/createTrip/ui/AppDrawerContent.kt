package com.example.travelagency.createTrip.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.travelagency.Route
import com.example.travelagency.R

@Composable
fun AppDrawerContent(
    navigateTo: (Route) -> Unit,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(12.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo icon",
                modifier = Modifier.size(48.dp)
            )
            Spacer(Modifier.height(12.dp))
            Text("Drawer Title", modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.titleLarge)
        }

        Spacer(Modifier.height(24.dp))
        HorizontalDivider()
        Spacer(Modifier.height(24.dp))

        NavigationDrawerItem(
            label = { Text("Item 1") },
            selected = false,
            onClick = {
                navigateTo(Route.AllUsersScreen)
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "home icon",
                    modifier = Modifier.size(16.dp)
                )
            }
        )
        NavigationDrawerItem(
            label = { Text("Item 2") },
            selected = false,
            onClick = {
                navigateTo(Route.DashboardScreen)
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.users),
                    contentDescription = "users icon",
                    modifier = Modifier.size(16.dp)
                )
            }
        )
        NavigationDrawerItem(
            label = { Text("Item 2") },
            selected = false,
            onClick = {
                navigateTo(Route.AiTripsScreen)
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.itinerary_button),
                    contentDescription = "users icon",
                    modifier = Modifier.size(16.dp)
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    AppDrawerContent(
        navigateTo = {},
        modifier = Modifier
    )
}