package com.example.myedit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
 EditText editfirstname,editlastname,nameid;
 Button insertbtn,searchbtn,viewbtn,updatebtn,deletebtn;
 SqLiteDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editfirstname =(EditText)findViewById(R.id.editfirstname);
        editlastname =(EditText)findViewById(R.id.editlastname);
        nameid =(EditText)findViewById(R.id.nameid);

        insertbtn=(Button)findViewById(R.id.insertbtn);
        searchbtn=(Button)findViewById(R.id.searchbtn);
        viewbtn=(Button)findViewById(R.id.viewbtn);
        updatebtn=(Button)findViewById(R.id.updatebtn);
        deletebtn=(Button)findViewById(R.id.deletebtn);

        insertbtn.setOnClickListener(this);
        viewbtn.setOnClickListener(this);

        db=new SqLiteDB(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.insertbtn:
                boolean fine=true;

                try {

                String firstname=editfirstname.getText().toString();
                String lastnamae=editlastname.getText().toString();
                db.insertStudent(firstname,lastnamae);
                }
                catch (Exception e)
                {
                    fine = false;
                    String error = e.toString();
                    Dialog d=new Dialog(this);
                    d.setTitle("Sorry");
                    TextView tv=new TextView(this);
                    tv.setText("error");
                    d.setContentView(tv);
                    d.show();
                }finally {
                    if (fine){
                        Dialog d=new Dialog(this);
                        d.setTitle("At least we did it");
                        TextView tv=new TextView(this);
                        tv.setText("Success");
                        d.setContentView(tv);
                        d.show();
                    }
                }
                break;

            case R.id.viewbtn:
                Intent intent=new Intent(getApplicationContext(),Sqlview.class);
                startActivity(intent);


        }
    }
}
