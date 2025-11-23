package viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TimerViewModel : ViewModel() {
    private val _time = MutableStateFlow(0)
    val time: StateFlow<Int> = _time.asStateFlow()

    private val _isRunning = MutableStateFlow(true)
    val isRunning: StateFlow<Boolean> = _isRunning.asStateFlow()

    init {
        startTimer()
    }

    private fun startTimer() {
        viewModelScope.launch {
            while (true) {
                delay(1000L) // 1 second delay
                if (_isRunning.value) {
                    _time.update { it + 1 }
                }
            }
        }
    }

    fun toggleTimer() {
        _isRunning.update { !it }
    }
}