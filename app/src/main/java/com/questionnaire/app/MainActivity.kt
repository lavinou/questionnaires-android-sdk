package com.questionnaire.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lavinou.questionnaire.Questionnaire
import com.questionnaire.app.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val questionnaire = Questionnaire
            .Builder(activity = this, apiKey = "<api-key>")
            .build()

        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android", onClick = { id ->
                        questionnaire.launch(id)
                    })
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, onClick: (String) -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )

        Button(onClick = {
            onClick("<project-key>")
        }) {
            Text(text = "After Purchase Survey")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android", onClick = {})
    }
}