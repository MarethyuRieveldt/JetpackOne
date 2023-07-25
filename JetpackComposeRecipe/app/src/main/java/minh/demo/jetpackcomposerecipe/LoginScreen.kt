package minh.demo.jetpackcomposerecipe

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import minh.demo.jetpackcomposerecipe.ui.theme.JetpackComposeRecipeTheme

@ExperimentalMaterial3Api
@Composable
fun LoginScreen(navController: NavController) {
    val inputvalue = remember { mutableStateOf(TextFieldValue()) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = stringResource(id = R.string.login), modifier = Modifier.padding(16.dp))

        TextField(
            value = inputvalue.value,
            onValueChange = { inputvalue.value = it },
            placeholder = { Text(text = "Username") },
            modifier = Modifier
                .padding(all = 16.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = false,
                keyboardType = KeyboardType.Text
            ),
            singleLine = true,
        )

        TextField(
            value = inputvalue.value,
            onValueChange = { inputvalue.value = it },
            placeholder = { Text(text = "Password") },
            modifier = Modifier
                .padding(all = 16.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = false,
                keyboardType = KeyboardType.Text
            ),
            singleLine = true,
        )

        val context  = LocalContext.current
        Button(onClick = {
            Toast.makeText(context,"login Success", Toast.LENGTH_LONG).show()
            navController.navigate(Screen.HomeScreen.route)
        }) {
            Text(text = "Login")
        }

        Text(text = "Don't have an account",modifier = Modifier.padding(16.dp))

        Button(onClick = {
            Toast.makeText(context,"Move to sign up", Toast.LENGTH_LONG).show()
        }) {
            Text(text = "Sign up")
        }
    }
}


