package com.example.starbankui.data

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class FinanceCard(
	val image: ImageVector,
	val name: String,
	val background: Color,
) // data class: FinanceCardItem