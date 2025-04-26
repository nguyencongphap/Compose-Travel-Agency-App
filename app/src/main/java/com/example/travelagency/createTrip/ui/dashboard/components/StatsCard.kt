package com.example.travelagency.createTrip.ui.dashboard.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.travelagency.R
import com.example.travelagency.core.ui.ErrorRed
import com.example.travelagency.core.ui.formatNumberWithCommas
import com.example.travelagency.core.ui.ValidGreen

@Composable
fun StatsCard(
    count: Int,
    percentage: Int,
    isIncrement: Boolean,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = "Total Users", style = MaterialTheme.typography.bodyMedium)
            Spacer(Modifier.height(24.dp))

            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = formatNumberWithCommas(count), style = MaterialTheme.typography.displaySmall)
                    Spacer(Modifier.height(16.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(if (isIncrement) R.drawable.arrow_up_green else R.drawable.arrow_down_red),
                            contentDescription = "",
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier.width(2.dp))
                        Text(
                            text = "$percentage%",
                            style = MaterialTheme.typography.bodySmall,
                            color = if (isIncrement) ValidGreen else ErrorRed
                        )
                        Spacer(modifier.width(4.dp))
                        Text(
                            text = "vs last month",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.alpha(0.5f)
                        )
                    }
                }
                Spacer(Modifier.width(20.dp))
                Image(
                    painter = painterResource(if (isIncrement) R.drawable.increment else R.drawable.decrement),
                    contentDescription = "increment graph icon",
                    modifier = Modifier
                        .width(130.dp),
                    contentScale = ContentScale.FillWidth
                )
            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    StatsCard(
        modifier = Modifier,
        count = 12490,
        percentage = 12,
        isIncrement = false
    )
}