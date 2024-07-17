import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlin.test.Test

class InitialTest {

    @Test
    fun `getInitials returns correct initials`(){
        val initials = getInitials("John Doe")
        assertThat(initials).isEqualTo("JD")
    }
}