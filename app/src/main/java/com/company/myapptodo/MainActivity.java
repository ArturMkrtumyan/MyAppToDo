package com.company.myapptodo;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.add_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        TextView textViewName = findViewById(R.id.id_text_name);
        TextView textViewDecription = findViewById(R.id.id_text_description);
        ImageView imageView = findViewById(R.id.id_image);
        View view = findViewById(R.id.color_btn);
        Intent data = getIntent();
        String name = data.getStringExtra("name");
        textViewName.setText(name);
        String description = data.getStringExtra("description");
        textViewDecription.setText(description);
        Uri uri = data.getData();
        if (uri != null) {
            imageView.setImageURI(uri);
        }
        if (data.getBooleanExtra("high", false)) {
            view.setBackground(getDrawable((R.drawable.red)));
        } else if (data.getBooleanExtra("medium", false)) {
            view.setBackground(getDrawable((R.drawable.yelow)));
        } else if (data.getBooleanExtra("low", false)) {
            view.setBackground(getDrawable((R.drawable.green)));
        }
    }
}
