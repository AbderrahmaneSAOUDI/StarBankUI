package com.example.starbankui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.starbankui.sections.BottomNavigationBar
import com.example.starbankui.sections.CardsSection
import com.example.starbankui.sections.CurrenciesSection
import com.example.starbankui.sections.FinanceSection
import com.example.starbankui.sections.HeaderSection
import com.example.starbankui.ui.theme.StarBankUITheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			StarBankUITheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier
						.fillMaxSize()
						.padding(0.dp),
					color = MaterialTheme.colorScheme.background,
				) {
					SetBarColor(color = MaterialTheme.colorScheme.background)
					HomeScreen()
				} // Surface
			} // StarBankUITheme
		} // fun: setContent
	} // fun: onCreate

	@Composable
	private fun SetBarColor(color: Color) {
		val systemUiController = rememberSystemUiController()
		SideEffect {
			systemUiController.setStatusBarColor(color = color)
		} // SideEffect
	} // fun: SetBarColor
} // class: MainActivity


@Preview(showBackground = true)
@Composable
fun HomeScreen() {
	Scaffold(
		bottomBar = {
			BottomNavigationBar()
		} // BottomBar
	) { paddingValues ->
		Column(
			modifier = Modifier
				.fillMaxSize()
				.padding(paddingValues),
		) {
			HeaderSection()
			Spacer(modifier = Modifier.height(16.dp))
			CardsSection()
			Spacer(modifier = Modifier.height(16.dp))
			FinanceSection()
			Spacer(modifier = Modifier.height(16.dp))
			CurrenciesSection()
		} // Column
	} // Scaffold
} // fun: HomeScreen