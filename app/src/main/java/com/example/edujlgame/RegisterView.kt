package com.example.edujlgame

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.edujlgame.databinding.ActivityRegisterBinding

class RegisterView : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val accounts = "accounts"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPreferences: SharedPreferences = this.getSharedPreferences(accounts,
            Context.MODE_PRIVATE)
        val editor:SharedPreferences.Editor =  sharedPreferences.edit()
        binding.cAccount.setOnClickListener {
            if (binding.firstName.text.toString().isEmpty() || binding.lastName.text.toString().isEmpty() || binding.cUsername.text.toString().isEmpty() || binding.cPassword.text.toString().isEmpty()){
                Toast.makeText(applicationContext, "Fields can not be empty!", Toast.LENGTH_SHORT).show()
            }else if (binding.pAccountChoice.isChecked){
                editor.putString("pFirstName", binding.firstName.text.toString())
                editor.putString("pLastName", binding.lastName.text.toString())
                editor.putString("pUsername", binding.cUsername.text.toString())
                editor.putString("pPassword", binding.cPassword.text.toString())
                editor.apply()
                val intent = Intent(this, ParentView::class.java)
                startActivity(intent)
            }else if(binding.cAccountChoice.isChecked){
                editor.putString("cFirstName", binding.firstName.text.toString())
                editor.putString("cLastName", binding.lastName.text.toString())
                editor.putString("cUsername", binding.cUsername.text.toString())
                editor.putString("cPassword", binding.cPassword.text.toString())
                editor.apply()
                val intent = Intent(this, ChildView::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(applicationContext, "Must Select Account Type", Toast.LENGTH_SHORT).show()
            }
        }
    }

}