package com.hackathon.csi.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {
boolean bt;
    sqllite db=new sqllite(this);
    EditText e3,e4,e5,e6,e7,e9,e10;
    public String str3="",str4="",str5="",str6="",str7="",str9="",str10="",str11="",str12="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        e3=(EditText)findViewById(R.id.editText3);
         e4=(EditText)findViewById(R.id.editText4);
         e5=(EditText)findViewById(R.id.editText5);
         e6=(EditText)findViewById(R.id.editText6);
         e7=(EditText)findViewById(R.id.editText7);
         e9=(EditText)findViewById(R.id.editText9);
         e10=(EditText)findViewById(R.id.editText10);
    }
    public void data(View v)
    {
       str3=e3.getText().toString();
        str4=e4.getText().toString();
        str5=e5.getText().toString();
        str6=e6.getText().toString();
        str7=e7.getText().toString();
        str10=e10.getText().toString();
        str9=e9.getText().toString();
        str12=str10;
        str11=str9;
        bt = db.insertdata(str3, str4, str5,str6,str7,str9,str10 );
        if(bt==true)
        {
            MainActivity obj=new MainActivity();
            obj.i++;
            sqllite db = new sqllite(getBaseContext());
             Intent it=new Intent(this,MainActivity.class);
             it.putExtra("Email11",str11);
             it.putExtra("Password11",str12);
             this.finish();
             startActivity(it);
        }
        else
        {
            Toast.makeText(this,"Data Not Inserted",Toast.LENGTH_SHORT).show();
        }

    }
}
