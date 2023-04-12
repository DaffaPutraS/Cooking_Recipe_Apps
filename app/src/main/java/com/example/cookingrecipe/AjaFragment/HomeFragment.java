package com.example.cookingrecipe.AjaFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cookingrecipe.AjaMenu.Beef_Teriyaki_Activity;
import com.example.cookingrecipe.AjaMenu.Cashew_Curry_Activity;
import com.example.cookingrecipe.AjaMenu.Cauliflower_Bolognese_Activity;
import com.example.cookingrecipe.AjaMenu.Chocolate_Molten_Eggs_Activity;
import com.example.cookingrecipe.AjaMenu.Chocolate_Truffle_Activity;
import com.example.cookingrecipe.AjaMenu.Classic_Meatloaf_Activity;
import com.example.cookingrecipe.AjaMenu.Fish_Tacos_al_Pastor_Activity;
import com.example.cookingrecipe.AjaMenu.Floating_Island_Activity;
import com.example.cookingrecipe.AjaMenu.Grilled_Pizza_Activity;
import com.example.cookingrecipe.AjaMenu.Pan_Seared_Salmon_Activity;
import com.example.cookingrecipe.R;


public class HomeFragment extends Fragment {

    // Deklarasi variable cardview
    CardView salmon, pizza, tacos, moltenEggs, truffle, floating, curry, bolognese, meatloaf;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Inisialisasi cardview dengan id pada layout fragment_home
        salmon = view.findViewById(R.id.cardview_pan_seared_salmon);
        pizza = view.findViewById(R.id.cardview_grilled_pizza);
        tacos = view.findViewById(R.id.cardview_fish_tacos_al_pastor);
        moltenEggs = view.findViewById(R.id.cardview_chocolate_molten_eggs);
        truffle = view.findViewById(R.id.cardview_chocolate_truffle);
        floating = view.findViewById(R.id.cardview_floating_island);
        curry = view.findViewById(R.id.cardview_cashew_curry);
        bolognese = view.findViewById(R.id.cardview_cauliflower_bolognese);
        meatloaf = view.findViewById(R.id.cardview_classic_meatloaf);

        // Set event click pada masing-masing cardview dan buka activity yang terkait
        salmon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Pan_Seared_Salmon_Activity.class);
                startActivity(intent);
            }
        });

        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Grilled_Pizza_Activity.class);
                startActivity(intent);
            }
        });

        tacos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Fish_Tacos_al_Pastor_Activity.class);
                startActivity(intent);
            }
        });

        moltenEggs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Chocolate_Molten_Eggs_Activity.class);
                startActivity(intent);
            }
        });

        truffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Chocolate_Truffle_Activity.class);
                startActivity(intent);
            }
        });

        floating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Floating_Island_Activity.class);
                startActivity(intent);
            }
        });

        curry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Cashew_Curry_Activity.class);
                startActivity(intent);
            }
        });

        bolognese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Cauliflower_Bolognese_Activity.class);
                startActivity(intent);
            }
        });

        meatloaf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Classic_Meatloaf_Activity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}