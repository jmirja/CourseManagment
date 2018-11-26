package com.example.jmirza.coursemanagment.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;

import com.example.jmirza.coursemanagment.Database.StudentDatabaseManager;
import com.example.jmirza.coursemanagment.Database.TeacherDatabaseManager;
import com.example.jmirza.coursemanagment.Model.Student;
import com.example.jmirza.coursemanagment.Model.Teacher;
import com.example.jmirza.coursemanagment.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    TextInputEditText userName,pass;
    Button login,reg;
    StudentDatabaseManager studentDatabaseManager;
    TeacherDatabaseManager teacherDatabaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.login_page );
        setTitle( "Login" );
        initializationView();
        clickButton();
        studentDatabaseManager=new StudentDatabaseManager(this);
        teacherDatabaseManager=new TeacherDatabaseManager(this);
    }

    public void initializationView(){
        userName=findViewById( R.id.nameEt );
        pass=findViewById( R.id.passwordEt );
        login=findViewById( R.id.loginBtn );
        reg=findViewById( R.id.regiBtn );

    }
    public boolean checkValidity() {
        View focusView = null;
        boolean cancel = false;
        String name = userName.getText().toString();
        String password = pass.getText().toString();

        if (TextUtils.isEmpty(name)) {
           // focusView=userName;
            cancel = true;
            userName.setError("Enter a valid name");
        } else if (TextUtils.isEmpty(password)) {
            // focusView = pass;
            cancel = true;
            pass.setError("Enter a valid password");
        }
        return cancel;
    }
    public void clickButton(){
        login.setOnClickListener( this );
        reg.setOnClickListener( this );
    }

     @Override
     public void onClick(View v) {
         int id=v.getId();
         String name=userName.getText().toString();
         String password=pass.getText().toString();
         if(id==R.id.loginBtn){

             if(checkValidity()){
                 // Toast.makeText( this,"Please put the value"+name,Toast.LENGTH_LONG ).show();
             }else{
                 Boolean student=studentDatabaseManager.findpassword(name,password);
                 Boolean teacher=teacherDatabaseManager.findpassword(name,password);

                 if(student==true){
                     startActivity( new Intent( LoginActivity.this,StudentHomeActivity.class ) );
                 }else if(teacher==true){
                     startActivity( new Intent( LoginActivity.this,TeacherHomeActivity.class ) );
                 }else {
                     Toast.makeText(getApplicationContext(),"OooPsss!!! username & Password didn't match ",Toast.LENGTH_LONG).show();
                 }
             }
         }else if(id==R.id.regiBtn){
             startActivity( new Intent( LoginActivity.this,RegistrationActivity.class ) );
         }
     }
    
   

}
