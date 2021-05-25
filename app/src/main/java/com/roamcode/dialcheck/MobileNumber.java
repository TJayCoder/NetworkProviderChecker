package com.roamcode.dialcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MobileNumber extends AppCompatActivity {

    DBHepler dbHepler;
    SQLiteDatabase sqLiteDatabase;

    //https://mybroadband.co.za/news/cellular/283477-the-difference-between-082-072-and-062-cellphone-numbers-in-south-africa.html

    Button check;
    EditText numbersInput;
    TextView resultst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_number);

        dbHepler = new DBHepler(this);
        // SqLite database handler

        check = findViewById(R.id.btntelCheckNetwork);
        numbersInput = findViewById(R.id.etTellphone);
        resultst = findViewById(R.id.lbltelresults);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phnNumber = numbersInput.getText().toString().trim();
               // String newNumber=phnNumber.substring(0,4);
               // Toast.makeText(MobileNumber.this, newNumber, Toast.LENGTH_SHORT).show();
                ShowSingleRecordInTextView(phnNumber);
            }
        });


    }

    public void ShowSingleRecordInTextView(String numberphn) {
        sqLiteDatabase = dbHepler.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Cellphone_No  WHERE Cell_Codes = ?", new String[]{numberphn});

        if (cursor.moveToFirst()) {

            //    Toast.makeText(MobileNumber.this,numberphn, Toast.LENGTH_SHORT).show();

            do {


                // Prompt user to enter credentials
                new AlertDialog.Builder(MobileNumber.this)
                        .setTitle("MOBILE NETWORK FOR THE FOLLOWING NUMBERS: ")
                        .setMessage(cursor.getString(cursor.getColumnIndex("Networks")))
                        .setPositiveButton("Continue", null)
                        /*   .setNegativeButton("Exit", new AlertDialog.OnClickListener() {

                               @Override
                               public void onClick(DialogInterface dialog, int which) {
                                   finish();


                               }
                           })*/.show();

                resultst.setText("MOBILE NETWORK FOR THE FOLLOWING NUMBERS: " + cursor.getString(cursor.getColumnIndex("Networks")));


            } while (cursor.moveToNext());

            cursor.close();

        }else{
            // Prompt user to enter credentials
            new AlertDialog.Builder(MobileNumber.this)
                    .setTitle("Warning")
                    .setMessage("Please provide the first Three or Four numbers of your Contact Number.\n \n e.g 0711")
                    .setPositiveButton("Try Again", null)
                    .show();
        }

    }



}