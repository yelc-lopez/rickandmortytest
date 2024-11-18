package com.example.rickandmortytesthomeland.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortytesthomeland.api.RetrofitInstance
import com.example.rickandmortytesthomeland.models.CharacterResponse
import com.example.rickandmortytesthomeland.models.Character

import kotlinx.coroutines.launch
import retrofit2.Response

class CharacterViewModel : ViewModel() {
    private val _characters = mutableStateOf<List<Character>>(emptyList()) // Listado dinamico
    val characters: State<List<Character>> get() = _characters

    private var currentPage = 1 // Página inicial
    private val pageSize = 20 // Número de personajes por página

    init {
        fetchCharacters(currentPage)
    }

    // Función para cargar los personajes
    private fun fetchCharacters(page: Int) {
        viewModelScope.launch {
            try {
                val response: Response<CharacterResponse> = RetrofitInstance.api.getCharacters(page)
                if (response.isSuccessful) {
                    // Agregar los nuevos personajes a la lista actual
                    val newCharacters = response.body()?.results ?: emptyList()
                    _characters.value = _characters.value + newCharacters
                    currentPage++ // Incrementar la página para la siguiente peticion
                }
            } catch (e: Exception) {
                //TODO: Agregar logica para solicitar permiso de internet, error generico.
            }
        }
    }

    // Función para verificar si se llegó al final de la lista
    fun onScrolledToEnd() {
        fetchCharacters(currentPage) // Cargar más personajes cuando se llegue al final
    }
}
