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
fun Mfa(
    closeConnectionFlow: () -> Unit,
    goBack: () -> Unit,
    openConnectionSuccessful: () -> Unit
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
                Text("This is MFA screen")
                Button(onClick = closeConnectionFlow) {
                    Text(text = "Close connection flow")
                }
                Button(onClick = goBack) {
                    Text(text = "Go back")
                }
                Button(onClick = openConnectionSuccessful) {
                    Text(text = "Open connection successful")
                }
            }
        }
    }
}