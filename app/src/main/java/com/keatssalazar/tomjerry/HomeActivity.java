package com.keatssalazar.tomjerry;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity  implements  View.OnClickListener{
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn=findViewById(R.id.btnn);
        btn.setOnClickListener(HomeActivity.this);

    }
    @Override
    public void onClick(View view) {
        startActivity(new Intent(this,MainActivity.class));

    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
