package com.hfad.energon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.hackaton.features.create_act.ui.CreateActScreen
import com.hfad.energon.ui.theme.EnergONTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EnergONTheme {
                var showDialog by remember { mutableStateOf(false) }

// Кнопка для показа диалога
                Button(onClick = { showDialog = true }) {
                    Text("Выбрать тип акта")
                }

// Показ диалога
                if (showDialog) {
                    ActTypeDialog(
                        onDismissRequest = { showDialog = false },
                        onControlSelected = {
                            showDialog = false

                        },
                        onMobileSmartwaySelected = {
                            showDialog = false

                        }
                    )
                }
            }
        }
    }
}