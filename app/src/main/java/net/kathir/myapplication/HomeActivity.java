package net.kathir.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import net.kathir.myapplication.mvpwithDI.MVPMainActivity;

public class HomeActivity extends AppCompatActivity {

    Button mvpRetrofit,mvpDIRetrofit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        mvpDIRetrofit = (Button)findViewById(R.id.mvp_retrofit_di);
        mvpRetrofit = (Button)findViewById(R.id.mvp_retrofit);


        mvpRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        mvpDIRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, MVPMainActivity.class);
                startActivity(intent);
            }
        });
    }
}
