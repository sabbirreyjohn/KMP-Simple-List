import android.content.Context

actual class BatteryManager(context: Context) {
    actual fun getBatteryLevel(): Int {
        return 90
    }
}