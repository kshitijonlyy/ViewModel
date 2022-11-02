package com.kshitij.viewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.kshitij.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var liveColorChangeViewModel: LiveColorChangeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        liveColorChangeViewModel = ViewModelProvider(this)[LiveColorChangeViewModel::class.java]

        binding.btnRed.setOnClickListener {
            liveColorChangeViewModel.color.value = 1
        }
        binding.btnGreen.setOnClickListener {
            liveColorChangeViewModel.color.value = 2
        }
        binding.btnBlue.setOnClickListener {
            liveColorChangeViewModel.color.value = 3
        }
    }
}