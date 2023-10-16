package com.msa.newscompose

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msa.newscompose.domain.usecases.app_entry.ReadAppEntry
import com.msa.newscompose.ui.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val readAppEntry: ReadAppEntry
) : ViewModel() {

     var splashCondition by mutableStateOf(true)
        private set




    private val _startDestination = mutableStateOf(Route.AppStartNavigation.route)
    val startDestination: State<String> = _startDestination
    init {
       readAppEntry().onEach { shouldStartFromHomeScreen ->
            if (shouldStartFromHomeScreen)
                _startDestination.value = Route.NewsNavigation.route
            else
                _startDestination.value = Route.AppStartNavigation.route

            delay(300)
            splashCondition = false
        }.launchIn(viewModelScope)
    }
}