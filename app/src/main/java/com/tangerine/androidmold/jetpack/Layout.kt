package com.tangerine.androidmold.jetpack

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tangerine.androidmold.R

enum class Type { COLUMN, ROW, BOX }

@Composable
fun Layout(type: Type) {
    when (type) {
        Type.COLUMN -> MColumn()
        Type.ROW -> MRow()
        Type.BOX -> MBox()
    }
}

@Composable
fun MColumn() {
    Column {
        Text("Alfred Sisley")
        Text("3 minutes ago")
    }
}

@Composable
fun MRow() {
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End) {
        Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = "test")
        MColumn()
    }
}

@Composable
fun MBox() {
    Box(modifier = Modifier.padding(4.dp)) {
        Image(painter = painterResource(id = R.drawable.winter), contentDescription = "test")
        Icon(imageVector = Icons.Filled.Check, contentDescription = "test")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LayoutPreview() {
    //Layout(type = Type.ROW)
    CardExample()
}


@Composable
fun CardExample() {
    Column(modifier = Modifier.padding(5.dp)) {
        Row(
            modifier = Modifier.padding(0.dp, 5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ava),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(24.dp)
                    .clip(
                        CircleShape
                    )
            )
            Spacer(modifier = Modifier.padding(3.dp, 0.dp))
            MColumn()
        }

        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            shape = CardDefaults.elevatedShape
        ) {
            Image(
                painter = painterResource(id = R.drawable.winter), contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(200.dp)
            )
        }
    }
}