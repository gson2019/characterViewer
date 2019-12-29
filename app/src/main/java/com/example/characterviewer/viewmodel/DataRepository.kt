package com.example.characterviewer.viewmodel

import com.example.characterviewer.api.CharacterApi
import com.example.characterviewer.model.CharacterResponse
import javax.inject.Inject

class DataRepository @Inject constructor(characterApi: CharacterApi) {
    private var characterApi:CharacterApi = characterApi

    suspend fun getRemoteCharacters(query: String, format:String):CharacterResponse{
        return characterApi.getCharacterSet(query, format)
    }
}