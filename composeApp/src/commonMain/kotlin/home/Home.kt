package home


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import network.Product
import org.jetbrains.compose.resources.painterResource
import kotlin.random.Random


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
            // UserRow(it, clickedUserName)
            ProductCard(it, clickedUserName)
        }

    }
}


@Composable
fun ProductCard(product: Product, clickedUserName: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row( // Now using Row here
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(), // Ensure Row takes full width
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(modifier = Modifier.weight(1f)) {
                KamelImage(
                    asyncPainterResource(product.thumbnail),
                    contentDescription = "avatar",
                    modifier = Modifier.size(80.dp).align(Alignment.Top)
                )
                Spacer(modifier = Modifier.height(8.dp).width(4.dp))
                Column {
                    Text(
                        text = product.title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "* Category ${product.category}", fontSize = 12.sp)
                    Text(text = "* Brand ${product.brand}", fontSize = 12.sp)
                    Text(text = "* Remaining stock ${product.stock}", fontSize = 12.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        for (i in 1..product.rating.toInt()) {
                            Icon(
                                imageVector = Icons.Filled.Star,
                                contentDescription = "Star",
                                tint = Color.Blue,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }
                    Text(text = "${Random.nextInt(0,100)} reviews", fontSize = 12.sp)
                }
            }
            Column(
                modifier = Modifier.weight(0.5f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "$${product.price.toInt()}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                    color = Color.Red
                )
                Text(
                    text = "$${(product.price / (1 - (product.discountPercentage / 100))).toInt()}",
                    fontSize = 12.sp,
                    textDecoration = TextDecoration.LineThrough
                )
                Spacer(modifier = Modifier.height(16.dp))
                Icon(
                    imageVector = Icons.Filled.FavoriteBorder,
                    contentDescription = "Save for later",
                    modifier = Modifier.size(24.dp)
                )
                Text(text = "Save for later", fontSize = 12.sp)
            }
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
