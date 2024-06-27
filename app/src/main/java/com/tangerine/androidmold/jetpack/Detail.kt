package com.tangerine.androidmold.jetpack

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tangerine.androidmold.R

@Composable
fun DetailView() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.bg_compose_background),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Jetpack Compose tutorial",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = stringResource(R.string.compose_introduction),
            modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = stringResource(R.string.compose_details),
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun TaskCompletedView() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_task_completed),
            contentDescription = null
        )
        Text(
            text = "All tasks completed",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(0.dp, 24.dp, 0.dp, 8.dp)
        )
        Text(text = "Nice work!", fontSize = 16.sp)
    }
}

@Composable
fun QuadrantView() {
    Column {
        Row(modifier = Modifier.weight(1f)) {
            SingleView(
                title = "Text composable",
                message = "Displays text and follows the recommended Material Design guidelines.",
                modifier = Modifier
                    .weight(1f)
                    .background(
                        Color(0xFFEADDFF)
                    )
            )
            SingleView(
                title = "Image composable",
                message = "Creates a composable that lays out and draws a given Painter class object.",
                modifier = Modifier
                    .weight(1f)
                    .background(
                        Color(0xFFD0BCFF)
                    )
            )
        }

        Row(modifier = Modifier.weight(1f)) {
            SingleView(
                title = "Row composable",
                message = "A layout composable that places its children in a horizontal sequence.",
                modifier = Modifier
                    .weight(1f)
                    .background(
                        Color(0xFFB69DF8)
                    )
            )
            SingleView(
                title = "Column composable",
                message = "A layout composable that places its children in a vertical sequence.",
                modifier = Modifier
                    .weight(1f)
                    .background(
                        Color(0xFFF6EDFF)
                    )
            )
        }
    }
}

@Composable
fun SingleView(title: String, message: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(16.dp).fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = title, modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 16.dp), fontWeight = FontWeight.Bold)
        Text(text = message, textAlign = TextAlign.Justify)
    }
}

@Preview(showSystemUi = true)
@Composable
fun DetailViewPreview() {
    QuadrantView()
}