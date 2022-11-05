package com.alperen.firebaseauth

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvResult = findViewById<TextView>(R.id.tvResult)

        // Kullanıcı email adresi
        val email = FirebaseAuth.getInstance().currentUser?.email
        // Kullanıcı id
        val id = FirebaseAuth.getInstance().currentUser?.uid
        // Emaili onaylandı mı
        val isEmailVerified = FirebaseAuth.getInstance().currentUser?.isEmailVerified

        val result = "Email: $email\n" +
                "ID: $id\n" +
                "Email onaylandı mı: $isEmailVerified"
    }
}