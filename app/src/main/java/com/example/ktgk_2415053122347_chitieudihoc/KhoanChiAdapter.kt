package com.example.ktgk_2415053122347_chitieudihoc

import androidx.recyclerview.widget.RecyclerView
import com.example.ktgk_2415053122347_chitieudihoc.databinding.ItemKhoanChiBinding
import android.view.ViewGroup
import android.view.LayoutInflater
class KhoanChiAdapter(private val danhSach: List<KhoanChi>, private val khiBam: (KhoanChi) -> Unit): RecyclerView.Adapter<KhoanChiAdapter.KhoanChiViewHolder>() {
    class KhoanChiViewHolder(val binding: ItemKhoanChiBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KhoanChiViewHolder {
        val binding= ItemKhoanChiBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return KhoanChiViewHolder(binding)
    }

    override fun getItemCount(): Int = danhSach.size
    override fun onBindViewHolder(holder: KhoanChiViewHolder, position: Int) {
        val khoanChi = danhSach[position]
        val trangThai = if (khoanChi.daThanhToan){
            "Da thanh toan"
        }
        else {
            "Chua thanh toan"
        }
        holder.binding.root.text = "${khoanChi.ten}\n${khoanChi.soTien}\n$trangThai"
        holder.itemView.setOnClickListener {
            val viTri = holder.bindingAdapterPosition
            if (viTri != RecyclerView.NO_POSITION) {
                khiBam(danhSach[viTri])
            }
        }
    }

}