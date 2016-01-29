package com.bridgelabz.com.appscreen;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by bridgelabz3 on 28/1/16.
 */
public class Registration extends AppCompatActivity
{
    TextView phone_number,message1,message2;
    EditText code1;
    Spinner spinner;
    Button registration;
    String message;
    String phoneNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        registration=(Button)findViewById(R.id.Registration);
        phone_number=(TextView)findViewById(R.id.phone_number);
        spinner = (Spinner) findViewById(R.id.spinner);

        code1=(EditText)findViewById(R.id.code1);
        message1=(TextView)findViewById(R.id.Message1);
        message2=(TextView)findViewById(R.id.Message2);

        message1.setText("ShoppingPad app will send a one time SMS message to verify your phone number.");
        message2.setText("Please confirm your country code and enter mobile number.");

        Random ran=new Random();
        final int code= (100000 + ran.nextInt(900000));

        message="Your number is verified. You have successfully registered shopping pad app. Your one time number is "+code;

        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        final String phone = tm.getLine1Number();

        phoneNo=phone;

        final ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.country, R.layout.spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setPopupBackgroundResource(R.drawable.spinner_bg);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String item = (String) adapter.getItem(position);
                if (item.equals("India")) {
                    code1.setText("91");
                }
                if (item.equals("Select country")) {
                    code1.setText("");
                }
                if (item.equals("Afghanistan")) {
                    code1.setText("93");
                }
                if (item.equals("Albania")) {
                    code1.setText("355");
                }
                if (item.equals("Algeria")) {
                    code1.setText("213");
                }
                if (item.equals("Argentina")) {
                    code1.setText("54");
                }
                if (item.equals("Australia")) {
                    code1.setText("61");
                }
                if (item.equals("Bangladesh")) {
                    code1.setText("880");
                }
                if (item.equals("Brazil")) {
                    code1.setText("55");
                }
                if (item.equals("Canada")) {
                    code1.setText("1");
                }
                if (item.equals("China")) {
                    code1.setText("86");
                }
                if (item.equals("Cuba")) {
                    code1.setText("53");
                }
                if (item.equals("Egypt")) {
                    code1.setText("20");
                }
                if (item.equals("France")) {
                    code1.setText("33");
                }
                if (item.equals("Germany")) {
                    code1.setText("49");
                }
                if (item.equals("Japan")) {
                    code1.setText("81");
                }
                if (item.equals("Monaco")) {
                    code1.setText("377");
                }
                if (item.equals("Mexico")) {
                    code1.setText("51");
                }
                if (item.equals("Nepal")) {
                    code1.setText("977");
                }
                if (item.equals("United States")) {
                    code1.setText("1");
                }
                if (item.equals("United Kingdom")) {
                    code1.setText("44");
                }
                if (item.equals("Venezuela")) {
                    code1.setText("58");
                }
                if (item.equals("Zambia")) {
                    code1.setText("260");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(phone_number.getText().toString().equals(phone))
                {
                    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext());
                    Toast.makeText(getApplicationContext(),"same",Toast.LENGTH_SHORT).show();
                    SendSMS();
                    mBuilder.setSmallIcon(R.drawable.notification);
                    mBuilder.setContentTitle(phone);
                    mBuilder.setContentText(message);
                    NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                    mNotificationManager.notify(111,mBuilder.build());
                }
                else if (phone_number.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(),"Please enter mobile number",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Enter valid mobile number",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void SendSMS()
    {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
            Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
        }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS failed, please try again.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}