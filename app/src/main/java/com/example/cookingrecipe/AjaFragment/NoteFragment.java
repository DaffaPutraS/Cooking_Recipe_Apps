package com.example.cookingrecipe.AjaFragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.cookingrecipe.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class NoteFragment extends Fragment {

    // List untuk menyimpan catatan
    private ArrayList<String> notesList = new ArrayList<String>();
    // ArrayAdapter untuk menampilkan catatan dalam ListView
    private ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note, container, false);

        // Mendapatkan referensi ke ListView dan tombol "Add Note" pada tampilan
        ListView notesListView = view.findViewById(R.id.notesListView);
        Button addNoteButton = view.findViewById(R.id.addNoteButton);

        // Membuat adapter untuk menampilkan catatan dalam ListView
        adapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, notesList);
        notesListView.setAdapter(adapter);

        // Menambahkan event listener untuk tombol "Add Note"
        addNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Membuat dialog untuk menambahkan catatan baru
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("New Note");

                final EditText input = new EditText(view.getContext());
                builder.setView(input);

                // Menambahkan tombol "OK" dan "Cancel" ke dalam dialog
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Menambahkan catatan baru ke dalam ArrayList
                        String noteTitle = input.getText().toString();
                        notesList.add(noteTitle);
                        // Memperbarui tampilan ListView
                        adapter.notifyDataSetChanged();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });

        // Menambahkan event listener untuk item di ListView
        notesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Mendapatkan judul catatan yang dipilih dari posisi item di ListView
                String selectedNoteTitle = (String) parent.getItemAtPosition(position);

                // Membuat dialog untuk menampilkan pilihan edit atau hapus catatan
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle(selectedNoteTitle);
                builder.setItems(new CharSequence[]{"Edit", "Delete"}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                // Aksi Edit
                                showEditNoteDialog(selectedNoteTitle, position);
                                break;
                            case 1:
                                // Aksi Delete
                                deleteNoteDialog(selectedNoteTitle, position);
                                break;
                        }
                    }
                });
                builder.show();
            }
        });

        return view;
    }

    // Event listener untuk ketika aplikasi berada dalam kondisi Pause
    @Override
    public void onPause() {
        super.onPause();

        // Simpan data catatan ke SharedPreferences saat aplikasi di-pause
        SharedPreferences prefs = getActivity().getSharedPreferences("Context", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        // Konversi ArrayList notesList ke JSONArray
        JSONArray jsonArray = new JSONArray(notesList);
        String json = jsonArray.toString();

        // Simpan JSON string ke SharedPreferences
        editor.putString("notesList", json);
        editor.apply();
    }

    @Override
    public void onResume() {
        super.onResume();

        // Ambil data catatan dari SharedPreferences saat aplikasi di-resume
        SharedPreferences prefs = getActivity().getSharedPreferences("Context", MODE_PRIVATE);
        String json = prefs.getString("notesList", null);

        // Jika data tidak kosong, konversi ke JSONArray dan tampilkan di ListView
        if (json != null) {
            try {
                JSONArray jsonArray = new JSONArray(json);
                notesList.clear();
                for (int i = 0; i < jsonArray.length(); i++) {
                    String noteTitle = jsonArray.getString(i);
                    notesList.add(noteTitle);
                }
                adapter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void showEditNoteDialog(String oldNoteTitle, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Edit Note");

        final EditText input = new EditText(getActivity());
        input.setText(oldNoteTitle);
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Menampilkan catatan dari list dan memberitahu adapter untuk update tampilan
                String newNoteTitle = input.getText().toString();
                notesList.set(position, newNoteTitle);
                adapter.notifyDataSetChanged();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    private void deleteNoteDialog(String noteTitle, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Delete Note");
        builder.setMessage("Are you sure you want to delete '" + noteTitle + "'?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Menghapus catatan dari list dan memberitahu adapter untuk update tampilan
                notesList.remove(position);
                adapter.notifyDataSetChanged();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        // Membuat dan menampilkan dialog konfirmasi untuk menghapus catatan
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}