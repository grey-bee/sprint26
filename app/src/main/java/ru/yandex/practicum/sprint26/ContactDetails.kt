package ru.yandex.practicum.sprint26

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ContactDetails(contact: Contact) {
    val initial = "${contact.name[0]}${contact.familyName[0]}"
    Column(
        modifier = Modifier
            .padding(vertical = 16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        ContactAvatar(contact.imageRes, initial)
        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = "${contact.name} ${contact.surname ?: ""}",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = contact.familyName,
                fontSize = 24.sp,
            )
            if (contact.isFavorite)
                Image(
                    modifier = Modifier.padding(start = 8.dp),
                    painter = painterResource(id = android.R.drawable.star_big_on),
                    contentDescription = null
                )
        }
        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp)
        ) {
            InfoRow(R.string.phone, contact.phone)
            InfoRow(R.string.address, contact.address)
            if (contact.email != null)
                InfoRow(R.string.email, contact.email)
        }


    }
}

@Composable
fun InfoRow(name: Int, data: String?) {
    Row(
        modifier = Modifier.padding(top = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            "${stringResource(name)}:",
            fontSize = 18.sp,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(
            text = data ?: "",
            fontSize = 16.sp,
            modifier = Modifier.width(200.dp)
        )
    }
}

@Composable
fun ContactAvatar(photo: Int?, initial: String) {
    if (photo != null) {
        Image(
            painterResource(photo),
            modifier = Modifier.size(80.dp, 80.dp),
            contentDescription = ""
        )
    } else {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .height(76.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.circle),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
            Text(
                text = initial,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}