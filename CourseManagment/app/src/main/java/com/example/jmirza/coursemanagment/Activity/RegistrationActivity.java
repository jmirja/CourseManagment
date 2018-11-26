package com.example.jmirza.coursemanagment.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.jmirza.coursemanagment.Database.StudentDatabaseManager;
import com.example.jmirza.coursemanagment.Database.TeacherDatabaseManager;
import com.example.jmirza.coursemanagment.Model.Student;
import com.example.jmirza.coursemanagment.Model.Teacher;
import com.example.jmirza.coursemanagment.R;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {
    StudentDatabaseManager studentDatabaseManager;
    TeacherDatabaseManager teacherDatabaseManager;
    Student student;
    Teacher teacher;
    EditText name,dept,pass,email,contact;
    Button save;
    RadioGroup type;
    String userType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.registration_page );
        setTitle( "Sign up" );
        initialization();
        setOnclickAction();

    }

    public void initialization(){
        name=findViewById( R.id.userNameEt );
        dept=findViewById( R.id.departmentEt );
        pass=findViewById( R.id.passEt );
        email=findViewById( R.id.emailEt );
        save=findViewById( R.id.saveBt );
        contact=findViewById( R.id.contactEt );
        type=findViewById( R.id.userType );
        studentDatabaseManager=new StudentDatabaseManager( this );
        teacherDatabaseManager=new TeacherDatabaseManager(this);
    }

    public void setOnclickAction(){
        save.setOnClickListener(this);
    }

    public boolean isEmpty(EditText text){
        CharSequence t=text.getText().toString();
        return TextUtils.isEmpty( t );
    }
    public boolean isEmail(EditText text){
        CharSequence t=text.getText().toString();
        return (!TextUtils.isEmpty( t) && Patterns.EMAIL_ADDRESS.matcher( t).matches());
    }

    public boolean checkDataEntered() {
        boolean result = false;
        if (isEmpty(name)) {
            result = true;
            name.setError("Enter your name! ");
        }
        if ((isEmpty(pass))) {
            result = true;
            Toast t = Toast.makeText(getApplicationContext(), "You must enter password to register! ", Toast.LENGTH_LONG);
            t.show();
        }
        if (isEmpty(dept)) {
            result = true;
            dept.setError("Enter department! ");
        }
        if (isEmail(email) == false) {
            result = true;
            email.setError("Enter valid email! ");
        }
        return result;
    }

    @Override
    public void onClick(View v) {

       if(v.getId()==R.id.saveBt){

           if (checkDataEntered()) {

               Toast.makeText(RegistrationActivity.this, "Row inserted unsuccessfully!! ", Toast.LENGTH_LONG).show();

           }else{

               int id=type.getCheckedRadioButtonId();
               RadioButton radioButton=findViewById( id );
               this.userType= radioButton.getText().toString();
               Toast.makeText( this," "+userType+" Database is selected :" ,Toast.LENGTH_LONG ).show();

               String userName = name.getText().toString();
               String deptName = dept.getText().toString();
               String password = pass.getText().toString();
               String contactNumber = contact.getText().toString();
               String emailEt = email.getText().toString();

               if(id==R.id.studentRb){
                   student = new Student(userName, deptName, password, contactNumber, emailEt);
                   long insertRow = studentDatabaseManager.addStudentData(student);
                   if (insertRow>0) {
                       Toast.makeText(RegistrationActivity.this, "Row " + insertRow + " is inserted successfully! ", Toast.LENGTH_LONG).show();
                   }

               }else if(id==R.id.teacherRb){
                    teacher=new Teacher(userName,deptName,password,contactNumber,emailEt);
                    long insertRow=teacherDatabaseManager.addTeacherData(teacher);
                    if(insertRow>0){
                        Toast.makeText(RegistrationActivity.this, "Row " + insertRow + " is inserted successfully! ", Toast.LENGTH_LONG).show();
                    }
               }


           }

       }

    }
}


