package com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.R
import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.comon.Constante
import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.databinding.OrdinatorItemBinding
import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.domain.model.Ordinateur
import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.domain.model.OrdinateurLikebale
import com.squareup.picasso.Picasso

class PcAdapter(val like: (ordinateur: Ordinateur)->Unit = {}, val click:(ordinateur: Ordinateur)->Unit = {}): ListAdapter<OrdinateurLikebale,PcAdapter.PcViewHolder>(PcDiffUtil()) {

    inner class PcViewHolder(val binding: OrdinatorItemBinding): ViewHolder(binding.root)




    class PcDiffUtil: DiffUtil.ItemCallback<OrdinateurLikebale>() {
        override fun areItemsTheSame(
            oldItem: OrdinateurLikebale,
            newItem: OrdinateurLikebale
        ): Boolean {
            return oldItem.ordinateur == newItem.ordinateur
        }

        override fun areContentsTheSame(
            oldItem: OrdinateurLikebale,
            newItem: OrdinateurLikebale
        ): Boolean {
            return oldItem.isLiked == newItem.isLiked
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PcViewHolder {
        return PcViewHolder(binding = OrdinatorItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: PcViewHolder, position: Int) {
        val ordinateur = getItem(position).ordinateur
        val isLiked = getItem(position).isLiked
        holder.binding.ordinatorName.text = ordinateur.nom
        holder.binding.ordinatorPrice.text = ordinateur.prix
        holder.binding.ordinatorOs.text = ordinateur.systeme_exploitation

        val time = Constante.getUnixTimestampFromDate(ordinateur.date_fin_os,Constante.DATE_FORMAT) - (System.currentTimeMillis() / 1000)

        val remainingTime = Constante.getRemainingTime(time)

        holder.binding.ordinatorExperation.text = remainingTime

        Picasso.get().load(ordinateur.image).placeholder(R.drawable.lama).resize(200,200).into(holder.binding.ordinatorImage)
        holder.binding.likeBtn.setOnClickListener {
            like(ordinateur)
        }

    }
}