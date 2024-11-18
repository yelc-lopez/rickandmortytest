package com.example.rickandmortytesthomeland.api

import com.example.rickandmortytesthomeland.models.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApi {

    //funcion para obtener el listado de caracteres
    @GET("character")
    suspend fun getCharacters(): Response<CharacterResponse>

    //funcion para obtener el listado de caracteres paginado
    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int): Response<CharacterResponse>
}
