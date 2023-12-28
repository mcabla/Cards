package be.mcabla.cards.ui.card

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import be.mcabla.cards.R

/**
 * Created by Casper Haems on 28/12/2023.
 * Copyright (c) 2023 mcabla. All rights reserved.
 */
class CardAdapter(private val cardList: List<CardItem>) : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val subtextTextView: TextView = itemView.findViewById(R.id.subtextTextView)
        val logoImageView: ImageView = itemView.findViewById(R.id.logoImageView)
        val backgroundImageView: ImageView = itemView.findViewById(R.id.backgroundImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = cardList[position]

        holder.titleTextView.text = card.title
        holder.subtextTextView.text = card.subtext
        holder.logoImageView.setImageResource(card.logoResId)
        holder.backgroundImageView.setImageResource(card.backgroundImageResId)
    }

    override fun getItemCount(): Int {
        return cardList.size
    }
}