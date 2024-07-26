package di

import io.ktor.client.engine.darwin.Darwin
import network.createHttpClient
import org.koin.dsl.module

actual val platformModule = module {
    single { createHttpClient(Darwin.create()) }
}