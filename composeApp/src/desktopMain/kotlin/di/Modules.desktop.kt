package di

import io.ktor.client.engine.okhttp.OkHttp
import network.createHttpClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import home.HomeViewModel

actual val platformModule = module {
    single { createHttpClient(OkHttp.create()) }
}