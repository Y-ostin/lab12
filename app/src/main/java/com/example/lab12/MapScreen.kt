package com.example.lab12

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Marker


@Composable
fun MapScreen() {
    val ArequipaLocation = LatLng(-16.4040102, -71.559611) // Arequipa, Perú
    val cameraPositionState = rememberCameraPositionState {
        position = com.google.android.gms.maps.model.CameraPosition.fromLatLngZoom(ArequipaLocation, 12f)
    }


    Box(modifier = Modifier.fillMaxSize()) {
        // Añadir GoogleMap al layout
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {
            // Añadir marcador en Arequipa Perú
            // Dentro de tu función donde defines el marcador
            val context = LocalContext.current

// Cargar el Bitmap desde el recurso drawable
            val bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.logo)

// Escalar el Bitmap para que tenga un tamaño más pequeño
            val scaledBitmap = Bitmap.createScaledBitmap(bitmap, 100, 100, false) // Cambia el tamaño aquí (100x100 es un ejemplo)

// Convertir el Bitmap escalado a BitmapDescriptor
            val customMarker = BitmapDescriptorFactory.fromBitmap(scaledBitmap)

            Marker(
                state = rememberMarkerState(position = ArequipaLocation),
                icon = customMarker, // Usar el marcador escalado
                title = "Arequipa, Perú"
            )



        }
    }
}
