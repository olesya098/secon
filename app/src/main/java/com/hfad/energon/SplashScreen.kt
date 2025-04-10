package com.hfad.energon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.hfad.energon.ui.theme.greenDark
import com.hfad.energon.ui.theme.greenlite
import com.hfad.energon.ui.theme.greenmedium
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val context = LocalContext.current
    val fredo = FontFamily(Font(R.font.fredokabold))
    val gradient = Brush.verticalGradient(
        colors = listOf(
          Color(70,230,106),
            Color(67,226,107),
            Color(61,224,109),
            Color(56,219,112),
            Color(39,206,114),
            Color(34,202,114),
            Color(30,199,116),
            Color(24,195,116),
            Color(15,189,118),
            Color(10,185,120),
            Color(2,180,120)

            )
    )
    LaunchedEffect(Unit) {
        delay(3000L)
        navController.navigate(Screen.SignInScreen.route)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.energon2),
                contentDescription = null,
                modifier = Modifier.size(160.dp)
            )


        }

    }
}
@PreviewScreenSizes
@Composable
fun PreviewSplashScreen() {
    SplashScreen(rememberNavController())

}