package com.hackathon.csi.myapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.hackathon.csi.myapp.sqllite.COL7;
import static com.hackathon.csi.myapp.sqllite.COL8;

public class MainActivity extends AppCompatActivity {
EditText a1;
EditText a2;
    SQLiteOpenHelper dbhelper;
    SQLiteDatabase db;
String e="",pass="";
    Cursor c;
    static int i=0;
String st1="",st2="",str3="",str4="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a1=(EditText)findViewById(R.id.editText);
        a2=(EditText)findViewById(R.id.editText2);
        dbhelper=new sqllite(this);
        db=dbhelper.getReadableDatabase();

        if(i==1)
        {
        Intent intent4=getIntent();
        Bundle bundle=intent4.getExtras();
        e=bundle.getString("Email11");
        pass=bundle.getString("Password11");}

    }
    public void nextPage(View v)
    {
        st1=a1.getText().toString();
        st2=a2.getText().toString();
        if(e.equals(st1)&&pass.equals(st2))
        {
            Intent it=new Intent(this,secondactivity.class);
            startActivity(it);
        }
        else
        {
            Toast.makeText(this,"Not Found", Toast.LENGTH_SHORT).show();
        }
        /*c=db.rawQuery("SELECT * FROM "+sqllite.TABLE_NAME+" WHERE "+sqllite.COL7+"=? AND "+sqllite.COL8+"=?",new String[]{st1,st2});
        if(c!=null)
        {
            if(c.getCount()>0)
            {
                c.moveToFirst();
                str3=c.getString(c.getColumnIndex("Email"));
                str4=c.getString(c.getColumnIndex("Password"));
                Toast.makeText(this,"Found",Toast.LENGTH_SHORT).show();
                finish();
            }
        }
        else
        {
            Toast.makeText(this,"Not Found",Toast.LENGTH_SHORT).show();
        }*/

    }
    public void Signuppage(View v)
    {
        Intent intent=new Intent(this,signup.class);
        startActivity(intent);
    }
}
