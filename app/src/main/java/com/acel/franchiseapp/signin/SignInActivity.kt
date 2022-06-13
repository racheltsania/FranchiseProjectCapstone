package com.acel.franchiseapp.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.acel.franchiseapp.home.HomeActivity
import com.acel.franchiseapp.R

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val username = "acel"
        val password = "123456"

        val etUsername: EditText = findViewById(R.id.editemail)
        val etPassword: EditText = findViewById(R.id.edit_password)
        val btLogin: Button = findViewById(R.id.btn_signin)

        btLogin.setOnClickListener(View.OnClickListener {
            if (etUsername.text.isEmpty() || etPassword.text.isEmpty()) {
                Toast.makeText(this, "Isi data pengguna dengan benar", Toast.LENGTH_LONG).show()
            } else if (etUsername.text.toString().equals(username) && etPassword.text.toString().equals(password)) {
                Toast.makeText(this, "Login berhasil", Toast.LENGTH_LONG).show()
                val intent = Intent(this@SignInActivity, HomeActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Login gagal", Toast.LENGTH_LONG).show()
            }
        })
    }
}