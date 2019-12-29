package com.example.characterviewer.di.component

import com.example.characterviewer.FragmentScope
import com.example.characterviewer.view.CharacterListFragment
import dagger.Component

@FragmentScope
@Component(dependencies = [AppComponent::class])
interface CharacterListComponent {
    fun inject(characterListFragment: CharacterListFragment)
}