package com.mnhyim.visitation.store_list.components

import android.view.View
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.mnhyim.domain.model.Store
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.FolderOverlay
import org.osmdroid.views.overlay.Marker

@Composable
fun OsmdroidMapView(
    stores: List<Store>,
    navigateToDetail: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val mapView = rememberMapViewWithLifecycle()
    Configuration.getInstance().userAgentValue = "ADASDASDASDASDASD"

    AndroidView(
        factory = { mapView },
        modifier = modifier
    ) { view ->
        mapView.setTileSource(TileSourceFactory.MAPNIK)

        mapView.visibility = View.VISIBLE
        mapView.setMultiTouchControls(true)

        // Initialize the MapView
        val mapController = view.controller
        mapController.setZoom(6.0)

        // Set the map center to a specific location
        val startPoint = GeoPoint(0.7893, 113.9213)
        mapController.setCenter(startPoint)

        // Add a cluster of markers
        val cluster = FolderOverlay()
        stores.forEachIndexed { index, store ->
            val markerPoint = GeoPoint(
                store.latitude.toDouble(),
                store.longitude.toDouble()
            )
            val randomMarker = Marker(view)
            randomMarker.position = markerPoint
            randomMarker.setOnMarkerClickListener { marker, mapView ->
                navigateToDetail(store.storeId)
                Toast.makeText(view.context, "${store.storeId} Clicked", Toast.LENGTH_SHORT).show()
                true
            }
            cluster.add(randomMarker)
        }
        mapView.overlays.add(cluster)


        // Refresh the map
        mapView.invalidate()
    }
}

@Composable
private fun rememberMapViewWithLifecycle(): MapView {
    val context = LocalContext.current
//    val mapView = remember { MapView(context) }
    val mapView = remember {
        MapView(context).apply {
//            id = R.id.osm_map
            clipToOutline = true
        }
    }

    val observer = remember { MapViewLifecycleObserver(mapView) }
    val lifecycle = LocalLifecycleOwner.current.lifecycle

    DisposableEffect(Unit) {
        lifecycle.addObserver(observer)
        onDispose {
            lifecycle.removeObserver(observer)
        }
    }

    return mapView
}

class MapViewLifecycleObserver(private val mapView: MapView) : DefaultLifecycleObserver {
    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        mapView.onResume()
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        mapView.onPause()
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        mapView.onDetach()
    }
}