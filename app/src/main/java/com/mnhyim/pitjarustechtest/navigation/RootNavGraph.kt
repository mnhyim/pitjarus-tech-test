package com.mnhyim.pitjarustechtest.navigation

import com.mnhyim.auth.AuthNavGraph
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.ramcosta.composedestinations.spec.Route

object RootNavGraph : NavGraphSpec {

    override val route: String = "root"

    override val startRoute: Route = AuthNavGraph

    override val destinationsByRoute: Map<String, DestinationSpec<*>> = emptyMap()

    override val nestedNavGraphs = listOf(
        AuthNavGraph,
    )
}