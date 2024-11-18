package com.example.rickandmortytesthomeland.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.rickandmortytesthomeland.viewmodels.CharacterViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState

@Composable
fun CharacterList(viewModel: CharacterViewModel) {
    // Obtener la lista de personajes del ViewModel
    val characters = viewModel.characters.value

    // Crear el estado para LazyColumn
    val listState = rememberLazyListState()

    LazyColumn(
        state = listState,
        contentPadding = PaddingValues(16.dp)
    ) {
        items(characters) { character ->
            CharacterItem(character)
        }

        // Detectar cuando llegamos al final de la lista
        item {
            val lastVisibleItemIndex = listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0
            val totalItems = listState.layoutInfo.totalItemsCount

            // Llamamos a la funcion `onScrolledToEnd` cuando el usuario llega al final de la lista
            if (lastVisibleItemIndex == totalItems - 1) {
                viewModel.onScrolledToEnd() // Carga mas personajes en la pagina actual
            }
        }
    }
}
