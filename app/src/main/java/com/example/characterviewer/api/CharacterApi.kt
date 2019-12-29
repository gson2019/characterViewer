package com.example.characterviewer.api

import com.example.characterviewer.model.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface CharacterApi {
    @GET("/")
    suspend fun getCharacterSet(
                            @Query("q", encoded=true) query:String,
                                @Query("format") dataType: String):CharacterResponse
}