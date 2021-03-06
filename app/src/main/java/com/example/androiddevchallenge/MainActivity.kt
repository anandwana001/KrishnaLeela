/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bumptech.glide.request.RequestOptions
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.glide.GlideImage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

data class KrishnaLifeEvent(
    val title: String,
    val image: String
)

@Composable
fun AppTab(title: String = "श्रीकृष्ण") {
    Row(
        Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.primaryVariant)
    ) {
        Text(
            text = title,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp, 16.dp, 8.dp, 8.dp))
    }
}

@Composable
fun KrishnaCard(modifier: Modifier = Modifier, events: List<KrishnaLifeEvent>) {
    LazyColumn {
        items(events) { data ->
            Card(
                shape = RoundedCornerShape(4.dp),
                border = BorderStroke(1.dp, Color.Black),
                modifier = modifier.padding(start = 8.dp, top = 8.dp, bottom = 8.dp, end = 8.dp)
                    .clickable {

                    }
            ) {
                Column {
                    Image(imageUrl = data.image)
                    Title(event = data.title)
                }
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.background) {
        Column {
            AppTab()
            Spacer(modifier = Modifier.padding(top = 8.dp))
            KrishnaCard(events = getEvents())
        }
    }
}

@Composable
fun Title(event: String) {
    Text(text = event, modifier = Modifier.padding(8.dp, 4.dp, 8.dp, 4.dp))
}

@Composable
fun Image(imageUrl: String) {
    GlideImage(
        data = imageUrl,
        contentDescription = "krishna image",
        modifier = Modifier
            .height(120.dp)
            .fillMaxWidth(),
        requestBuilder = {
            val options = RequestOptions()
            options.centerCrop()
            apply(options)
        },
    )
}

fun getEvents() : List<KrishnaLifeEvent> {
    return listOf(
        KrishnaLifeEvent("१. भगवान् श्रीकृष्ण का अवतरण", "https://i.pinimg.com/564x/e4/04/bd/e404bd5d11e7c4278f978b98e1388c61.jpg"),
        KrishnaLifeEvent("२. देवताओं द्वारा गर्भस्थ भगवान् कृष्ण की स्तुति", "https://i.pinimg.com/564x/e4/04/bd/e404bd5d11e7c4278f978b98e1388c61.jpg"),
        KrishnaLifeEvent("३. भगवान् कृष्ण का जन्म", "https://i.pinimg.com/564x/e4/04/bd/e404bd5d11e7c4278f978b98e1388c61.jpg"),
        KrishnaLifeEvent("४. कंस द्वारा उत्पीड़न का प्रारम्भ", "https://i.pinimg.com/564x/e4/04/bd/e404bd5d11e7c4278f978b98e1388c61.jpg"),
        KrishnaLifeEvent("५. नन्द तथा वसुदेव की भेंट", "https://i.pinimg.com/564x/e4/04/bd/e404bd5d11e7c4278f978b98e1388c61.jpg"),
        KrishnaLifeEvent("१. भगवान् श्रीकृष्ण का अवतरण", "https://i.pinimg.com/564x/e4/04/bd/e404bd5d11e7c4278f978b98e1388c61.jpg"),
        KrishnaLifeEvent("२. देवताओं द्वारा गर्भस्थ भगवान् कृष्ण की स्तुति", "https://i.pinimg.com/564x/e4/04/bd/e404bd5d11e7c4278f978b98e1388c61.jpg"),
        KrishnaLifeEvent("३. भगवान् कृष्ण का जन्म", "https://i.pinimg.com/564x/e4/04/bd/e404bd5d11e7c4278f978b98e1388c61.jpg"),
        KrishnaLifeEvent("४. कंस द्वारा उत्पीड़न का प्रारम्भ", "https://i.pinimg.com/564x/e4/04/bd/e404bd5d11e7c4278f978b98e1388c61.jpg"),
        KrishnaLifeEvent("५. नन्द तथा वसुदेव की भेंट", "https://i.pinimg.com/564x/e4/04/bd/e404bd5d11e7c4278f978b98e1388c61.jpg"),
        KrishnaLifeEvent("१. भगवान् श्रीकृष्ण का अवतरण", "https://i.pinimg.com/564x/e4/04/bd/e404bd5d11e7c4278f978b98e1388c61.jpg"),
        KrishnaLifeEvent("२. देवताओं द्वारा गर्भस्थ भगवान् कृष्ण की स्तुति", "https://i.pinimg.com/564x/e4/04/bd/e404bd5d11e7c4278f978b98e1388c61.jpg"),
        KrishnaLifeEvent("३. भगवान् कृष्ण का जन्म", "https://i.pinimg.com/564x/e4/04/bd/e404bd5d11e7c4278f978b98e1388c61.jpg"),
        KrishnaLifeEvent("४. कंस द्वारा उत्पीड़न का प्रारम्भ", "https://i.pinimg.com/564x/e4/04/bd/e404bd5d11e7c4278f978b98e1388c61.jpg"),
        KrishnaLifeEvent("५. नन्द तथा वसुदेव की भेंट", "https://i.pinimg.com/564x/e4/04/bd/e404bd5d11e7c4278f978b98e1388c61.jpg")
    )
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
