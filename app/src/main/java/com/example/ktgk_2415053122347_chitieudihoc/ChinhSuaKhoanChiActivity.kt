package com.example.ktgk_2415053122347_chitieudihoc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ktgk_2415053122347_chitieudihoc.databinding.ActivityChinhSuaKhoanChiBinding

class ChinhSuaKhoanChiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChinhSuaKhoanChiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChinhSuaKhoanChiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (!intent.hasExtra("id")) {
            finish()
            return
        }

        binding.edtTen.setText(intent.getStringExtra("ten").orEmpty())
        binding.edtSoTien.setText(intent.getLongExtra("soTien", 0L).toString())
        binding.edtGhiChu.setText(intent.getStringExtra("ghiChu").orEmpty())
        binding.swDaThanhToan.isChecked =
            intent.getBooleanExtra("daThanhToan", false)
        binding.btnHuy.setOnClickListener { finish() }
    }
}