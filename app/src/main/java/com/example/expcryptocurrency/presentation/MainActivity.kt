package com.example.expcryptocurrency.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.example.expcryptocurrency.presentation.ui.theme.ExpCryptoCurrencyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpCryptoCurrencyTheme {
                Surface(color = MaterialTheme.colors.background) {
                }
            }
        }
    }
}