import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

class CounterKttest{

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun testCounter()= runComposeUiTest {

        setContent {
            Counter()
        }
        onNodeWithText("0").assertExists()
        onNodeWithText("1").assertDoesNotExist()
        onNodeWithText("Increment").performClick()
        onNodeWithText("0").assertDoesNotExist()
        onNodeWithText("1").assertExists()
    }
}