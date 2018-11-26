package com.example.jmirza.coursemanagment.Activity;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.jmirza.coursemanagment.Database.DatabaseHelper;
import com.example.jmirza.coursemanagment.R;

public class StudentHomeActivity extends AppCompatActivity {
    CheckBox chek1,chek2,chek3,chek4;
    Button addBTN;
    TextView textView;
    SQLiteDatabase db;
    Context context;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.home_student);
        addListenerOnButton();
    }
    public void addListenerOnButton() {

        chek1 = findViewById( R.id.javaBox);
        chek2 = findViewById(R.id.pythonBox);
        chek3 = findViewById(R.id.algoBox);
        chek4 = findViewById(R.id.dataBasebox);
        addBTN = findViewById( R.id.addBt);
        textView= findViewById( R.id.nameTv );



        addBTN.setOnClickListener(new View.OnClickListener() {

            //Run when button is clicked
            @Override
            public void onClick(View v) {
                if(chek1.isChecked()){
                    db.execSQL( "UPDATE student set course= "+chek1.getText().toString()+ " where name= " +textView.getText().toString());
                }
                //String chek5=chek1.getText().toString();
                //ArrayList <String> list=new ArrayList();

                // textView.setText( chek5 );
                /*StringBuffer result = new StringBuffer();
                result.append("C Programming : ").append(chek1.isChecked());
                result.append("\nJava : ").append(chek2.isChecked());
                result.append("\nAlgorithm :").append(chek3.isChecked());
                result.append("\nDatabase :").append(chek4.isChecked());*/


            }
        });

    }
    public void checkBoxMethod(){

    }
}
