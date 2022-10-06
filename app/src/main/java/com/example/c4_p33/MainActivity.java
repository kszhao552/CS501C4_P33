package com.example.c4_p33;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edt;
    private Button btn;
    private TextView txt;
    static MainActivity instance;
    static String in = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt = (EditText) findViewById(R.id.editTextTextPersonName);
        btn = (Button) findViewById(R.id.button2);
        txt = (TextView) findViewById(R.id.textView);
        instance = this;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change();
            }
        });

        edt.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                shift (charSequence.toString());
                in = charSequence.toString();
            }
            @Override public void afterTextChanged(Editable editable) {}
        });
    }

    public void change(){
        Intent intent = new Intent(this, ShiftActivity.class);
        this.startActivity(intent);
    }

    public void shift(String s){
        String out = "";
        for (int j = 0; j < s.length(); j++){
            char c = (char) (s.charAt(j) + ShiftActivity.shift);
            if (c > 'z'){
                c = (char) (c-26);
            }
            out += c;
        }

        txt.setText(out);

    }
}