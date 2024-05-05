package com.example.sayitahminuygulamasi

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import kotlin.random.Random

class TahminEkrani: Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        val tfTahmin = remember { mutableStateOf("") }
        val rasgeleSayi = remember { mutableStateOf(0) }
        val kalanHak = remember { mutableStateOf(5) }
        val yonlendirme = remember { mutableStateOf("") }

    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        
        LaunchedEffect(key1 = true) {
            rasgeleSayi.value = Random.nextInt(101) //0 ile 100 arasında sayı üretecek
            Log.e("RasgeleSayi", rasgeleSayi.value.toString())
        }
        
        Text(text = "Kalan Hak: ${kalanHak.value}", fontSize = 36.sp, color = Color.Red)
        Text(text = "Yardım: ${yonlendirme.value}", fontSize = 36.sp)

        TextField(
            value = tfTahmin.value,
            onValueChange = {tfTahmin.value = it},
            label = { Text(text = "Tahmin")}
            )


        Button(onClick = {
            kalanHak.value -= 1
            val tahmin = tfTahmin.value.toInt()

            if (tahmin == rasgeleSayi.value){
                navigator?.push(SonucEkrani(sonuc = true))
                return@Button
            }

            if (tahmin > rasgeleSayi.value){
                yonlendirme.value = "Azalt"
            }

            if (tahmin < rasgeleSayi.value){
                yonlendirme.value = "Arttır"
            }

            if (kalanHak.value == 0){
                navigator?.push(SonucEkrani(sonuc = false))
            }

            tfTahmin.value = "" //içini temizledik




        }, modifier = Modifier.size(250.dp, 50.dp)) {
            Text(text = "TAHMİN ET")

        }

    }
    }
}

