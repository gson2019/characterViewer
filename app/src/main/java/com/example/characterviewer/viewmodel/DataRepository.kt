package com.example.characterviewer.viewmodel

import com.example.characterviewer.api.CharacterApi
import com.example.characterviewer.model.CharacterResponse

class DataRepository(characterApi: CharacterApi) {
    private var characterApi:CharacterApi = characterApi
    suspend fun getCharacters():CharacterResponse{
        return characterApi.getCharacterSet("")
    }

    suspend fun getRemoteCharacters(endPoint: String):CharacterResponse{
        return characterApi.getCharacterSet("")
    }
}