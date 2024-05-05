package com.example.sayitahminuygulamasi

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator

class SonucEkrani(
    private val sonuc : Boolean
) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (sonuc){
            Text(text = "KAZANDINIZ", fontSize = 36.sp, color = Color.Magenta)
            Image(painter = painterResource(id = R.drawable.mutlu_resim),
                contentDescription = "")

        }else{
            Text(text = "KAYBETTİNİZ", fontSize = 36.sp, color = Color.Magenta)
            Image(painter = painterResource(id = R.drawable.mutsuz_resim),
                contentDescription = "")

        }
        Button(onClick = {
            navigator?.popUntilRoot()
        }) {

        }


    }
    }
}
