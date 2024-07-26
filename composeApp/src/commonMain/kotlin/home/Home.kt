package home


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import network.Product


@Composable
fun HomeScreen(viewModel: HomeViewModel) {

    val uiState by viewModel.uiState.collectAsState()
    HomeStateHandler(uiState) {
        Home(it) {

        }
    }


}

@Composable
fun Home(products: List<Product>, clickedUserName: (String) -> Unit) {
    LazyColumn {
        items(products) {
            UserRow(it, clickedUserName)
        }

    }
}

@Composable
fun UserRow(product: Product, clickedUserName: (String) -> Unit) {
    Card(modifier = Modifier.testTag("product_collection").fillMaxWidth().wrapContentHeight()
        .padding(3.dp).clickable {
            clickedUserName(product.title)
        }) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {

            KamelImage(
                asyncPainterResource(product.thumbnail),
                contentDescription = "avatar",
                modifier = Modifier.size(50.dp).padding(4.dp)
            )
            Column(modifier = Modifier.padding(4.dp)) {
                Text(text = product.title, color = Color.Black)
            }
        }
    }
}
