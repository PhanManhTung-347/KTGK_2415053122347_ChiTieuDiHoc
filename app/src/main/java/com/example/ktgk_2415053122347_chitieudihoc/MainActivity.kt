package com.example.ktgk_2415053122347_chitieudihoc

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ktgk_2415053122347_chitieudihoc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding_2347: ActivityMainBinding
    private val danhSachKhoanChi = mutableListOf<KhoanChi>()
    private val khoanChiAdapter = KhoanChiAdapter(danhSachKhoanChi)
    private var idTiepTheo = 1L
    private val regexTen = Regex("""\p{L}[\p{L}\p{M}0-9 .'-]{1,39}""")
    val regexSoTien = Regex("""[1-9][0-9]{0,7}""")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding_2347 = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar?.title = "Phan Manh Tung - 2415053122347"
        setContentView(binding_2347.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding_2347.rvKhoanChi.layoutManager = LinearLayoutManager(this)
        binding_2347.rvKhoanChi.adapter = khoanChiAdapter
        binding_2347.edtTen.doAfterTextChanged{
            binding_2347.tilTen.error = null
        }
        binding_2347.edtSoTien.doAfterTextChanged {
            binding_2347.tilSoTien.error = null
        }
        binding_2347.btnThem.setOnClickListener {
            themKhoanChi_2347()
        }

    }
    private fun themKhoanChi_2347(){
        val tenKhoanChi_2347 = binding_2347.edtTen.text.toString().trim()
        val noiDungSoTien_2347 = binding_2347.edtSoTien.text.toString().trim()
        val ghiChu_2347 = binding_2347.edtGhiChu.text.toString().trim()
        val tenHopLe_2347 = regexTen.matches(tenKhoanChi_2347)
        binding_2347.tilTen.error = if (tenHopLe_2347 == true)
        {
            null
        }
        else {
            "Vui long nhap ten hop le. Toi thieu 2 ky tu"
        }
        val soTien_2347 = if (regexSoTien.matches(noiDungSoTien_2347)){
            noiDungSoTien_2347.toLongOrNull()
        }
        else
        {
            null
        }
        if (soTien_2347== null || soTien_2347 !in 1L..10000000L)
        {
            binding_2347.tilSoTien.error = "Vui long nhap so tien hop le"
            return
        }
        binding_2347.tilSoTien.error = null
        if (tenHopLe_2347==false){
            return
        }
        danhSachKhoanChi.add(KhoanChi(id = idTiepTheo++, ten = tenKhoanChi_2347, soTien = soTien_2347, ghiChu = ghiChu_2347))
        Toast.makeText(this, "Them khoan chi thanh cong", Toast.LENGTH_SHORT).show()
        khoanChiAdapter.notifyItemInserted(danhSachKhoanChi.lastIndex)
        binding_2347.edtTen.text?.clear()
        binding_2347.edtSoTien.text?.clear()
        binding_2347.edtGhiChu.text?.clear()
    }

}