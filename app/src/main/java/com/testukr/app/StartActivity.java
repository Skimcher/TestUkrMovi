package com.testukr.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button btn1 = findViewById(R.id.btnVariant1);
        Button btn2 = findViewById(R.id.btnVariant2);
        Button btn3 = findViewById(R.id.btnVariant3);

        btn1.setOnClickListener(v -> openVariant(1));
        btn2.setOnClickListener(v -> openVariant(2));
        btn3.setOnClickListener(v -> openVariant(3));
    }

    private void openVariant(int variant) {
        Intent intent = new Intent(this, VariantActivity.class);
        intent.putExtra("variant", variant);
        startActivity(intent);
    }
}
