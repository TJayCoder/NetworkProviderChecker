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

public class TellNumebr extends AppCompatActivity {


    DBHepler dbHepler;
    SQLiteDatabase sqLiteDatabase;

    //https://mybroadband.co.za/news/cellular/283477-the-difference-between-082-072-and-062-cellphone-numbers-in-south-africa.html

    Button check;
    EditText numbersInput;
    TextView resultst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tel_number);


        dbHepler = new DBHepler(this);
        // SqLite database handler

        check = findViewById(R.id.btntelCheckNetwork);
        numbersInput = findViewById(R.id.etTellphone);
        resultst = findViewById(R.id.lbltelresults);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phnNumber = numbersInput.getText().toString().trim();


                ShowSingleRecordInTextView(phnNumber);
            }
        });


    }

    public void ShowSingleRecordInTextView(String numberphn) {
        sqLiteDatabase = dbHepler.getWritableDatabase();


        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Area_Operator  WHERE Area_Codes = ?", new String[]{numberphn});

        if (cursor.moveToFirst()) {

            //    Toast.makeText(MobileNumber.this,numberphn, Toast.LENGTH_SHORT).show();

            do {


                // Prompt user to enter credentials
                new AlertDialog.Builder(TellNumebr.this)
                        .setTitle("MOBILE NETWORK FOR THE TELEPHONE NUMBERS BELOW TO ONE OF THE FOLLOWING PROVINCE: ")
                        .setMessage(cursor.getString(cursor.getColumnIndex("Area")))
                        .setPositiveButton("Continue", null)
                        .show();

                resultst.setText("MOBILE NETWORK FOR THE TELEPHONE NUMBERS: " + cursor.getString(cursor.getColumnIndex("Area")));


            } while (cursor.moveToNext());

            cursor.close();

        }else{

            // Prompt user to enter credentials
            new AlertDialog.Builder(TellNumebr.this)
                    .setTitle("Warning")
                    .setMessage("Please provide the first two numbers of your Telephone number. \n\n e.g 05")
                    .setPositiveButton("Try Again", null)
                    .show();

        }

    }



}