package com.tangerine.androidmold

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.tangerine.androidmold.jetpack.MyRealWorldApp
import com.tangerine.androidmold.jetpack.RealWorldLandscape
import com.tangerine.androidmold.jetpack.RealWorldPortrait
import com.tangerine.androidmold.jetpack.SimpleText

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val windowSizeClass = calculateWindowSizeClass(this)
            MyRealWorldApp(windowSizeClass)
        }
    }
}