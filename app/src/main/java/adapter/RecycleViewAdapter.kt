package adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.RowLayaoutBinding
import model.CryptoModel

class RecyclerViewAdapter(private val cryptoList : ArrayList<CryptoModel>, private val listener : Listener) : RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {


        interface Listener {
            fun onItemClick(cryptoModel: CryptoModel)
        }

        private val colors: Array<String> = arrayOf("#13bd27","#29c1e1","#b129e1","#d3df13","#f6bd0c","#a1fb93","#0d9de3","#ffe48f")

        class RowHolder(val binding: RowLayaoutBinding) : RecyclerView.ViewHolder(binding.root) {

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
            val binding = RowLayaoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return RowHolder(binding)
        }

        override fun getItemCount(): Int {
            return cryptoList.count()
        }

        override fun onBindViewHolder(holder: RowHolder, position: Int) {
            holder.itemView.setOnClickListener {
                listener.onItemClick(cryptoList.get(position))
            }
            holder.itemView.setBackgroundColor(Color.parseColor(colors[position % 8]))

            holder.binding.name.text = cryptoList.get(position).currency
            holder.binding.price.text = cryptoList.get(position).price

        }


    }