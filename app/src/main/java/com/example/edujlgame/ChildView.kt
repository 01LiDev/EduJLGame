package com.example.edujlgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.edujlgame.databinding.ActivityChildViewBinding

class ChildView : AppCompatActivity() {
    private lateinit var binding: ActivityChildViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChildViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.startGame.setOnClickListener {
            val intent = Intent(this, GameView::class.java)
            startActivity(intent)
        }
        binding.logout.setOnClickListener {
            val intent = Intent(this, LoginView::class.java)
            startActivity(intent)
        }
    }
}