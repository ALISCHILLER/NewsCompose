package com.msa.newscompose

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.msa.newscompose.domain.usecases.AppEntryUseCases
import com.msa.newscompose.ui.screen.onboarding.OnBoardingScreen
import com.msa.newscompose.ui.screen.onboarding.OnBoardingViewModel
import com.msa.newscompose.ui.theme.NewsComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var  appEntryUseCases: AppEntryUseCases
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,false)
        lifecycleScope.launch {
            appEntryUseCases.readAppEntry().collect{
                Log.d(TAG, "readAppEntry: ${it.toString()}")
            }
        }
        setContent {
            NewsComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel:OnBoardingViewModel = hiltViewModel()
                    OnBoardingScreen(event = viewModel::onEvent)
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewsComposeTheme {
        OnBoardingScreen({})
    }
}