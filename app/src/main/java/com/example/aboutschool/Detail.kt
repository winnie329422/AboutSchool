package com.example.aboutschool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.aboutschool.databinding.ActivityDetailBinding
import java.util.zip.Inflater

class Detail : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(LayoutInflater.from(this))
        setContentView(R.layout.activity_detail)

        val name = intent.getStringExtra("name")
        val imageId =intent.getIntExtra("imageId",R.drawable.d02)

        binding.dName.text = name
        binding.departmentImage.setImageResource(imageId)


    }
}