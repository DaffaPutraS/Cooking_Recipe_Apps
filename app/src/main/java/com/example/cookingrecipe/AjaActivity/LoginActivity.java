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

// Import custom class SessionManager untuk pengaturan session login
import AjaManager.SessionManager;

public class LoginActivity extends AppCompatActivity {
    // Deklarasi variabel untuk komponen tampilan
    EditText edtUsername, edtPassword;
    Button btnLogin;
    TextView txtRegister;

    // Deklarasi variabel untuk custom class SessionManager
    SessionManager sessionManager;

    // Deklarasi variabel default username dan password
    private static final String DEFAULT_USERNAME = "admin";
    private static final String DEFAULT_PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Set orientasi tampilan menjadi potrait
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Inisialisasi variabel komponen tampilan
        edtUsername = findViewById(R.id.edt_Username);
        edtPassword = findViewById(R.id.edt_Password);
        btnLogin = findViewById(R.id.btn_Login);
        txtRegister = findViewById(R.id.txtRegister);

        // Inisialisasi custom class SessionManager dengan context dari LoginActivity
        sessionManager = new SessionManager(getApplicationContext());

        // Cek jika user sudah login
        if (sessionManager.isLoggedIn()) {
            // Jika user sudah login, maka akan diarahkan ke MainActivity
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
            finish();
        }

        // Set listener ketika button login di klik
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Ambil username dan password dari EditText
                String username = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                // Validasi jika username atau password kosong
                if (username.trim().isEmpty() || password.trim().isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please enter your credentials.", Toast.LENGTH_SHORT).show();
                // Validasi jika username atau password salah
                } else if (!username.equals(DEFAULT_USERNAME) && !password.equals(DEFAULT_PASSWORD)) {
                    Toast.makeText(LoginActivity.this, "Invalid username or password.", Toast.LENGTH_SHORT).show();
                } else if (!username.equals(DEFAULT_USERNAME) && password.equals(DEFAULT_PASSWORD)) {
                    Toast.makeText(LoginActivity.this, "Invalid username or password.", Toast.LENGTH_SHORT).show();
                } else if (username.equals(DEFAULT_USERNAME) && !password.equals(DEFAULT_PASSWORD)) {
                    Toast.makeText(LoginActivity.this, "Invalid username or password.", Toast.LENGTH_SHORT).show();
                // Jika username dan password benar, maka membuat session login dan diarahkan ke MainActivity
                } else {
                    sessionManager.createLoginSession(username, password);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        // Set listener ketika text Register di klik
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

    // Override method onBackPressed, jika tombol back di tekan maka akan dipanggil
    // method finishAffinity() dan mengakhiri activity sekaligus menghapus semua activity
    // di atasnya pada stack. Hal ini akan menghindari pengguna untuk kembali ke activity
    // sebelumnya yang mungkin memerlukan autentikasi ulang.
    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}