package com.example.characterviewer.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.characterviewer.R
import com.example.characterviewer.model.CharacterInfo

class CharactersAdapter(
    context: Context,
    characterList: MutableList<CharacterInfo>,
    itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder>() {
    private var mContext = context;
    private var characterList = characterList
    private var onClickListener: OnItemClickListener = itemClickListener

    interface OnItemClickListener{
        fun onClick(view: View, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
       val view = LayoutInflater.from(mContext).inflate(R.layout.grid_character_layout, parent, false)
        return CharacterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return characterList.size
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val options : RequestOptions =  RequestOptions()
            .placeholder(R.drawable.nophoto)
            .error(R.drawable.nophoto)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.HIGH);
        Glide.with(mContext)
            .load(characterList.get(position).icon.uRL)
            .apply(options)
            .into(holder.characterImg)
        holder.itemView.tag = position
    }

    inner class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        override fun onClick(p0: View?) {
            if (p0 != null) {
                onClickListener.onClick(p0, p0.tag as Int)
            }
        }

        init {
            itemView.setOnClickListener(this)
        }
        var characterImg: ImageView = itemView.findViewById(R.id.characterIv)

    }
}