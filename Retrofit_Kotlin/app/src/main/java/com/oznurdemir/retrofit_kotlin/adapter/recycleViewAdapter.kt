package com.oznurdemir.retrofit_kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oznurdemir.retrofit_kotlin.R
import com.oznurdemir.retrofit_kotlin.model.CryptoModel
import kotlinx.android.synthetic.main.row.view.*

class recycleViewAdapter(private val cryptoList: ArrayList<CryptoModel>): RecyclerView.Adapter<recycleViewAdapter.RowHolder>() {
    class RowHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(cryptoModel: CryptoModel) {
            val currency = itemView.findViewById<TextView>(R.id.textView)
            val price = itemView.findViewById<TextView>(R.id.textView2)
            currency.text = cryptoModel.currency
            price.text = cryptoModel.price
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        // ViewGroup' u kullanarak row_layout' u bağlıyoruz.
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false)
        return RowHolder(view)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        // Hangi item' ın hangi veriyi göstereceğini yazıyoruz.
        val cryptoModel = cryptoList[position]
        holder.bind(cryptoModel)
    }

    override fun getItemCount(): Int {
        // Kaç rane row oluşturulacağını bildiriyoruz.
        return cryptoList.count()
    }
}