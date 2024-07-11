package com.example.starbankui.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.starbankui.data.BottomNavigationItem

val items = listOf(
	BottomNavigationItem(title = "Home", icon = Icons.Rounded.Home),
	BottomNavigationItem(title = "Home", icon = Icons.Rounded.Wallet),
	BottomNavigationItem(title = "Notifications", icon = Icons.Rounded.Notifications),
	BottomNavigationItem(title = "Profile", icon = Icons.Rounded.AccountCircle)
) // list of : items

@Preview(showBackground = true)
@Composable
fun BottomNavigationBar() {
	Row(
		modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)
	) {
		items.forEachIndexed { index, item ->
			NavigationBarItem(selected = false, onClick = {

			}, // onClick
				icon = {
					Icon(
						imageVector = item.icon,
						contentDescription = item.title,
						tint = MaterialTheme.colorScheme.onBackground
					) // Icon
				}, // icon
				label = {
					Text(
						text = item.title,
						color = MaterialTheme.colorScheme.onBackground
					) // Text
				} // label
			) // NavigationBarItem
		} // forEachIndexed
	} // Row
} // fun: BottomNavigationBar