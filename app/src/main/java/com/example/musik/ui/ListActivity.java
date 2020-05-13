package com.example.musik.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musik.api.helper.ServiceGenerator;
import com.example.musik.api.models.Envelope;
import com.example.musik.api.models.Song;
import com.example.musik.api.services.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import com.example.musik.R;
import com.example.musik.adapter.ListAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity extends AppCompatActivity {
    List song = new ArrayList<>();
    ListAdapter listAdapter;
    RecyclerView recyclerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.rv_teams);

        LinearLayoutManager layoutManager = new LinearLayoutManager(ListActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        listAdapter = new ListAdapter(ListActivity.this, song);
        recyclerView.setAdapter(listAdapter);

        loadData();
    }

    public void loadData() {
        ApiInterface apiService = ServiceGenerator.createService(ApiInterface.class, "21c5ff23");
        Call<Envelope<List<Song>>> call = apiService.getLagu("21c5ff23", "jsonpretty", "");
        call.enqueue(new Callback<Envelope<List<Song>>>() {
            @Override
            public void onResponse(Call<Envelope<List<Song>>> call, Response<Envelope<List<Song>>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        listAdapter.setLagu(response.body().getResult());
                    }
                }
            }

            @Override
            public void onFailure(Call<Envelope<List<Song>>> call, Throwable t) {
                Toast.makeText(ListActivity.this, "Gagal Menampilkan Data Lagu", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
