package dependencies

import androidx.lifecycle.ViewModel

class MyViewModel(private val repository: MyRepository) : ViewModel() {

    fun getHelloWorld(): String {
        return repository.helloWorld()
    }
}