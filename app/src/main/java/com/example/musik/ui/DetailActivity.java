package com.example.musik.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.musik.R;

import java.net.URI;

public class DetailActivity extends AppCompatActivity {

    private Button btn, audio;
    TextView artistname, name;
    ImageView imagee;
    DownloadManager download2;
    String artis, namee, image, urlaudio, urldownload;
    public static final String ARTIST_NAME = "artistname";
    public static final String NAME = "name";
    public static final String IMAGE = "image";
    public static final String AUDIO = "audio";
    public static final String DOWNLOAD = "download";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        btn = findViewById(R.id.dwn);
        artistname=findViewById(R.id.artist);
        name=findViewById(R.id.title);
        imagee=findViewById(R.id.imageView2);
        audio=findViewById(R.id.audioo);

        Bundle extras=getIntent().getExtras();
        if(extras!=null){
            artis=extras.getString(ARTIST_NAME);
            namee=extras.getString(NAME);
            image=getIntent().getStringExtra(IMAGE);
            urlaudio=extras.getString(AUDIO);
            urldownload=extras.getString(DOWNLOAD);

        }

        artistname.setText(artis);
        name.setText(namee);
        Glide.with(this).asBitmap().load(image).into(imagee);

        audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebPage(urlaudio);
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailActivity.this, "Musik sedang di download, cek di panel notifikasi", Toast.LENGTH_LONG).show();
                download2 = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse(urldownload);
                DownloadManager.Request request = new DownloadManager.Request(uri);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setTitle(namee);
                Long reference = download2.enqueue(request);
            }
        });
    }

    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        intent.setDataAndType(webpage, "audio/*");
        startActivity(intent);
    }
}

