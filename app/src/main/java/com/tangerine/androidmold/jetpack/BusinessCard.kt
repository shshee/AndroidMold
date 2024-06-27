package com.tangerine.androidmold.jetpack

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tangerine.androidmold.R

@Composable
fun InfoView(icon: ImageVector, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(imageVector = icon, contentDescription = null, tint = colorResource(R.color.mGreen))
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = text)
    }
}

@Composable
fun BusinessInfos(modifier: Modifier = Modifier) {
    Column(modifier = modifier, verticalArrangement = Arrangement.Bottom) {
        InfoView(icon = Icons.Rounded.Phone, text = "+84933598796")
        InfoView(icon = Icons.Rounded.Share, text = "@winter.tangerine")
        InfoView(icon = Icons.Rounded.Email, text = "iamcrazyinmaking@gmail.com")
    }
}

@Composable
fun BusinessImages(modifier: Modifier = Modifier) {
    Column(modifier = modifier,horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Image(painter = painterResource(id = R.drawable.android_logo), contentDescription = null, modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .background(Color(0xFF083746)))
        Text(text = "Duong Nguyen", fontSize = 30.sp, modifier = Modifier.padding(0.dp, 6.dp, 0.dp,6.dp))
        Text(text = "Jobless Android Developer", color = colorResource(R.color.mGreen), fontWeight = FontWeight.Bold)
    }
}

@Composable
fun BusinessCard() {
    Column(modifier = Modifier.fillMaxSize().background(Color(0xFFd2e8d4)), horizontalAlignment = Alignment.CenterHorizontally) {
        BusinessImages(modifier = Modifier.weight(0.8f))
        BusinessInfos(modifier = Modifier.weight(0.2f).padding(30.dp))
    }
}

@Preview(showSystemUi = true)
@Composable
fun InfoViewPreview() {
    BusinessCard()
}