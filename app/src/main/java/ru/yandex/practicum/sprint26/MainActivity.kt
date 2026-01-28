package ru.yandex.practicum.sprint26

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { ContactDetails(mockContacts[1]) }
    }


    @Preview(name = "portrait", showSystemUi = true)
    @Composable
    fun Task1Preview() {
        ContactDetails(mockContacts[0])
    }

    @Preview(name = "portrait", showSystemUi = true)
    @Composable
    fun Task2Preview() {
        ContactDetails(mockContacts[1])
    }
}
