package com.example.starbankui.sections

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.CurrencyPound
import androidx.compose.material.icons.rounded.CurrencyRuble
import androidx.compose.material.icons.rounded.CurrencyRupee
import androidx.compose.material.icons.rounded.CurrencyYen
import androidx.compose.material.icons.rounded.Euro
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.starbankui.data.Currency
import com.example.starbankui.ui.theme.GreenStart

val currenciesList = listOf(
	Currency(icon = Icons.Rounded.AttachMoney, name = "USD", buy = 12.0f, sell = 14.2f),
	Currency(icon = Icons.Rounded.Euro, name = "EUR", buy = 8.9f, sell = 11.1f),
	Currency(icon = Icons.Rounded.CurrencyYen, name = "YEN", buy = 10.8f, sell = 17.0f),
	Currency(icon = Icons.Rounded.CurrencyPound, name = "GBP", buy = 35.1f, sell = 42.3f),
	Currency(icon = Icons.Rounded.CurrencyRuble, name = "RUB", buy = 95.2f, sell = 102.4f),
	Currency(icon = Icons.Rounded.CurrencyRupee, name = "INR", buy = 50.8f, sell = 57.0f),
)

@Preview
@Composable
fun CurrenciesSection(modifier: Modifier = Modifier) {
	var isVisible by remember { mutableStateOf(false) }
	var iconState by remember { mutableStateOf(Icons.Rounded.KeyboardArrowUp) }
	Box(
		modifier = Modifier
			.fillMaxSize(),
		contentAlignment = Alignment.BottomCenter
	) {
		Column(
			modifier = Modifier
				.clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
				.background(MaterialTheme.colorScheme.inverseOnSurface)
				.animateContentSize()
		) {
			Row(
				modifier = Modifier
					.padding(12.dp)
					.fillMaxWidth()
					.animateContentSize(),
				verticalAlignment = Alignment.CenterVertically
			) {
				Icon(
					imageVector = iconState,
					contentDescription = "Money",
					modifier = Modifier
						.padding(end = 8.dp)
						.clip(CircleShape)
						.background(MaterialTheme.colorScheme.secondary)
						.clickable {
							isVisible = !isVisible
							iconState = if (isVisible) Icons.Rounded.KeyboardArrowDown
							else Icons.Rounded.KeyboardArrowUp
						}, // clickable
					tint = MaterialTheme.colorScheme.onSecondary
				) // Icon
				Text(
					text = "Currencies",
					style = MaterialTheme.typography.titleLarge,
					color = MaterialTheme.colorScheme.onSurface,
					modifier = Modifier.padding(start = 8.dp),
					fontWeight = FontWeight.W700,
				) // Text
			} // Row
			if (isVisible) {
				Divider(color = MaterialTheme.colorScheme.onSurface)
				BoxWithConstraints(
					modifier = Modifier
						.fillMaxWidth()
						.padding(horizontal = 12.dp)
						.padding(top = 12.dp)
						.clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
						.background(MaterialTheme.colorScheme.background)
				) {
					val width = this.maxWidth / 3
					Column(
						modifier = Modifier
							.fillMaxWidth()
							.padding(horizontal = 12.dp),
					) {
						Spacer(modifier = Modifier.height(8.dp))
						CreateCurrencyTableHeader(width)
						CreateCurrencyItem(width = width)
						Spacer(modifier = Modifier.height(8.dp))
					} // Column
				} // BoxWithConstraints
			} // if (isVisible)
		} // Column
	} // Box
} // fun: CurrenciesSection

@Composable
fun CreateCurrencyTableHeader(width: Dp) {
	Row(
		modifier = Modifier.fillMaxWidth()
	) {
		Text(
			text = "Currency",
			style = MaterialTheme.typography.titleMedium,
			color = MaterialTheme.colorScheme.onBackground,
			fontWeight = FontWeight.SemiBold,
			modifier = Modifier.width(width),
		) // Text : Currency
		Text(
			text = "Buy",
			style = MaterialTheme.typography.titleMedium,
			color = MaterialTheme.colorScheme.onBackground,
			fontWeight = FontWeight.SemiBold,
			modifier = Modifier.width(width),
			textAlign = TextAlign.End,
		) // Text : Buy
		Text(
			text = "Sell",
			style = MaterialTheme.typography.titleMedium,
			color = MaterialTheme.colorScheme.onBackground,
			fontWeight = FontWeight.SemiBold,
			modifier = Modifier.width(width),
			textAlign = TextAlign.End,
		) // Text : Sell
	} // Row
} // fun: CreateCurrencyTableHeader

@Composable
fun CreateCurrencyItem(width: Dp) {
	LazyColumn(
		modifier = Modifier.fillMaxWidth()
	) {
		items(currenciesList.size) { index ->
			val item = currenciesList[index]
			Row(
				modifier = Modifier
					.fillMaxWidth()
					.padding(top = 12.dp)
					.clickable { },
				verticalAlignment = Alignment.CenterVertically
			) {
				Row(
					modifier = Modifier.width(width),
					verticalAlignment = Alignment.CenterVertically,
				) {
					Icon(
						imageVector = item.icon,
						contentDescription = item.name,
						modifier = Modifier
							.clip(RoundedCornerShape(8.dp))
							.background(GreenStart)
							.size(20.dp)
							.padding(4.dp),
						tint = Color.White
					) // Icon
					Text(
						text = item.name,
						style = MaterialTheme.typography.titleSmall,
						color = MaterialTheme.colorScheme.onBackground,
						modifier = Modifier.padding(start = 10.dp),
					) // Text : name
				} // Row
				Text(
					text = item.buy.toString(),
					style = MaterialTheme.typography.titleSmall,
					color = MaterialTheme.colorScheme.onBackground,
					modifier = Modifier.width(width),
					textAlign = TextAlign.End,
					fontWeight = FontWeight.Normal,
				) // Text : buy
				Text(
					text = item.sell.toString(),
					style = MaterialTheme.typography.titleSmall,
					color = MaterialTheme.colorScheme.onBackground,
					modifier = Modifier.width(width),
					textAlign = TextAlign.End,
					fontWeight = FontWeight.Normal,
				) // Text : sell
			} // Row
		} // items
	} // LazyColumn
} // fun: CreateCurrencyItem