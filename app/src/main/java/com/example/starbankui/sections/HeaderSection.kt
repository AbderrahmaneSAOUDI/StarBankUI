package com.example.starbankui.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun HeaderSection(modifier: Modifier = Modifier) {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.padding(12.dp),
		horizontalArrangement = Arrangement.SpaceBetween,
		verticalAlignment = Alignment.CenterVertically,
	) {
		Column {
			Text(
				text = "Welcome Back",
				style = MaterialTheme.typography.titleSmall,
				color = MaterialTheme.colorScheme.onBackground,
			) // Text
			Spacer(modifier = Modifier.height(8.dp))
			Text(
				text = "$ 34.346",
				style = MaterialTheme.typography.titleLarge,
				color = MaterialTheme.colorScheme.onBackground,
				fontWeight = FontWeight(600),
			) // Text
		} // Column
		FilledIconButton(
			onClick = {

			}, // onClick
			modifier = Modifier.size(36.dp),
			shape = MaterialTheme.shapes.medium,
		) {
			Icon(
				imageVector = Icons.Rounded.Search,
				contentDescription = "Notifications",
				tint = MaterialTheme.colorScheme.inverseOnSurface,
				modifier = Modifier.padding(8.dp),
			) // Icon
		} // FilledIconButton
	} // Row
} // fun: HeaderSection