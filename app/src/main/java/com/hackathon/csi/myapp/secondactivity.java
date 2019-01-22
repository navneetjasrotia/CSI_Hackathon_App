package com.hackathon.csi.myapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class secondactivity extends AppCompatActivity {
sqllite db=new sqllite(this);
TextView a11,a12;
    Cursor c=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);
        a11=(TextView)findViewById(R.id.textView13);
        a12=(TextView)findViewById(R.id.textView15);
        c=db.getAllData();
        if(c.getCount()==0)
        {
            Toast.makeText(this,"DataBase is Empty",Toast.LENGTH_SHORT).show();
        }
        else
        {
            while(c.moveToNext())
            {
                a11.setText(c.getString(c.getColumnIndex("ProjectName")));
                a12.setText(c.getString(c.getColumnIndex("TeamMembers")));
            }
        }
    }
    public void applyfunds(View v)
    {
        String url="https://www.business.org/finance/loans/best-crowdfunding-sites-for-startups/";
        Intent it=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(it);
    }
    public void mentors(View v)
    {
        String urli="https://www.indiaaccelerator.co/mentors/";
        Intent it=new Intent(Intent.ACTION_VIEW, Uri.parse(urli));
        startActivity(it);
    }
}
