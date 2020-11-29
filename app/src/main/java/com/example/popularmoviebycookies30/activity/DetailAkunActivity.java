package com.example.popularmoviebycookies30.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.popularmoviebycookies30.R;

public class DetailAkunActivity extends AppCompatActivity {

    private Button rv_klik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_akun);
            rv_klik = findViewById(R.id.rv_klik);

            rv_klik.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        Toast toast = Toast.makeText(getApplicationContext(), R.string.berhasil_di_simpan, Toast.LENGTH_SHORT);
                        toast.show();
                        finish();
                }
            });

        }

}
