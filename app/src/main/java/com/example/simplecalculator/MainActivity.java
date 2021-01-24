package com.example.simplecalculator;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnDecimal, btnActionDivide, btnActionMultiply,
            btnActionSubstract, btnActionAdd, btnActionEnter, btnClear;
    TextView txtDisplayText;

    int firstNumber, secondNumber;
    String actionType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       final Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        btn0 = findViewById(R.id.btn_0);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);
        btnDecimal = findViewById(R.id.btn_dot);
        btnActionDivide = findViewById(R.id.btn_divide);
        btnActionMultiply = findViewById(R.id.btn_multiply);
        btnActionSubstract = findViewById(R.id.btn_substraction);
        btnActionAdd = findViewById(R.id.btn_addition);
        btnActionEnter = findViewById(R.id.btn_enter);

        txtDisplayText = findViewById(R.id.txt_out);
        btnClear = findViewById(R.id.btn_cut);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                long[] pattern = {0, 100, 1000, 300, 200, 100, 500, 200, 100};

                vibe.vibrate(30);
                txtDisplayText.setText(txtDisplayText.getText()+"1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(30);
                txtDisplayText.setText(txtDisplayText.getText()+"2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(30);
                txtDisplayText.setText(txtDisplayText.getText()+"3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(30);
                txtDisplayText.setText(txtDisplayText.getText()+"4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(30);
                txtDisplayText.setText(txtDisplayText.getText()+"5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(30);
                txtDisplayText.setText(txtDisplayText.getText()+"6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(30);
                txtDisplayText.setText(txtDisplayText.getText()+"7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(30);
                txtDisplayText.setText(txtDisplayText.getText()+"8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(30);
                txtDisplayText.setText(txtDisplayText.getText()+"9");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(30);
                txtDisplayText.setText(txtDisplayText.getText()+"0");
            }
        });

        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(30);
                txtDisplayText.setText(txtDisplayText.getText()+".");
            }
        });

        btnActionMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(30);
                txtDisplayText.setText(txtDisplayText.getText()+"x");
            }
        });

        btnActionAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(30);
                txtDisplayText.setText(txtDisplayText.getText()+"+");
            }
        });

        btnActionSubstract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(30);
                txtDisplayText.setText(txtDisplayText.getText()+"-");
            }
        });

        btnActionDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(30);
                txtDisplayText.setText(txtDisplayText.getText()+"/");
            }
        });

        btnActionEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(30);
                String number=txtDisplayText.getText().toString();
                if(number.contains("/")) {
                    String[] splitNumber = number.split("/");//+ is escape char
                    double firstNumber = (Double.parseDouble(splitNumber[0]));
                    double secondNumber = (Double.parseDouble(splitNumber[1]));
                    txtDisplayText.setText((String.valueOf(divide(firstNumber,secondNumber))));
                } else if(number.contains("x")) {
                    String[] splitNumber = number.split("x");//+ is escape char
                    double firstNumber = (Double.parseDouble(splitNumber[0]));
                    double secondNumber = (Double.parseDouble(splitNumber[1]));
                    txtDisplayText.setText(String.valueOf(multiply(firstNumber,secondNumber)));
                }  else if(number.contains("-")) {
                    String[] splitNumber = number.split("-");//+ is escape char
                    double firstNumber = (Double.parseDouble(splitNumber[0]));
                    double secondNumber = (Double.parseDouble(splitNumber[1]));
                    txtDisplayText.setText(String.valueOf(substract(firstNumber,secondNumber)));
                } else if(number.contains("+")) {
                    String[] splitNumber = number.split("\\+");//+ is escape char
                    double firstNumber = (Double.parseDouble(splitNumber[0]));
                    double secondNumber = (Double.parseDouble(splitNumber[1]));
                    txtDisplayText.setText(String.valueOf(add(firstNumber,secondNumber)));
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // txtDisplayText.setText("");
                vibe.vibrate(30);
                if(txtDisplayText.getText().toString().trim().length() > 0) {
                    String result = txtDisplayText.getText().toString().substring(0,txtDisplayText.getText().toString().length() - 1);
                    txtDisplayText.setText(result);
                    txtDisplayText.setSelected(true);
                }
            }
        });
    }


    double add(double a, double b) {
        return a + b;
    }

    double substract(double a, double b) {
        return a - b;
    }

    double divide(double a, double b) {
        return a / b;
    }

    double multiply(double a, double b) {
        return a*b;
    }
}