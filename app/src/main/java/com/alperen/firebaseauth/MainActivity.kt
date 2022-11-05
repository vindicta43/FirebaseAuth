package com.alperen.firebaseauth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val email = etEmail.text
            val pass = etPassword.text

            if (email.isNullOrEmpty() || pass.isNullOrEmpty()) {
                AlertDialog.Builder(this)
                    .setTitle("Hata")
                    .setMessage("Email ve şifre doldurulmalıdır")
                    .show()
            } else {
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(email.toString(), pass.toString())
                    .addOnSuccessListener {
                        AlertDialog.Builder(this)
                            .setTitle("Hata")
                            .setMessage("Kayıt başarılı")
                            .show()
                    }
                    .addOnFailureListener {
                        AlertDialog.Builder(this)
                            .setTitle("Hata")
                            .setMessage(it.localizedMessage)
                            .show()
                    }
            }
        }

        btnLogin.setOnClickListener {
            val email = etEmail.text
            val pass = etPassword.text

            if (email.isNullOrEmpty() || pass.isNullOrEmpty()) {
                AlertDialog.Builder(this)
                    .setTitle("Hata")
                    .setMessage("Email ve şifre doldurulmalıdır")
                    .show()
            } else {
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(email.toString(), pass.toString())
                    .addOnSuccessListener {
                        val intent = Intent(this, ResultActivity::class.java)
                        startActivity(intent)
                    }
                    .addOnFailureListener {
                        AlertDialog.Builder(this)
                            .setTitle("Hata")
                            .setMessage(it.localizedMessage)
                            .show()
                    }
            }
        }
    }
}