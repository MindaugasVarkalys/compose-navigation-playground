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
fun ConnectionSuccessful(
    goBack: () -> Unit,
    closeConnectionFlowAndOpenProfile: () -> Unit,
) {
    Scaffold {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(color = Color.Green),
            contentAlignment = Alignment.Center
        ) {
            Column {
                Text("This is connection successful screen")
                Button(onClick = goBack) {
                    Text(text = "Go back to MFA")
                }
                Button(onClick = closeConnectionFlowAndOpenProfile) {
                    Text(text = "Close connection flow and go to profile")
                }
            }
        }
    }
}