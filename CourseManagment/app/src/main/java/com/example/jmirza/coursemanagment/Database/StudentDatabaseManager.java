package com.example.jmirza.coursemanagment.Database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.jmirza.coursemanagment.Model.Student;

public class StudentDatabaseManager  {
    private DatabaseHelper databaseHelper;

    public StudentDatabaseManager(Context context) {
        databaseHelper=new DatabaseHelper( context );
    }
    public long addStudentData(Student student){
        SQLiteDatabase sqLiteDatabase=databaseHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put( DatabaseHelper.STUDENT_COLUMN_NAME,student.getStudentName());
        values.put( DatabaseHelper.STUDENT_COLUMN_DEPT_NAME,student.getStudentDept());
        values.put( DatabaseHelper.STUDENT_COLUMN_CONTACT,student.getstudentContactNumber());
        values.put( DatabaseHelper.STUDENT_COLUMN_EMAIL,student.getStudentEmail());
        values.put( DatabaseHelper.STUDENT_COLUMN_PASS,student.getstudentPassword());
        long insertData=sqLiteDatabase.insert( DatabaseHelper.STUDENT_TABLE_NAME,null,values);
        sqLiteDatabase.close();
        return  insertData;
    }

    public Boolean findpassword(String name, String password) {
        SQLiteDatabase sqLiteDatabase=databaseHelper.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM "+DatabaseHelper.STUDENT_TABLE_NAME,null);
        boolean result=false;
        if(cursor.getCount()==0){
           //Toast t=Toast.makeText(StudentDatabaseManager.this,"No data found! ",Toast.LENGTH_LONG);
          // t.show();
        }else{
            while (cursor.moveToNext()){
                String userName=cursor.getString(0);
                String userPass=cursor.getString(4);
                if(userName.equals(name) && userPass.equals(password)){
                    result=true;
                    break;
                }
            }
        }
        return result;
    }
}
