package com.example.travelagency

import kotlinx.serialization.Serializable

// A screen that has screen arguments must be a data class

sealed interface Route {

    // bundle each feature into a navigation graph
    @Serializable
    data object CreateTripGraph: Route
    @Serializable
    data object DashboardScreen: Route
    @Serializable
    data object AllUsersScreen: Route
}