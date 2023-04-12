package com.example.cookingrecipe.AjaActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.cookingrecipe.R;

public class DetailActivity extends AppCompatActivity {

    // inisialisasi variable
    TextView detailDesc, detailDesc2, detailTitle;
    ImageView detailImage, arrowLeft, favorite;

    // method onCreate yang dipanggil saat activity dibuat
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // mematikan landscape mode
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // mengambil referensi view dari layout
        detailDesc = findViewById(R.id.detailDesc);
        detailDesc2 = findViewById(R.id.detailDesc2);
        detailTitle = findViewById(R.id.detailTitle);
        detailImage = findViewById(R.id.detailImage);
        favorite = findViewById(R.id.imageview_favorite_food_detail);
        arrowLeft = findViewById(R.id.imageview_arrow_left_food_detail);

        // mengambil data dari Intent
        Bundle bundle = getIntent().getExtras();

        // memeriksa apakah bundle tidak null
        if (bundle != null){
            detailImage.setImageResource(bundle.getInt("Image"));
            detailTitle.setText(bundle.getString("Title"));
            detailDesc.setText(bundle.getString("Description"));
            detailDesc2.setText(bundle.getString("Description2"));
        }

        // membuat onClickListener untuk arrowLeft yang ketika di-klik akan memanggil onBackPressed()
        arrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // membuat onClickListener untuk favorite yang ketika di-klik
        // akan mengubah background favorite menjadi favorite_hover dan menampilkan pesan "Added to Favorite"
        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favorite.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.favorite_hover));
                Toast.makeText(getApplicationContext(), "Added to Favorite", Toast.LENGTH_SHORT).show();
            }
        });
    }
}