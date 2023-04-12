package com.example.cookingrecipe.AjaActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cookingrecipe.R;

import AjaManager.SessionManager;

public class RegisterActivity extends AppCompatActivity {
    // Deklarasi variabel dengan tipe EditText, Button, dan TextView
    EditText etUsername, etEmail, etPassword;
    Button btnSignUp;
    TextView txtLogin;
    SessionManager sessionManager;

    // Method onCreate yang dijalankan saat RegisterActivity dibuat
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Menghubungkan variabel dengan elemen-elemen pada layout
        etUsername = findViewById(R.id.txtUsername);
        etEmail = findViewById(R.id.txtEmailAddress);
        etPassword = findViewById(R.id.txtPassword);
        btnSignUp = findViewById(R.id.btn_Register);
        txtLogin = findViewById(R.id.txtLogin);

        // Membuat objek SessionManager
        sessionManager = new SessionManager(getApplicationContext());
        // Menambahkan listener pada tombol sign up
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Mengambil nilai dari EditText username, email, dan password
                String username = etUsername.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                // Jika salah satu field kosong, tampilkan toast error
                if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Please fill the fields.", Toast.LENGTH_SHORT).show();
                } else if (!username.isEmpty() && password.isEmpty() && email.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Please fill the fields.", Toast.LENGTH_SHORT).show();
                } else if (!username.isEmpty() && !password.isEmpty() && email.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Please fill the fields.", Toast.LENGTH_SHORT).show();
                } else if (!username.isEmpty() && password.isEmpty() && !email.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Please fill the fields.", Toast.LENGTH_SHORT).show();
                } else if (username.isEmpty() && !password.isEmpty() && !email.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Please fill the fields.", Toast.LENGTH_SHORT).show();
                } else {
                    // Menyimpan data login ke dalam SessionManager
                    sessionManager.createLoginSession(username, password);
                    // Menampilkan toast sukses
                    Toast.makeText(RegisterActivity.this, "Registration success!", Toast.LENGTH_SHORT).show();
                    // Membuat objek Intent ke LoginActivity
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    // Menjalankan LoginActivity
                    startActivity(intent);
                    finish();
                }
            }
        });

        // Menambahkan listener pada teks login
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}