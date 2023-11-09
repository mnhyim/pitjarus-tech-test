package com.mnhyim.pitjarustechtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.mnhyim.auth.AuthNavGraph
import com.mnhyim.auth.NavigateToMainNavGraph
import com.mnhyim.main.MainNavGraph
import com.mnhyim.main.NavigateToVisitationNavGraph
import com.mnhyim.pitjarustechtest.navigation.RootNavGraph
import com.mnhyim.ui.theme.PitjarusTechTestTheme
import com.mnhyim.visitation.VisitationNavGraph
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.dependency
import com.ramcosta.composedestinations.navigation.navigate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PitjarusTechTestTheme {
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.background
                ) { paddingValues ->
                    DestinationsNavHost(
                        navGraph = RootNavGraph,
                        navController = navController,
                        modifier = Modifier.padding(paddingValues),
                        dependenciesContainerBuilder = {
                            dependency(AuthNavGraph) {
                                NavigateToMainNavGraph {
                                    navController.navigate(MainNavGraph)
                                }
                            }
                            dependency(MainNavGraph) {
                                NavigateToVisitationNavGraph {
                                    navController.navigate(VisitationNavGraph)
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}