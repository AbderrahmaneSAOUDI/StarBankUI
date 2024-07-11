package com.example.starbankui.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.starbankui.data.FinanceCard
import com.example.starbankui.ui.theme.BlueStart
import com.example.starbankui.ui.theme.GreenStart
import com.example.starbankui.ui.theme.PurpleStart

val financeList = listOf(
	FinanceCard(
		image = Icons.Rounded.StarHalf,
		name = "My\nBusiness",
		background = PurpleStart,
	), // My Business FinanceCardItem
	FinanceCard(
		image = Icons.Rounded.Wallet,
		name = "My\nWallet",
		background = BlueStart,
	), // My Business FinanceCardItem
	FinanceCard(
		image = Icons.Rounded.StarHalf,
		name = "Finance\nAnalytics",
		background = PurpleStart,
	), // Finance Analytics FinanceCardItem
	FinanceCard(
		image = Icons.Rounded.MonetizationOn,
		name = "My\nTransactions",
		background = GreenStart,
	), // My Transactions FinanceCardItem
) // list of : financeList

@Preview(showBackground = true)
@Composable
fun FinanceSection(modifier: Modifier = Modifier) {
	Column {
		Text(
			text = "Finance",
			style = MaterialTheme.typography.titleLarge,
			color = MaterialTheme.colorScheme.onBackground,
			fontWeight = FontWeight(600),
			modifier = Modifier.padding(start = 12.dp, bottom = 8.dp)
		) // Text

		LazyRow(
			modifier = modifier.fillMaxWidth(),
			horizontalArrangement = Arrangement.spacedBy(16.dp),
		) {
			items(financeList.size) { index ->
				createFinanceCard(index)
			} // items
		} // LazyRow
	} // Column
} // fun: FinanceSection

@Composable
fun createFinanceCard(index: Int/*, card: Card*/) {
	val financeItem = financeList[index]
	val lastPadding = if (index == cardsList.size - 1) 12.dp else 0.dp
	val firstPadding = if (index == 0) 12.dp else 0.dp
	Box(
		modifier = Modifier.padding(start = firstPadding, end = lastPadding)
	) {
		Column(
			modifier = Modifier
				.clip(RoundedCornerShape(20.dp))
				.background(MaterialTheme.colorScheme.secondaryContainer)
				.width(120.dp)
				.clickable { }
				.padding(10.dp),
		) {
			Icon(
				imageVector = financeItem.image,
				contentDescription = financeItem.name,
				tint = MaterialTheme.colorScheme.inverseOnSurface,
				modifier = Modifier
					.clip(RoundedCornerShape(12.dp))
					.background(financeItem.background)
					.padding(horizontal = 8.dp, vertical = 6.dp)
					.width(32.dp),
			) // Icon

			Spacer(modifier = Modifier.height(8.dp))

			Text(
				text = financeItem.name,
				style = MaterialTheme.typography.titleMedium,
			) // Text
		} // Column
	} // Box
} // fun: createFinanceCard