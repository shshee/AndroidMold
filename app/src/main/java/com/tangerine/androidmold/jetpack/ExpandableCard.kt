package com.tangerine.androidmold.jetpack

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tangerine.androidmold.AppTheme

@Composable
fun ExpandableCard(onToggleBoarding: (Boolean) -> Unit, list: List<String>) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(4.dp)
        ) {
            items(items = list) {
                ItemCard(name = it)
            }
        }

        Button(modifier = Modifier.padding(bottom = 16.dp), onClick = { onToggleBoarding(true) }) {
            Text(text = "Return")
        }
    }

}

@Composable
fun ItemCard(name: String, modifier: Modifier = Modifier) {
    val shouldExpand = rememberSaveable { mutableStateOf(false) }
    val extraPadding by animateDpAsState(
        targetValue = if (shouldExpand.value) 100.dp else 0.dp,
        label = "",
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioHighBouncy,
            stiffness = Spring.StiffnessLow
        )
    )
    val extraColor by animateColorAsState(
        targetValue = if (!shouldExpand.value) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary,
        label = "",
        animationSpec = tween(durationMillis = 2000)
    )

    Card(
        colors = CardDefaults.cardColors(
            containerColor = extraColor
        ),
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(24.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                //.padding(bottom = extraPadding.coerceAtLeast(0.dp))
            ) {
                Text(
                    text = name, style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )

                if (shouldExpand.value) {
                    Text(
                        text = ("Composem ipsum color sit lazy, " +
                                "padding theme elit, sed do bouncy. ").repeat(4),
                    )
                }
            }

            ElevatedButton(onClick = { shouldExpand.value = !shouldExpand.value }) {
                Text(text = if (shouldExpand.value) "Show less" else "Show more")
            }
        }
    }
}

@Composable
fun OnboardingScreen(onToggleBoarding: (Boolean) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Basics Codelab!")
        Button(modifier = Modifier.padding(24.dp), onClick = { onToggleBoarding(false) }) {
            Text(text = "Continue")
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    var shouldOnBoarding by rememberSaveable { mutableStateOf(true) }
    fun callback(toggle: Boolean) {
        shouldOnBoarding = toggle
    }

    Surface(modifier = modifier) {
        if (shouldOnBoarding) OnboardingScreen(onToggleBoarding = { callback(it) })
        else ExpandableCard(
            onToggleBoarding = { callback(it) },
            list = List(10) { "$it" }
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DarkMyAppPreview() {
    AppTheme {
        MyApp(Modifier.fillMaxSize())
    }

}

//@Preview
//@Composable
//fun MyAppPreview() {
//    MaterialTheme {
//        MyApp(Modifier.fillMaxSize())
//    }
//}