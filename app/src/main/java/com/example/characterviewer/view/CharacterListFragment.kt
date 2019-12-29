package com.example.characterviewer.view

import App
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.characterviewer.BuildConfig
import com.example.characterviewer.R
import com.example.characterviewer.api.CharacterApi
import com.example.characterviewer.api.CharacterInterceptor
import com.example.characterviewer.di.component.CharacterListComponent
import com.example.characterviewer.di.component.DaggerCharacterListComponent
import com.example.characterviewer.viewmodel.CharactersViewModel
import com.example.characterviewer.viewmodel.DataRepository
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_characterlist.*
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class CharacterListFragment : Fragment(), TabLayout.OnTabSelectedListener {

    @Inject
    lateinit var charactersViewModel: CharactersViewModel
    private lateinit var charactersAdapter: CharactersAdapter
    private lateinit var mContext: Context
    override fun onTabReselected(p0: TabLayout.Tab?) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTabUnselected(p0: TabLayout.Tab?) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTabSelected(p0: TabLayout.Tab?) {
        Log.d("MyTag", "tab 0 selected")
        charactersViewModel.getRemoteCharacters()
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_characterlist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tab_layout.addTab(tab_layout.newTab().setText("Simpsons"))
        tab_layout.addTab(tab_layout.newTab().setText("HBOs"))
        tab_layout.addOnTabSelectedListener(this)

        val okHttpClient: OkHttpClient =
            OkHttpClient.Builder().addInterceptor(CharacterInterceptor()).build()
        val retrofit: Retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("http://api.duckduckgo.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val characterApi: CharacterApi = retrofit.create(CharacterApi::class.java)
        charactersViewModel = ViewModelProvider(
            this, CharactersViewModel.ChractersViewModelFactory(
                DataRepository(characterApi)
            )
        ).get(CharactersViewModel::class.java)

        // tabLayout default option
        onTabSelected(tab_layout.getTabAt(0))

        charactersViewModel.charactersLiveData.observe(this, Observer {
            run {
                charactersAdapter =
                    CharactersAdapter(mContext, it, object : CharactersAdapter.OnItemClickListener {
                        override fun onClick(view: View, position: Int) {
                            Toast.makeText(mContext, "Item $position clicked", Toast.LENGTH_SHORT).show()
                        }
                    })
                characterRv.layoutManager = GridLayoutManager(mContext, 2)
                characterRv.adapter = charactersAdapter
            }
        })
    }

    private fun getComponent(context: Context?): CharacterListComponent {
        return DaggerCharacterListComponent.builder()
            .appComponent(((context?.applicationContext) as App).getAppComponent())
            .build()
    }


    companion object {
        fun newInstance(): CharacterListFragment {
            return CharacterListFragment()
        }
    }
}