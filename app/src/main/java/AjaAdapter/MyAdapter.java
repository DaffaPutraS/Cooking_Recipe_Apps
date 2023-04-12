package AjaAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookingrecipe.AjaActivity.DetailActivity;
import com.example.cookingrecipe.R;

import java.util.List;

import AjaClassGetSet.DataClass;

// Adapter untuk menampilkan data dalam Recyclerview
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<DataClass> dataList;

    // Method untuk mengatur list data pada saat pencarian
    public void setSearchList(List<DataClass> dataSearchList) {
        this.dataList = dataSearchList;
        notifyDataSetChanged();
    }

    // Konstruktor
    public MyAdapter(Context context, List<DataClass> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    // Method yang memanggil tampilan layout item
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Menampilkan layout item dengan inflate
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_recycleview, parent, false);
        return new MyViewHolder(view);
    }

    // Method untuk menampilkan data pada setiap item
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        // Menampilkan gambar dan judul pada setiap item sesuai dengan yang ada pada template
        holder.recyclercardimg.setImageResource(dataList.get(position).getDataImage());
        holder.recyclercardtitle.setText(dataList.get(position).getDataTitle());

        // Memberikan action pada setiap item ketika di klik
        holder.recyclercardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Mengarahkan ke DetailActivity dengan membawa data gambar, judul, dan deskripsi
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("Image", dataList.get(holder.getAdapterPosition()).getDataImage());
                intent.putExtra("Title", dataList.get(holder.getAdapterPosition()).getDataTitle());
                intent.putExtra("Description", dataList.get(holder.getAdapterPosition()).getDataDesc());
                intent.putExtra("Description2", dataList.get(holder.getAdapterPosition()).getDataDesc2());

                context.startActivity(intent);
            }
        });
    }

    // Method yang menghitung jumlah item yang akan ditampilkan
    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

// Class untuk menginialisasi dan menangani tampilan setiap item pada Recyclerview sesuai template
class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView recyclercardimg;
    TextView recyclercardtitle, recyclerviewdesc;
    CardView recyclercardview;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        recyclercardimg = itemView.findViewById(R.id.recyclercardimg);
        recyclercardtitle = itemView.findViewById(R.id.recyclercardtitle);
        recyclercardview = itemView.findViewById(R.id.recyclerview);
    }
}