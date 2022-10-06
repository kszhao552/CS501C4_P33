package com.example.c4_p33;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ShiftActivity extends AppCompatActivity {
    EditText edt;
    Button btn;

    public static int shift = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shift);

        edt = (EditText) findViewById(R.id.editTextNumber);
        btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edt.getText().toString().matches("")) {
                    Toast.makeText(ShiftActivity.this, "Please input a number between 0 and 25", Toast.LENGTH_SHORT).show();
                    return;
                }

                int temp = Integer.valueOf(edt.getText().toString());
                if (temp >= 26){
                    Toast.makeText(ShiftActivity.this, "Please input a number between 0 and 25", Toast.LENGTH_SHORT).show();
                } else {
                    shift = temp;
                    MainActivity.instance.shift(MainActivity.in);
                    finish();
                }
            }
        });
    }
}