package com.tangerine.androidmold.jetpack

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tangerine.androidmold.R

// This is a Composable function. To write any Composable function, you need to use @Composable annotation
@Composable
fun SimpleText(displayText: String, inputModifier: Modifier = Modifier) {
    // Text composable is used to display some text
    Text(text = displayText, modifier = inputModifier)
}

@Composable
fun SurfaceText(text1: String, text2: String, modifier: Modifier) {
    Column(
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(text = text1, fontSize = 25.sp)
        Surface(modifier = Modifier.fillMaxWidth()) {
            Text(text2, fontSize = 30.sp, lineHeight = 35.sp, textAlign = TextAlign.Center)
        }
    }
}

@Composable
fun SurfaceImage(text1: String, text2: String, modifier: Modifier) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.androidparty),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        SurfaceText(text1 = text1, text2 = text2, modifier = Modifier.fillMaxSize())
    }
}

// Android Studio provides an awesome feature of previewing your Compose UI elements while writing the code.
// To do so, you need to use @Preview annotation and then write a Composable function and call your UI element.
// The UI will be refreshed on every build or you can refresh manually from the UI preview tab.
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SimpleTextPreview() {
    MaterialTheme {
        SurfaceText(
            "Heyy man", stringResource(R.string.hi_i_am_learning), modifier = Modifier
                .padding(8.dp)
                .background(Color.Gray)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SimpleTextDarkPreview() {
    MaterialTheme {
        SurfaceImage(
            "Heyy man", "Hi I am learning", modifier = Modifier
                .padding(8.dp)
                .background(Color.Green)
        )
    }
}