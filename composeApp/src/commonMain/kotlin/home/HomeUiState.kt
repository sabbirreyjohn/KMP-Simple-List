package home

import network.Product


sealed class HomeUiState {
    data class ProfileListLoaded(val users: List<Product>) : HomeUiState()

    data object ProfileListLoading : HomeUiState()

    data class ProfileListLoadingFailed(val message: String) : HomeUiState()
}