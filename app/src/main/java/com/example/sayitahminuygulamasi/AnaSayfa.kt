package com.example.sayitahminuygulamasi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.sayitahminuygulamasi.ui.theme.SayiTahminUygulamasiTheme



class AnaSayfa: Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        Column (modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Tahmin Oyunu", fontSize = 36.sp, color = Color.DarkGray)
            Image(painter = painterResource(id = R.drawable.zar_resim),
                contentDescription = "")
            Button(onClick = {
                navigator?.push(TahminEkrani())
            }, modifier = Modifier.size(250.dp, 50.dp)) {
                Text(text = "OYUNA BAŞLA")

            }

        }

    }
}

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        SayiTahminUygulamasiTheme {
            AnaSayfa().Content()
        }
    }