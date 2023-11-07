package com.mnhyim.pitjarustechtest.navigation

import com.mnhyim.auth.AuthNavGraph
import com.mnhyim.main.MainNavGraph
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec

object RootNavGraph : NavGraphSpec {

    override val route = "root"

    override val startRoute = AuthNavGraph

    override val destinationsByRoute = emptyMap<String, DestinationSpec<*>>()

    override val nestedNavGraphs = listOf(
        AuthNavGraph,
        MainNavGraph
    )
}