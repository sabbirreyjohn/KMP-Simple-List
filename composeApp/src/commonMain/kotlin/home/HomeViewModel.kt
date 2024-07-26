package home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import network.Result

class HomeViewModel(private val coroutineScope: CoroutineScope, private val repo: DataRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.ProfileListLoading)
    val uiState = _uiState.asStateFlow()






    init {
        coroutineScope.launch {
            when (val status = repo.getProducts(0)) {

                is Result.Error -> _uiState.value =
                    HomeUiState.ProfileListLoadingFailed(status.error.name)

                is Result.Success -> _uiState.value =
                    HomeUiState.ProfileListLoaded(status.data.products)
            }
        }
    }

    override fun onCleared() {
        coroutineScope.cancel()
    }
}