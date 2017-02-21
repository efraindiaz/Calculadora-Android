package com.example.android.layout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Numeros
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnPoint;

    //Operadores
    private Button btnPlus, btnMinus, btnX, btnDiv, btnEqual, btnC;

    //Pantalla
    private EditText display;

    //Auxiliares
    private double aux1 = 0, aux2 = 0, resultado = 0;
    private boolean zeroOn = false;
    private int opType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        Toast.makeText(this, ""+resultado, Toast.LENGTH_SHORT).show();
        display = (EditText) findViewById(R.id.editTextDisplay);


        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);
        btn0 = (Button) findViewById(R.id.button0);
        btnPoint = (Button) findViewById(R.id.buttonPoint);

        btnPlus = (Button) findViewById(R.id.buttonPlus);
        btnMinus = (Button) findViewById(R.id.buttonMinus);
        btnX = (Button) findViewById(R.id.buttonX);
        btnDiv = (Button) findViewById(R.id.buttonDiv);
        btnEqual = (Button) findViewById(R.id.buttonEquals);
        btnC = (Button) findViewById(R.id.buttonC);

        //BOTON #1

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInitZero();
                display.append("1");
            }
        });

        //BOTON #2
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInitZero();
                display.append("2");

        }
        });

        //BOTON #3
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInitZero();
                display.append("3");

            }
        });
        //BOTON #4
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInitZero();
                display.append("4");

            }
        });
        //BOTON #5
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInitZero();
                display.append("5");

            }
        });
        //BOTON #6
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInitZero();
                display.append("6");            }
        });
        //BOTON #7
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInitZero();
                display.append("7");            }
        });
        //BOTON #8
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInitZero();
                display.append("8");            }
        });
        //BOTON #9
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInitZero();
                display.append("9");            }
        });
        //BOTON #0
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInitZero();
                display.append("0");
            }
        });

        //BOTON PUNTO

        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!zeroOn){
                    display.append(".");
                    zeroOn = true;
                }
                else{
                    //Toast.makeText(MainActivity.this, "Ya hay un punto", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //Boton SUMA
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opType = 1;
                aux1 = Double.parseDouble(display.getText().toString());
                display.setText("0");
                zeroOn = false;
            }
        });

        //Boton RESTA

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opType = 2;
                aux1 = Double.parseDouble(display.getText().toString());
                display.setText("0");
                zeroOn = false;
            }
        });

        // Boton Multiplicacion
        btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opType = 3;
                aux1 = Double.parseDouble(display.getText().toString());
                display.setText("0");
                zeroOn = false;
            }
        });

        // Boton Division

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opType = 4;
                aux1 = Double.parseDouble(display.getText().toString());
                display.setText("0");
                zeroOn = false;
            }
        });

        //BOTON IGUAL
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aux2 = Double.parseDouble(display.getText().toString());
                switch (opType){
                    //case para suma
                    case 1:{
                        resultado = suma(aux1, aux2);
                        break;
                    }
                    //case para resta
                    case 2:{
                        resultado = resta(aux1, aux2);
                        break;
                    }
                    //case para multiplicacion
                    case 3:{
                        resultado = multiplicacion(aux1, aux2);
                        break;
                    }
                    //caso para division
                    case 4:{
                        resultado = division(aux1, aux2);
                        break;
                    }
                    default:{

                    }

                }

                //display.setText(Double.toString(value));*/

                Intent intentResult = new Intent(MainActivity.this, ResultActivity.class);
                intentResult.putExtra("resultado", resultado);
                startActivity(intentResult);
                //display.setText(""+resultado);
            }
        });

        //BOTON CLEAR
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText("0");
                aux1 = 0;
                aux2 = 0;
                resultado = 0;
                zeroOn = false;
            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        aux1 = 0;
        aux2 = 0;
        display.setText(""+resultado);
        resultado = 0;
    }

    /************** QUITAR CERO INICIAL ****************/
    public void checkInitZero(){
        String num = display.getText().toString();
        double conNum = Double.parseDouble(num);
        if(conNum == 0){
            display.setText("");
        }
        else {

        }
    }

    /**************** FUNCION SUMA *******************/
    public double suma(double val1, double val2){

        double suma = val1 + val2;
        return suma;
    }

    /**************** FUNCION RESTA *******************/
    public double resta(double val1, double val2){
        double resta = val1 - val2;
        return resta;
    }
    /**************** FUNCION MULTIPLICACIÓN *******************/
    public double multiplicacion(double val1, double val2){
        double multi = val1 * val2;
        return multi;
    }
    /**************** FUNCION DIVISIÓN *******************/
    public double division(double val1, double val2){
        double divi = val1/val2;
        return divi;
    }


}
