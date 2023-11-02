package com.mnhyim.pitjarustechtest.navigation

import com.mnhyim.login.LoginNavGraph
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.ramcosta.composedestinations.spec.Route

object RootNavGraph : NavGraphSpec {

    override val route: String = "root"

    override val startRoute: Route = LoginNavGraph

    override val destinationsByRoute: Map<String, DestinationSpec<*>> = emptyMap()

    override val nestedNavGraphs = listOf(
        LoginNavGraph,
    )
}