package call_package.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun ButtonStyle(icon: Painter,description: String, bgButtonColor: Color = Color.White) {

    Box(modifier = Modifier
            .size(64.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(bgButtonColor),
            contentAlignment = Alignment.Center){
            Icon(painter = icon, contentDescription = description,
                modifier = Modifier.size(36.dp).background(bgButtonColor) )
        }

    }

