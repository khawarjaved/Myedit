package com.example.myedit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Sqlview extends AppCompatActivity {
   TextView tvresult;
   SqLiteDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlview);

        tvresult = (TextView)findViewById(R.id.tvresult);
        db=new SqLiteDB(this);
        String data = db.getData();
        tvresult.setText(data);
    }
}
