package com.example.a21711436.tp1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends Activity {
    TextView text_Entier1, text_Entier2, text_result;
    EditText edit_entier1, edit_entier2;
    Button button_plus, button_minus, button_mult, button_div, button_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //System.out.print("Hello world");

        button_plus  = (Button) findViewById(R.id.button_plus);
        button_minus = (Button) findViewById(R.id.button_minus);
        button_div   = (Button) findViewById(R.id.button_div);
        button_mult  = (Button) findViewById(R.id.button_mult);
        button_delete= (Button) findViewById(R.id.button_delete);

        text_Entier1 = (TextView) findViewById(R.id.text_Entier1);
        text_Entier2 = (TextView) findViewById(R.id.text_Entier2);

        edit_entier1 = (EditText) findViewById(R.id.text_Entier1);
        edit_entier2 = (EditText) findViewById(R.id.text_Entier2);

        text_result  = (TextView) findViewById(R.id.text_result);
    }


    /*-------------------------- CALCULATION BUTTONS -------------------------*/
    public void fairePlus(View v) {
        String result = "";
        if(!checkIfNull(text_Entier1, text_Entier2, edit_entier1, edit_entier2)){
            int int1 = Integer.parseInt(text_Entier1.getText().toString());
            int int2 = Integer.parseInt(text_Entier2.getText().toString());
            result = String.valueOf(add(int1, int2));
        }
        text_result.setText("Resultat : "+result);
    }

    public void faireMinus(View v){
        String result = "";
        if(!checkIfNull(text_Entier1, text_Entier2, edit_entier1, edit_entier2)){
            int int1 = Integer.parseInt(text_Entier1.getText().toString());
            int int2 = Integer.parseInt(text_Entier2.getText().toString());
            result = String.valueOf(substract(int1, int2));
        }
        text_result.setText("Resultat : "+result);
    }

    public void faireMulti(View v){
        String result = "";
        if(!checkIfNull(text_Entier1, text_Entier2, edit_entier1, edit_entier2)){
            int int1 = Integer.parseInt(text_Entier1.getText().toString());
            int int2 = Integer.parseInt(text_Entier2.getText().toString());
            result = String.valueOf(multiply(int1, int2));
        }
        text_result.setText("Resultat : "+result);
    }

    public void faireDivi(View v){
        String result = "";
        if(!checkIfNull(text_Entier1, text_Entier2, edit_entier1, edit_entier2)){
            int int1 = Integer.parseInt(text_Entier1.getText().toString());
            int int2 = Integer.parseInt(text_Entier2.getText().toString());
            if(!checkIfDivisionWithZero(text_Entier2, edit_entier2)){
                result = String.valueOf(divide(int1, int2));
            }
        }
        text_result.setText("Resultat : "+result);
    }

    /*------------------------------ EXTRA BUTTONS ---------------------------*/
    public void lancerActivity2(View v){
        Intent i = new Intent(MainActivity.this, MainActivity2.class);
        if(!checkIfNull(text_Entier1, text_Entier2, edit_entier1, edit_entier2)){
            int int1 = Integer.parseInt(text_Entier1.getText().toString());
            int int2 = Integer.parseInt(text_Entier2.getText().toString());
            i.putExtra("entier1",int1);
            i.putExtra("entier2",int2);
        }
        startActivity(i);
    }

    public void faireEffacer(View v){
        delete(text_Entier1,text_Entier2);
    }


    /*-------------------------------------- EXTRA -----------------------------------------*/

    public static boolean checkIfDivisionWithZero(TextView text_Entier2, EditText edit_entier2){
        if(Integer.parseInt(text_Entier2.getText().toString()) == 0){
            edit_entier2.setError("No division with 0!");
            return true;
        }
        return false;
    }

    public static boolean checkIfNull(TextView text_Entier1, TextView text_Entier2, EditText edit_entier1, EditText edit_entier2){
        Boolean result = false;

        if(TextUtils.isEmpty(text_Entier1.getText().toString())){
            edit_entier1.setError("Integer is empty!");
            result = true;
        }if(TextUtils.isEmpty(text_Entier2.getText().toString())){
            edit_entier2.setError("Integer is empty!");
            result= true;
        }
        return result;
    }

    public static void delete(TextView text_Entier1, TextView text_Entier2){
        text_Entier1.setText("");
        text_Entier2.setText("");
    }


    /*--------------------- CALCULATIONS ---------------------*/
    public static int add(int a, int b){
        return a+b;
    }

    public static int substract(int a, int b){
        return a-b;
    }

    public static int multiply(int a, int b){
        return a*b;
    }

    public static int divide(int a, int b){
        return a/b;
    }

}
