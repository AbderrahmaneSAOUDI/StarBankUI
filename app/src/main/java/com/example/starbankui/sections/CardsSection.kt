package com.example.starbankui.sections

import androidx.compose.foundation.Image
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.starbankui.R
import com.example.starbankui.data.Card
import com.example.starbankui.ui.theme.BlueEnd
import com.example.starbankui.ui.theme.BlueStart
import com.example.starbankui.ui.theme.GreenEnd
import com.example.starbankui.ui.theme.GreenStart
import com.example.starbankui.ui.theme.OrangeEnd
import com.example.starbankui.ui.theme.OrangeStart
import com.example.starbankui.ui.theme.PurpleEnd
import com.example.starbankui.ui.theme.PurpleStart

val cardsList = listOf(
	Card(
		type = "VISA",
		name = "Business",
		number = "**** **** **** 1234",
		balance = 34.346,
		color = getGradient(PurpleStart, PurpleEnd)
	), // Business CardItem

	Card(
		type = "MASTERCARD",
		name = "Invests",
		number = "**** **** **** 5678",
		balance = 15.279,
		color = getGradient(OrangeStart, OrangeEnd)
	), // Invests CardItem

	Card(
		type = "MASTERCARD",
		name = "Savings",
		number = "**** **** **** 1925",
		balance = 82.943,
		color = getGradient(BlueStart, BlueEnd)
	), // Savings CardItem

	Card(
		type = "VISA",
		name = "Education",
		number = "**** **** **** 8402",
		balance = 108.93,
		color = getGradient(GreenStart, GreenEnd)
	) // Education CardItem
) // list of : cardsList

@Preview(showBackground = true)
@Composable
fun CardsSection(modifier: Modifier = Modifier) {
	LazyRow(
		modifier = modifier.fillMaxWidth(),
		horizontalArrangement = Arrangement.spacedBy(16.dp),
//		contentPadding = PaddingValues(horizontal = 16.dp)
	) {
		items(cardsList.size) { index ->
			CardItem(index)
		} // items
	} // LazyRow
} // fun: CardsSection

@Composable
fun CardItem(index: Int/*, card: Card*/) {
	val card = cardsList[index]
	val lastPadding = if (index == cardsList.size - 1) 12.dp else 0.dp
	val firstPadding = if (index == 0) 12.dp else 0.dp
	val image =
		painterResource(id = if (card.type == "VISA") R.drawable.visa else R.drawable.mastercard)
	Box(
		modifier = Modifier.padding(start = firstPadding, end = lastPadding)
	) {
		Column(modifier = Modifier
			.clip(RoundedCornerShape(20.dp))
			.background(card.color)
			.width(250.dp)
			.height(160.dp)
			.clickable { }
			.padding(vertical = 12.dp, horizontal = 16.dp),
			verticalArrangement = Arrangement.SpaceBetween
		) {
			Image(
				painter = image,
				contentDescription = card.name,
				modifier = Modifier.width(64.dp)
			) // Image
			Spacer(modifier = Modifier.height(24.dp))
			Text(
				text = card.name,
				color = Color.White,
				style = MaterialTheme.typography.titleMedium,
				fontWeight = FontWeight.Normal
			) // cardName Text
			Text(
				text = "$ ${card.balance}",
				color = Color.White,
				style = MaterialTheme.typography.titleLarge,
				fontWeight = FontWeight.Bold
			) // cardBalance Text
			Text(
				text = card.number,
				color = Color.White,
				style = MaterialTheme.typography.titleMedium,
				fontWeight = FontWeight.Normal
			) // cardNumber Text
		} // Column
	} // Box
} // fun: CardItem

fun getGradient(
	startColor: Color, endColor: Color
): Brush {
	return Brush.horizontalGradient(colors = listOf(startColor, endColor))
} // fun: getGradient