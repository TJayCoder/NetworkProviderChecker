package com.roamcode.dialcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {


    DBHepler dbHepler;
    SQLiteDatabase sqLiteDatabase;

    //https://mybroadband.co.za/news/cellular/283477-the-difference-between-082-072-and-062-cellphone-numbers-in-south-africa.html

    Button checkmobile,checktel;
    EditText numbersInput;
    TextView resultst;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        checkmobile=findViewById(R.id.btnmobile);
        checktel=findViewById(R.id.btntel);

        checktel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, TellNumebr.class));
            }
        });

        checkmobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (MainMenu.this,MobileNumber.class));
            }
        });









        dbHepler = new DBHepler(this);
        // SqLite database handler

        SharedPreferences wmbPreference = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isFirstRun = wmbPreference.getBoolean("FIRSTRUN", true);
        SharedPreferences.Editor editor = wmbPreference.edit();

        if (isFirstRun) {
            insertAreaValues();
            insertNetworksValues();
            editor.putBoolean("FIRSTRUN", false);
            editor.apply();
        }
    }



        public void insertAreaValues() {

        dbHepler.insertArea("00", "International access code");
        dbHepler.insertArea("01", "Gauteng, Mpumalanga, Limpopo, and part of the North West");
        dbHepler.insertArea("02", "The Western Cape and parts of the Northern Cape");
        dbHepler.insertArea("03", "KwaZulu-Natal");
        dbHepler.insertArea("04", "The Eastern Cape and eastern parts of the Western Cape");
        dbHepler.insertArea("05", "The Free State and parts of the Northern Cape");


    }

    public void insertNetworksValues() {
        //0603 – 0605	MTN
        dbHepler.insertNetwork("0603", "MTN");
        dbHepler.insertNetwork("0604", "MTN");
        dbHepler.insertNetwork("0605", "MTN");

        //0630 – 0635	MTN
        dbHepler.insertNetwork("0630", "MTN");
        dbHepler.insertNetwork("0631", "MTN");
        dbHepler.insertNetwork("0632", "MTN");
        dbHepler.insertNetwork("0633", "MTN");
        dbHepler.insertNetwork("0634", "MTN");
        dbHepler.insertNetwork("0635", "MTN");

        //0638 – 0640	MTN
        dbHepler.insertNetwork("0638", "MTN");
        dbHepler.insertNetwork("0639", "MTN");
        dbHepler.insertNetwork("0640", "MTN");

        //  0655 – 0657	MTN
        dbHepler.insertNetwork("0655", "MTN");
        dbHepler.insertNetwork("0656", "MTN");
        dbHepler.insertNetwork("0657", "MTN");

        //  0710	MTN
        dbHepler.insertNetwork("0710", "MTN");

        //0717 – 0719	MTN
        dbHepler.insertNetwork("0717", "MTN");
        dbHepler.insertNetwork("0718", "MTN");
        dbHepler.insertNetwork("0719", "MTN");

        //073	MTN
        dbHepler.insertNetwork("073", "MTN");

        //078	MTN
        dbHepler.insertNetwork("078", "MTN");

        //0810	MTN
        dbHepler.insertNetwork("0810", "MTN");

        // 083	MTN
        dbHepler.insertNetwork("083", "MTN");

        /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

        //0606 – 0609	Vodacom
        dbHepler.insertNetwork("0606", "Vodacom");
        dbHepler.insertNetwork("0607", "Vodacom");
        dbHepler.insertNetwork("0608", "Vodacom");
        dbHepler.insertNetwork("0609", "Vodacom");

        //0636 – 0637	Vodacom
        dbHepler.insertNetwork("0636", "Vodacom");
        dbHepler.insertNetwork("0637", "Vodacom");

        //0646 – 0649	Vodacom
        dbHepler.insertNetwork("0646", "Vodacom");
        dbHepler.insertNetwork("0647", "Vodacom");
        dbHepler.insertNetwork("0648", "Vodacom");
        dbHepler.insertNetwork("0649", "Vodacom");

        // 0660 – 0665	Vodacom
        dbHepler.insertNetwork("0660", "Vodacom");
        dbHepler.insertNetwork("0661", "Vodacom");
        dbHepler.insertNetwork("0662", "Vodacom");
        dbHepler.insertNetwork("0663", "Vodacom");
        dbHepler.insertNetwork("0664", "Vodacom");
        dbHepler.insertNetwork("0665", "Vodacom");

        //0711 – 0716	Vodacom
        dbHepler.insertNetwork("0711", "Vodacom");
        dbHepler.insertNetwork("0712", "Vodacom");
        dbHepler.insertNetwork("0713", "Vodacom");
        dbHepler.insertNetwork("0714", "Vodacom");
        dbHepler.insertNetwork("0715", "Vodacom");
        dbHepler.insertNetwork("0716", "Vodacom");

        // 072	Vodacom
        dbHepler.insertNetwork("072", "Vodacom");

        //076	Vodacom
        dbHepler.insertNetwork("076", "Vodacom");

        //079	Vodacom
        dbHepler.insertNetwork("079", "Vodacom");

        // 0818 Vodacom
        dbHepler.insertNetwork("0818", "Vodacom");

        // 082 vodacom
        dbHepler.insertNetwork("082", "Vodacom");


        /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/


        //0610 – 0613	Cell C
        dbHepler.insertNetwork("0610", "Cell C");
        dbHepler.insertNetwork("0611", "Cell C");
        dbHepler.insertNetwork("0612", "Cell C");
        dbHepler.insertNetwork("0613", "Cell C");

        //0615-0619	Cell C
        dbHepler.insertNetwork("0615", "Cell C");
        dbHepler.insertNetwork("0616", "Cell C");
        dbHepler.insertNetwork("0617", "Cell C");
        dbHepler.insertNetwork("0618", "Cell C");
        dbHepler.insertNetwork("0619", "Cell C");

        //062	Cell C
        dbHepler.insertNetwork("062", "Cell C");

        //0641 – 0645	Cell C
        dbHepler.insertNetwork("0641", "Cell C");
        dbHepler.insertNetwork("0642", "Cell C");
        dbHepler.insertNetwork("0643", "Cell C");
        dbHepler.insertNetwork("0644", "Cell C");
        dbHepler.insertNetwork("0645", "Cell C");

        //074	Cell C
        dbHepler.insertNetwork("074", "Cell C");

        // 084	Cell C
        dbHepler.insertNetwork("084", "Cell C");


        /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/


        // 0614	Telkom Mobile
        dbHepler.insertNetwork("0614", "Telkom Mobile");

        //0658 – 0659	Telkom Mobile
        dbHepler.insertNetwork("0658", "Telkom Mobile");
        dbHepler.insertNetwork("0659", "Telkom Mobile");

        //  0670 – 0672	Telkom Mobile
        dbHepler.insertNetwork("0670", "Telkom Mobile");
        dbHepler.insertNetwork("0671", "Telkom Mobile");
        dbHepler.insertNetwork("0672", "Telkom Mobile");

        // 0811 – 0815	Telkom Mobile
        dbHepler.insertNetwork("0811", "Telkom Mobile");
        dbHepler.insertNetwork("0812", "Telkom Mobile");
        dbHepler.insertNetwork("0813", "Telkom Mobile");
        dbHepler.insertNetwork("0814", "Telkom Mobile");
        dbHepler.insertNetwork("0815", "Telkom Mobile");

        //0817	Telkom Mobile
        dbHepler.insertNetwork("0817", "Telkom Mobile");


        /*---------------------------------------------------------------------------other Networks--------------------------------------------------------------------------------------------------------------------*/


        //0654	Lycamobile SA
        dbHepler.insertNetwork("0654", "Lycamobile SA");

        //0741	Virgin Mobile
        dbHepler.insertNetwork("0741", "Virgin Mobile");

        //  080	Toll-free, called party pays
        dbHepler.insertNetwork("080", "Toll-free");

        //0816	Rain
        dbHepler.insertNetwork("0816", "Rain");

        // 085	USAL licence holders
        dbHepler.insertNetwork("085", "USAL licence holders");

        //086	Sharecall, MaxiCall, and premium-rate services
        dbHepler.insertNetwork("086", "MaxiCall, and premium-rate services");

        // 0860	Sharecall – Landline callers pay local call, called party pays long distance if applicable
        dbHepler.insertNetwork("0860", "Sharecall – Landline callers pay local call, called party pays long distance if applicable");

        // 0861	MaxiCall – Caller always pay long distance for call even if routed to local office
        dbHepler.insertNetwork("0861", "MaxiCall – Caller always pay long distance for call even if routed to local office");

        //0862 – 9	Premium rate – Caller pays increasing rate linked to last digit
        dbHepler.insertNetwork("0862", "Premium rate – Caller pays increasing rate linked to last digit");
        dbHepler.insertNetwork("0863", "Premium rate – Caller pays increasing rate linked to last digit");
        dbHepler.insertNetwork("0864", "Premium rate – Caller pays increasing rate linked to last digit");
        dbHepler.insertNetwork("0865", "Premium rate – Caller pays increasing rate linked to last digit");
        dbHepler.insertNetwork("0866", "Premium rate – Caller pays increasing rate linked to last digit");
        dbHepler.insertNetwork("0867", "Premium rate – Caller pays increasing rate linked to last digit");
        dbHepler.insertNetwork("0868", "Premium rate – Caller pays increasing rate linked to last digit");
        dbHepler.insertNetwork("0869", "Premium rate – Caller pays increasing rate linked to last digit");

        // 08622	Competition lines
        dbHepler.insertNetwork("08622", "Competition lines");

        // 086294	Competition lines
        dbHepler.insertNetwork("086294", "Competition lines");

        // 08671 – 08674	Information services
        dbHepler.insertNetwork("08671", "Competition lines");
        dbHepler.insertNetwork("08672", "Competition lines");
        dbHepler.insertNetwork("08673", "Competition lines");
        dbHepler.insertNetwork("08674", "Competition lines");

        // 087	Value-added services (including VoIP)
        dbHepler.insertNetwork("087", "Value-added services (including VoIP)");

        // 088	Pagers and Telkom CallAnswer voicemail
        dbHepler.insertNetwork("088", "Pagers and Telkom CallAnswer voicemail");

        // 089	Maxinet, for polls and radio call-in services
        dbHepler.insertNetwork("089", "Maxinet, for polls and radio call-in services");

//        090	Premium-rate services
        dbHepler.insertNetwork("090", "Premium-rate services");

//        0902	Premium-rate adult services
        dbHepler.insertNetwork("0902", "Premium-rate adult services");

//        091	Premium-rate services
        dbHepler.insertNetwork("091", "Premium-rate services");

//        092	Premium-rate services
        dbHepler.insertNetwork("092", "Premium-rate services");

//        096	Machine related services
        dbHepler.insertNetwork("096", "Machine related services");

//        097	Machine related services
        dbHepler.insertNetwork("097", "Machine related services");

//        098	Machine related services
        dbHepler.insertNetwork("098", "Machine related services");

    }
}