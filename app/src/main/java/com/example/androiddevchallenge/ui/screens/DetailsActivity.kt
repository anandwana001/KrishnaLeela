package com.example.androiddevchallenge.ui.screens

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.example.androiddevchallenge.BaseApplication
import com.example.androiddevchallenge.model.KrishnaLifeEvent
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.glide.GlideImage

class DetailsActivity : AppCompatActivity() {

    companion object {
        fun actionStart(event: KrishnaLifeEvent) {
            val context = BaseApplication.getContext()
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("title", event.title)
            intent.putExtra("imageUrl", event.image)
            intent.addFlags(FLAG_ACTIVITY_NEW_TASK)
            ContextCompat.startActivity(context, intent, null)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val name = intent.getStringExtra("title")
        val imageUrl = intent.getStringExtra("imageUrl")
        setContent {
            MyTheme {
                DetailScreen(name.toString(), imageUrl.toString())
            }
        }
    }
}

@Composable
fun DetailScreen(name: String, imageUrl: String) {
    Surface(color = MaterialTheme.colors.background) {
        Column(modifier = Modifier.fillMaxSize()) {
            GlideImage(
                data = imageUrl,
                contentDescription = "krishna image",
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
            )
            Text(
                text = name,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.Start)
                    .padding(
                        top = 8.dp,
                        start = 8.dp
                    ),
                style = MaterialTheme.typography.h6
            )
        }
    }
}
