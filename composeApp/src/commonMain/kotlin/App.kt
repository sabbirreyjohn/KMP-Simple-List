import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dependencies.MyViewModel
import kmpbasiclist.composeapp.generated.resources.Res
import kmpbasiclist.composeapp.generated.resources.hello_world
import kmpbasiclist.composeapp.generated.resources.ic_android_black_24dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App(manager: BatteryManager) {
    MaterialTheme {
        KoinContext {

            NavHost(
                navController = rememberNavController(),
                startDestination = "home"
            ) {

                composable("home") {
//                    val viewModel = koinViewModel<MyViewModel>()
//                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//                        Column {
//                            Image(painterResource(Res.drawable.ic_android_black_24dp), null)
//                            Text(text = viewModel.getHelloWorld() + " ${manager.getBatteryLevel()}")
//                        }
//                    }

                    Counter()
                }
            }


        }
    }
}