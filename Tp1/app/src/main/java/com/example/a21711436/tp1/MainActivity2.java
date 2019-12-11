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
    TextView text_Entier1, text_Entier2, text_result;
    EditText int2_edit, int1_edit;
    Button   button_calculer, button_effacer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        text_Entier1 = (TextView) findViewById(R.id.text_int1);
        text_Entier2 = (TextView) findViewById(R.id.text_int2);

        int1_edit = (EditText) findViewById(R.id.text_int1);
        int2_edit = (EditText) findViewById(R.id.text_int2);

        text_result  = (TextView) findViewById(R.id.text_resultat);

        button_calculer = (Button) findViewById(R.id.button_calculer);
        button_effacer  = (Button) findViewById(R.id.button_effacer);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            text_Entier1.setText(String.valueOf(extras.getInt("entier1")));
            text_Entier2.setText(String.valueOf(extras.getInt("entier2")));
        }
    }

    /*--------- BUTTONS ACTION ---------*/
    public void calculate(View v){
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        String result = "";

        if(!MainActivity.checkIfNull(text_Entier1, text_Entier2, int1_edit, int2_edit) && selectedId != -1){
            int int1 = Integer.parseInt(text_Entier1.getText().toString());
            int int2 = Integer.parseInt(text_Entier2.getText().toString());

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
                    if(!MainActivity.checkIfDivisionWithZero(text_Entier2, int2_edit)){
                        result = String.valueOf(MainActivity.divide(int1, int2));
                    }
                    break;
            }
        }
        text_result.setText("Resultat : "+result);
    }

    public void delete(View v){
        MainActivity.delete(text_Entier1, text_Entier2);
    }
}
