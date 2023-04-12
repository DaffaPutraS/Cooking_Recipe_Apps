package com.example.cookingrecipe.AjaFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.cookingrecipe.AjaProfile.About;
import com.example.cookingrecipe.AjaProfile.ContactUs;
import com.example.cookingrecipe.AjaProfile.FAQ;
import com.example.cookingrecipe.AjaProfile.PrivacyPolicy;
import com.example.cookingrecipe.AjaProfile.Version;
import com.example.cookingrecipe.R;

import java.util.HashMap;

import AjaManager.SessionManager;

public class ProfileFragment extends Fragment {
    // Deklarasi variabel
    TextView txt_Username;
    Button btnLogout, btnAboutUs, btnContactUs, btnFaq, btnPolicy, btnVersion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Mencari tampilan berdasarkan ID di layout
        txt_Username = view.findViewById(R.id.txt_Username);
        btnLogout = view.findViewById(R.id.btn_Logout);
        btnAboutUs = view.findViewById(R.id.btnAboutUs);
        btnContactUs = view.findViewById(R.id.btnContactUs);
        btnFaq = view.findViewById(R.id.btnFaq);
        btnPolicy = view.findViewById(R.id.btnPolicy);
        btnVersion = view.findViewById(R.id.btnVersion);

        // Membuat objek sessionManager dari kelas SessionManager
        SessionManager sessionManager = new SessionManager(getActivity());

        // Jika belum login, logout user
        if (!sessionManager.isLoggedIn()) {
            sessionManager.logoutUser();
        }

        // Mendapatkan detail user dari session
        HashMap<String, String> user = sessionManager.getUserDetails();
        String username = user.get("username");

        // Menampilkan username pada TextView
        txt_Username.setText(username);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lakukan logout user
                sessionManager.logoutUser();
            }
        });

        btnAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), About.class);
                startActivity(intent);
            }
        });

        btnPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PrivacyPolicy.class);
                startActivity(intent);
            }
        });

        btnFaq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FAQ.class);
                startActivity(intent);
            }
        });

        btnContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ContactUs.class);
                startActivity(intent);
            }
        });

        btnVersion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Version.class);
                startActivity(intent);
            }
        });


        return view;
    }
}