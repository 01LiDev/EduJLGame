package com.example.edujlgame

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.edujlgame.databinding.ActivityLoginViewBinding

class LoginView : AppCompatActivity() {
    private lateinit var binding: ActivityLoginViewBinding
    private val accounts = "accounts"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        val sharedPreferences: SharedPreferences = this.getSharedPreferences(accounts,
            Context.MODE_PRIVATE)

        binding.login.setOnClickListener {
            val pUsername = sharedPreferences.getString("pUsername","NULL")
            val pPassword = sharedPreferences.getString("pPassword", "NULL")
            val cUsername = sharedPreferences.getString("cUsername","NULL")
            val cPassword = sharedPreferences.getString("cPassword", "NULL")
            if (binding.pAccountChoice.isSelected){
                    if (pUsername == binding.username.text.toString() && pPassword == binding.password.text.toString()){
                        Toast.makeText(applicationContext, "Successfully Login", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this,ParentView::class.java)
                        startActivity(intent)
                    }
                }else if (binding.cAccountChoice.isSelected){
                    if (cUsername == binding.username.text.toString() && cPassword == binding.password.text.toString()){
                        Toast.makeText(applicationContext, "Successfully Login", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this,ChildView::class.java)
                        startActivity(intent)
                    }
                }
        }
        binding.register.setOnClickListener {
            val intent = Intent(this, RegisterView::class.java)
            startActivity(intent)
        }
    }
}