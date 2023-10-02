package minh.demo.jetpackcomposerecipe

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

val list1 = listOf<String>("Item 1", "Item 2", "Item 3")
val list2 = listOf<String>("Item 4", "Item 5", "Item 6")

@Composable
fun ItemList(
    item: List<String>,
    selected: Int,
    onItemSelect: (Int) -> Unit
) {
    Column {
        item.forEachIndexed { index, item ->
            Text(
                text = item,
                style = if (index == selected) MaterialTheme.typography.bodyLarge.copy(color = Color.Red)
                else MaterialTheme.typography.bodyLarge,
                modifier = Modifier.clickable {
                    onItemSelect(index)
                }
            )
        }
    }
}

@Composable
fun ListA() {
    val item = list1
    var selected by remember { mutableStateOf(-1) }
    ItemList(item = item, selected = selected) {
        selected = it
    }
}

@Composable
fun ListB() {
    val item = list2
    var selected by remember { mutableStateOf(-1) }
    ItemList(item = item, selected = selected) {
        selected = it
    }
}

@Composable
fun DetailScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            ListA()
            ListB()
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun PreviewCompose() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center,
//
//        ) {
//        ListA()
//        ListB()
//    }
//}