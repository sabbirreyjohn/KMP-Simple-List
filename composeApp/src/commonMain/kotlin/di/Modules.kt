package di

import home.HomeViewModel
import home.DataRepository
import home.DataRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import network.createHttpClient
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.scope.Scope
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

fun Scope.provideCoroutineScope() = CoroutineScope(SupervisorJob() + Dispatchers.Default)


val sharedModule = module {
    singleOf(::DataRepositoryImpl).bind<DataRepository>()
    viewModelOf(::HomeViewModel)
    single { provideCoroutineScope() }
}