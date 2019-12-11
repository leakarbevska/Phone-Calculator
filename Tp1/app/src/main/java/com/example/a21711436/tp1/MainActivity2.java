package com.example.a21711436.tp1;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity2 extends Activity {
    TextView text_int1, text_int2, text_result;
    EditText edit_int1, edit_int2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        text_int1 = (TextView) findViewById(R.id.text_int1);
        text_int2 = (TextView) findViewById(R.id.text_int2);

        edit_int1 = (EditText) findViewById(R.id.text_int1);
        edit_int2 = (EditText) findViewById(R.id.text_int2);

        text_result  = (TextView) findViewById(R.id.text_resultat);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            text_int1.setText(String.valueOf(extras.getInt("entier1")));
            text_int2.setText(String.valueOf(extras.getInt("entier2")));
        }
    }

    /*--------- BUTTONS ACTION ---------*/
    public void calculate(View v){
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        String result = "";

        if(!MainActivity.checkIfNull(text_int1, text_int2, edit_int1, edit_int2) && selectedId != -1){
            int int1 = Integer.parseInt(text_int1.getText().toString());
            int int2 = Integer.parseInt(text_int2.getText().toString());

            switch (selectedId) {
                case R.id.rb_plus:
                    result = String.valueOf(MainActivity.add(int1, int2));
                    break;
                case R.id.rb_minus:
                    result = String.valueOf(MainActivity.substract(int1, int2));
                    break;
                case R.id.rb_mult:
                    result = String.valueOf(MainActivity.multiply(int1, int2));
                    break;
                case R.id.rb_div:
                    if(!MainActivity.checkIfDivisionWithZero(text_int2, edit_int2)){
                        result = String.valueOf(MainActivity.divide(int1, int2)); }
                    break;
            }
        }
        text_result.setText("Resultat : "+result);
    }

    public void makeDelete(View v){
        MainActivity.delete(text_int1, text_int2);
    }
}
