package com.sample.demo.ch04zodiac;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnOk;
    private EditText etMonth, etDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewId();

    }

    private void findViewId()
    {
        btnOk = (Button)findViewById(R.id.btnOK);
        btnOk.setOnClickListener(this);
        etMonth = (EditText)findViewById(R.id.etMonth);
        etDay = (EditText)findViewById(R.id.etDay);
    }

    @Override
    public void onClick(View v)
    {
        try {

            int month = Integer.parseInt(etMonth.getText().toString());
            int day = Integer.parseInt(etDay.getText().toString());

            if((month >=1 && month <= 12)&& (day >=1 && day<=31))
            {
                Intent intent = new Intent(MainActivity.this, showActivity.class);
                startActivity(intent);
            }
            else
            {
                etMonth.setText("");
                etMonth.requestFocus();
                etDay.setText("");
                Toast.makeText(MainActivity.this,"Please enter the right date", Toast.LENGTH_SHORT).show();
            }

        }catch (Exception ex)
        {
            Toast.makeText(MainActivity.this,"Please enter DOB",Toast.LENGTH_SHORT).show();
            etMonth.requestFocus();
        }


    }

}
