package call_package.profile


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import call_package.model.User
import com.example.lab1.R
import com.example.lab1.TranslationPreview
import com.example.lab1.ui.theme.Lab1Theme


@Composable
fun ProfileHeader(
    user: User,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        // User Avatar
        UserAvatar(user = user)

        // Gradient Overlay
        GradientOverlay(user = user)

        // User Details and Action Buttons
        UserDetailsAndActionButtons()
        Box( modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 48.dp)
            .size(36.dp)
            .align(Alignment.TopStart)
            .border(1.dp, Color.White, RoundedCornerShape(12.dp))
            .background(Color.Transparent)

        ){
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                contentDescription = stringResource(R.string.back_button),
                tint = Color.White.copy(alpha = 0.6f),
                modifier = Modifier
                    .align(Alignment.Center)


            )
        }

    }
}

@Composable
fun UserAvatar(user: User) {
    Image(
        painter = painterResource(id = user.avatar),
        contentDescription = "Avatar",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
}

@Composable
fun GradientOverlay(user: User) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(40.dp)),
        contentAlignment = Alignment.BottomCenter,
    ) {
        Spacer(modifier = Modifier
            .height(256.dp)
            .fillMaxWidth())

        // Gradient Background
        GradientBackground(user = user)

    }
}

@Composable
fun GradientBackground(user: User) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .height(256.dp)
            .background(
                brush = Brush.verticalGradient(listOf(Color.Transparent, Color.Blue))
            )
    ) {
        Spacer(modifier = Modifier.size(24.dp))

        // Calling Text
        Text(
            text = stringResource(R.string.calling),
            color = Color.White,
            textAlign = TextAlign.Center,
            style = TextStyle(fontSize = 14.sp)
        )

        Spacer(modifier = Modifier.size(24.dp))

        // User Name
        Text(
            text = user.name,
            color = Color.White,
            textAlign = TextAlign.Center,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp, fontFamily = FontFamily.Serif)
        )

        Spacer(modifier = Modifier.size(48.dp))
    }
}

@Composable
fun UserDetailsAndActionButtons() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxSize()
            .alpha(0.75f),

    ) {
        // Action Buttons
        Box( modifier = Modifier
            .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter,

        ){
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(48.dp)
            ) {
                ButtonStyle(
                    icon = painterResource(R.drawable.baseline_mic_off_24),
                    description = stringResource(R.string.mic)
                )
                Spacer(modifier = Modifier.size(12.dp))
                ButtonStyle(
                    icon = painterResource(R.drawable.baseline_call_end_24),
                    description = stringResource(R.string.call_end),
                    bgButtonColor = Color.Red
                )
                Spacer(modifier = Modifier.size(12.dp))
                ButtonStyle(
                    icon = painterResource(R.drawable.baseline_volume_up_24),
                    description = stringResource(R.string.volume_up)
                )
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