package com.example.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("myPref", MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        binding.apply {
            btnSave.setOnClickListener {

                Toast.makeText(applicationContext, "Saved", Toast.LENGTH_SHORT ).show()

                val userName = editUserName.text.toString()
                val email    = editEmail.text.toString()

                editor.apply {
                    putString("user_name", userName)
                    putString("email", email)
                    apply()
                }
            }

            btnLoad.setOnClickListener {

                Toast.makeText(applicationContext, "Loaded", Toast.LENGTH_SHORT ).show()

                val userName = sharedPreferences.getString("user_name", null)
                val email    = sharedPreferences.getString("email", null)

                tvUserName.text  = userName
                tvEmail.text     = email
            }

        }
    }
}