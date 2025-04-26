package com.example.travelagency.core.ui

import java.text.NumberFormat
import java.util.Locale

fun formatNumberWithCommas(number: Number, locale: Locale = Locale.US): String {
    return NumberFormat.getNumberInstance(locale).format(number)
}