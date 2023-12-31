import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Login(
    closeConnectionFlow: () -> Unit,
    openMfa: () -> Unit
) {
    Scaffold {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(color = Color.Blue),
            contentAlignment = Alignment.Center
        ) {
            Column {
                Text("This is login screen")
                Button(onClick = closeConnectionFlow) {
                    Text(text = "Close connection flow")
                }
                Button(onClick = openMfa) {
                    Text(text = "Log in")
                }
            }
        }
    }
}