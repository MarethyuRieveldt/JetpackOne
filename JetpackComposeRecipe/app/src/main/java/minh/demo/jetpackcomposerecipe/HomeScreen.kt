package minh.demo.jetpackcomposerecipe

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController

@Composable
fun HomeScreen(name: String?, navController: NavController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            Text(text = "Hello")
            Text(text = "Welcome back, $name")
            val context = LocalContext.current
            Button(
                onClick = {
                    Toast.makeText(context, "Now to detail", Toast.LENGTH_LONG).show()
                    navController.navigate(Screen.DetailScreen.route)
                }
            ) {
                Text(text = "To detail")
            }
        }
    }
}