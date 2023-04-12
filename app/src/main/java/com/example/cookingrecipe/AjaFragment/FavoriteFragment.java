package com.example.cookingrecipe.AjaFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.cookingrecipe.AjaMenu.BBQ_sauce_friedChicken_Activity;
import com.example.cookingrecipe.AjaMenu.BBQ_sauce_prowns_Activity;
import com.example.cookingrecipe.AjaMenu.Beef_Steak_Activity;
import com.example.cookingrecipe.AjaMenu.Beef_Teriyaki_Activity;
import com.example.cookingrecipe.AjaMenu.Chicken_Steak_Activity;
import com.example.cookingrecipe.AjaMenu.Chocolate_Puding_Activity;
import com.example.cookingrecipe.AjaMenu.Ice_Cream_Caramel_Activity;
import com.example.cookingrecipe.AjaMenu.Spagheti_Activity;
import com.example.cookingrecipe.AjaProfile.About;
import com.example.cookingrecipe.R;

public class FavoriteFragment extends Fragment {

    CardView spaghetti, beefSteak, bbqChicken, bbqProwns, puding, caramel, beefTeriyaki, chickenSteak;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // metode onCreate() kosong karena kita tidak membutuhkan implementasi tambahan di sini

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);

        // inisialisasi setiap CardView yang ada pada layout dengan menggunakan id-nya masing-masing
        spaghetti = view.findViewById(R.id.cardview_spagheti);
        beefSteak = view.findViewById(R.id.cardview_beef_steak);
        bbqChicken = view.findViewById(R.id.cardview_bbq_friedchkn);
        bbqProwns = view.findViewById(R.id.cardview_bbq_sauceprowns);
        puding = view.findViewById(R.id.cardview_chocolate_puding);
        caramel = view.findViewById(R.id.cardview_ice_cream_caramel);
        beefTeriyaki = view.findViewById(R.id.cardview_beef_teriyaki);
        chickenSteak = view.findViewById(R.id.cardview_chicken_steak);

        // setiap CardView ketika diklik akan menampilkan activity yang sesuai dengan jenis masakan yang dipilih
        spaghetti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Spagheti_Activity.class);
                startActivity(intent);
            }
        });

        beefSteak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Beef_Steak_Activity.class);
                startActivity(intent);
            }
        });


        bbqChicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), BBQ_sauce_friedChicken_Activity.class);
                startActivity(intent);
            }
        });


        bbqProwns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), BBQ_sauce_prowns_Activity.class);
                startActivity(intent);
            }
        });


        puding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Chocolate_Puding_Activity.class);
                startActivity(intent);
            }
        });


        caramel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Ice_Cream_Caramel_Activity.class);
                startActivity(intent);
            }
        });


        beefTeriyaki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Beef_Teriyaki_Activity.class);
                startActivity(intent);
            }
        });


        chickenSteak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Chicken_Steak_Activity.class);
                startActivity(intent);
            }
        });


        return view;
    }
}