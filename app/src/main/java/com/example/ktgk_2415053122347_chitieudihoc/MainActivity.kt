package com.example.ktgk_2415053122347_chitieudihoc

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ktgk_2415053122347_chitieudihoc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding_2347: ActivityMainBinding
    private val danhSachKhoanChi = mutableListOf<KhoanChi>()
    private val khoanChiAdapter = KhoanChiAdapter(danhSachKhoanChi)
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
    }
}