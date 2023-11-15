package com.example.lab1.ui.profile


import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.lab1.R
import com.example.lab1.model.User
import com.example.lab1.ui.theme.Lab1Theme
import com.example.lab1.TranslationPreview


@Composable
fun ProfileHeader(
    user: User,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Spacer(modifier = Modifier.size(24.dp))
            Image(
                painter = painterResource(id = user.avatar),
                contentDescription = stringResource(R.string.avatar),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(86.dp)
                    .clip(CircleShape)
            )
            Row {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Text(text = user.name)
                }
                Spacer(modifier = Modifier.size(12.dp))
                Icon(
                    painter = painterResource(R.drawable.baseline_add_circle_outline_24),
                    contentDescription = stringResource(R.string.add_user),
                    tint = Color.Gray,
                    modifier = Modifier
                        .size(20.dp)
                        .alpha(0.6f)
                )
            }
            Row (modifier = Modifier.alpha(0.6f)){
                Text(
                    text = user.location,
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 10.sp,
                    )
                )
            }
            Spacer(modifier = Modifier.size(24.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = user.description,
                    style = TextStyle(
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )
            }
            Spacer(modifier = Modifier
                .size(24.dp)
                .fillMaxWidth())
            Column {

                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .alpha(0.75f)

                ) {
                    ProfileInfo(icon = painterResource(R.drawable.baseline_spa_24),
                        number = user.posts,
                        text = stringResource(R.string.posts),
                    )
                    ProfileInfo(icon = painterResource(R.drawable.baseline_people_24),
                        number = user.numberOfFollowers,
                        text = stringResource(R.string.followers)
                    )
                    ProfileInfo(icon = painterResource(R.drawable.baseline_people_outline_24),
                        number = user.numberOfFollowing,
                        text = stringResource(R.string.following)
                    )
                }
            }
        }
    }
}

@TranslationPreview
@Composable
fun ProfileHeaderPreview() {
    Lab1Theme {
        Surface {
            ProfileHeader(user = User.example)
        }
    }
}
