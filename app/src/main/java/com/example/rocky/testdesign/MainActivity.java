package com.example.rocky.testdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int xxx = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btn_drawer(View view){
        xxx = 500;
        Intent intent = new Intent(MainActivity.this,DrawerActivity.class);
        startActivity(intent);
    }
    public void btn_hello(View view){
        Toast.makeText(MainActivity.this, "value:"+xxx, Toast.LENGTH_SHORT).show();
    }
    public void btn_recycle(View view){
        Intent intent = new Intent(MainActivity.this,RecyclerViewActivity.class);
        startActivity(intent);
    }

}
