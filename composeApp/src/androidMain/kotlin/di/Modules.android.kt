package di


import io.ktor.client.engine.okhttp.OkHttp
import network.createHttpClient
import org.koin.dsl.module

actual val platformModule = module {
    single { createHttpClient(OkHttp.create()) }
}