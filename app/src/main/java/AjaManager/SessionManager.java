package AjaManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.cookingrecipe.AjaActivity.LoginActivity;

import java.util.HashMap;

public class SessionManager {

    // Deklarasi variabel SharedPreferences dan Editor
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    // Key untuk menyimpan status login
    private static final String IS_LOGIN = "IsLoggedIn";


    // Konstruktor
    public SessionManager(Context context) {
        this.context = context;

        // Membuat file SharedPreference bernama "loginPrefs" dengan mode private
        sharedPreferences = context.getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }


    // Method untuk menyimpan status login dan detail pengguna
    public void createLoginSession(String username, String password) {
        editor.putBoolean(IS_LOGIN, true);
        editor.putString("username", username);
        editor.putString("password", password);
        editor.commit();
    }

    // Method untuk mengecek apakah pengguna sudah login atau belum
    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(IS_LOGIN, false);
    }

    // Method untuk mengecek apakah pengguna sudah login, jika belum maka redirect ke halaman login
    public void checkLogin() {
        if (!this.isLoggedIn()) {
            Intent i = new Intent(context, LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }

    // Method untuk mendapatkan detail pengguna
    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<String, String>();
        user.put("username", sharedPreferences.getString("username", null));
        user.put("password", sharedPreferences.getString("password", null));
        return user;
    }

    // Method untuk logout pengguna
    public void logoutUser() {
        editor.clear();
        editor.commit();
        Intent i = new Intent(context, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }

}
