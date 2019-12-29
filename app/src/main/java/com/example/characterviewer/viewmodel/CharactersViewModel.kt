package com.example.characterviewer.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.characterviewer.model.CharacterInfo
import com.example.characterviewer.model.CharacterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharactersViewModel(repository: DataRepository):ViewModel(){
    private var dataRepository: DataRepository = repository
    var charactersLiveData = MutableLiveData<MutableList<CharacterInfo>>()

    fun getRemoteCharacters():Unit{
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("MyTag", "IO Dispatchers launched")
            val characterResponse = dataRepository.getRemoteCharacters("simpsons+characters", "json");
            Log.d("MyTag", characterResponse.characterInfos.size.toString())
            val characterList = characterResponse.characterInfos
            withContext(Dispatchers.Main) {
                charactersLiveData.value = characterList.toMutableList()
            }
        }
    }

    // custom view model factory, use to build pass variables to view model
    class ChractersViewModelFactory(private val dataRepository: DataRepository) : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CharactersViewModel(dataRepository) as T
        }
    }
}