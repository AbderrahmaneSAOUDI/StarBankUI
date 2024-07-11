package com.example.starbankui.data

import androidx.compose.ui.graphics.Brush

data class Card(
	val type: String,
	val name: String,
	val balance: Double,
	val number: String,
	val color: Brush,
) // data class: CardItem
