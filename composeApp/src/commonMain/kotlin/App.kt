import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import home.HomeScreen
import home.HomeViewModel
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


                    val viewModel = koinViewModel<HomeViewModel>()
                    HomeScreen(viewModel)
                }
            }


        }
    }
}