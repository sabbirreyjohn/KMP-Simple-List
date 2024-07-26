package xyz.androidrey.multimoduletemplate.main.ui.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.unit.dp


@Composable
fun ShowError(message: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Icon(
                imageVector = Icons.Default.Warning,
                contentDescription = "failed",
                modifier = Modifier.size(128.dp),  // Sets the size of the icon
                tint = MaterialTheme.colors.error  // Optional: sets the icon color
            )
            Text(text = message)
        }
    }
}