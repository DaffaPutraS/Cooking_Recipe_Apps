package com.example.cookingrecipe.AjaActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.example.cookingrecipe.AjaFragment.FavoriteFragment;
import com.example.cookingrecipe.AjaFragment.FeedsFragment;
import com.example.cookingrecipe.AjaFragment.HomeFragment;
import com.example.cookingrecipe.AjaFragment.NoteFragment;
import com.example.cookingrecipe.AjaFragment.ProfileFragment;
import com.example.cookingrecipe.R;
import com.example.cookingrecipe.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    // inisialisasi variabel binding dengan tipe data ActivityMainBinding
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // mengganti fragment yang ditampilkan dengan HomeFragment
        replaceFragment(new HomeFragment());

        // mengatur orientasi layar menjadi portrait
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){

                case R.id.home: // jika menu home dipilih
                    replaceFragment(new HomeFragment()); // mengganti fragment yang ditampilkan dengan HomeFragment
                    break;
                case R.id.feeds:
                    replaceFragment(new FeedsFragment());
                    break;
                case R.id.note:
                    replaceFragment(new NoteFragment());
                    break;
                case R.id.favorite:
                    replaceFragment(new FavoriteFragment());
                    break;
                case R.id.profile:
                    replaceFragment(new ProfileFragment());
                    break;
            }

            return true;
        });

    }
    // method untuk mengganti fragment yang ditampilkan
    private void replaceFragment(Fragment fragment){
        // mengambil FragmentManager dari activity
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); // memulai transaksi fragment
        fragmentTransaction.replace(R.id.frame_layout,fragment); // mengganti fragment yang ditampilkan pada frame_layout dengan fragment yang di-passing
        fragmentTransaction.commit(); // menyelesaikan transaksi fragment
    }
}