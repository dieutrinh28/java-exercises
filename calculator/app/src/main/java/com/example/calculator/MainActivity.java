package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnDot, btnAC, btnDelete, btnPercent, btnEqual, btnPlus, btnMulti, btnDivide, btnMinus;
    private TextView tvHistory, tvResult;
    private String number = null;

    double firstNumber=0, lastNumber=0;

    String status=null;
    String history, result;

    boolean operator = false;
    boolean isEqual = false;

    String pattern = "###,###.####";
    DecimalFormat decimalFormat = new DecimalFormat(pattern);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = this.findViewById(R.id.btn0);
        btn1 = this.findViewById(R.id.btn1);
        btn2 = this.findViewById(R.id.btn2);
        btn3 = this.findViewById(R.id.btn3);
        btn4 = this.findViewById(R.id.btn4);
        btn5 = this.findViewById(R.id.btn5);
        btn6 = this.findViewById(R.id.btn6);
        btn7 = this.findViewById(R.id.btn7);
        btn8 = this.findViewById(R.id.btn8);
        btn9 = this.findViewById(R.id.btn9);

        btnDot = this.findViewById(R.id.btnDot);
        btnAC = this.findViewById(R.id.btnAC);
        btnDelete = this.findViewById(R.id.btnDelete);
        btnPercent = this.findViewById(R.id.btnPercent);
        btnEqual = this.findViewById(R.id.btnEqual);

        btnPlus = this.findViewById(R.id.btnPlus);
        btnMinus = this.findViewById(R.id.btnMinus);
        btnMulti = this.findViewById(R.id.btnMulti);
        btnDivide = this.findViewById(R.id.btnDivide);

        tvHistory = this.findViewById(R.id.tvHistory);
        tvResult = this.findViewById(R.id.tvResult);

        btn0.setOnClickListener(view -> onNumberClick("0"));
        btn1.setOnClickListener(view -> onNumberClick("1"));
        btn2.setOnClickListener(view -> onNumberClick("2"));
        btn3.setOnClickListener(view -> onNumberClick("3"));
        btn4.setOnClickListener(view -> onNumberClick("4"));
        btn5.setOnClickListener(view -> onNumberClick("5"));
        btn6.setOnClickListener(view -> onNumberClick("6"));
        btn7.setOnClickListener(view -> onNumberClick("7"));
        btn8.setOnClickListener(view -> onNumberClick("8"));
        btn9.setOnClickListener(view -> onNumberClick("9"));

        btnPlus.setOnClickListener(view-> {
            if (isEqual) {
                history=tvResult.getText().toString();
                result=tvResult.getText().toString();
                tvHistory.setText(history + "+");
            } else {
                history=tvHistory.getText().toString();
                result=tvResult.getText().toString();
                tvHistory.setText(history + result +"+");
            }
            if(operator) {
                if (status == "multi") {
                    Multi();
                }
                else {
                    if (status == "divide") {
                        Divide();
                    }
                    else {
                        if (status == "minus") {
                            Minus();
                        }
                        else if (status == "plus"){
                            Plus();
                        }
                    }
                }
            }

            operator = false;
            number=null;
            status="plus";
            isEqual=false;
        });

        btnMinus.setOnClickListener(view-> {

            if (isEqual) {
                history=tvResult.getText().toString();
                result=tvResult.getText().toString();
                tvHistory.setText(history + "-");
            } else {
                history=tvHistory.getText().toString();
                result=tvResult.getText().toString();
                tvHistory.setText(history + result +"-");
            }

            if(operator) {
                if (status == "multi") {
                    Multi();
                }
                else {
                    if (status == "divide") {
                        Divide();
                    }
                    else {
                        if (status == "plus") {
                            Plus();
                        }
                        else if (status == "minus"){
                            Minus();
                        }
                    }
                }
            }

            operator = false;
            number=null;
            status="minus";
            isEqual=false;

        });

        btnMulti.setOnClickListener(view-> {

            if (isEqual) {
                history=tvResult.getText().toString();
                result=tvResult.getText().toString();
                tvHistory.setText(history + "*");
            } else {
                history=tvHistory.getText().toString();
                result=tvResult.getText().toString();
                tvHistory.setText(history + result +"*");
            }

            if(operator) {
                if (status == "minus") {
                    Minus();
                }
                else {
                    if (status == "divide") {
                        Divide();
                    }
                    else {
                        if (status == "plus") {
                            Plus();
                        }
                        else if (status == "multi"){
                            Multi();
                        }
                    }
                }
            }

            operator = false;
            number=null;
            status="multi";
            isEqual=false;
        });

        btnDivide.setOnClickListener(view-> {

            if (isEqual) {
                history=tvResult.getText().toString();
                result=tvResult.getText().toString();
                tvHistory.setText(history + "/");
            } else {
                history=tvHistory.getText().toString();
                result=tvResult.getText().toString();
                tvHistory.setText(history + result +"/");
            }

            if(operator) {
                if (status == "minus") {
                    Minus();
                }
                else {
                    if (status == "multi") {
                        Multi();
                    }
                    else {
                        if (status == "plus") {
                            Plus();
                        }
                        else if (status == "divide"){
                            Divide();
                        }
                    }
                }
            }

            operator = false;
            number=null;
            status="divide";
            isEqual=false;
        });

        btnEqual.setOnClickListener(view-> {

            history=tvHistory.getText().toString();
            result=tvResult.getText().toString();
            tvHistory.setText(history+result);

            if(operator) {
                if (status == "minus") {
                    Minus();
                }
                else {
                    if (status == "multi") {
                        Multi();
                    }
                    else {
                        if (status == "plus") {
                            Plus();
                        }
                        else
                            if (status == "divide")
                            {
                            Divide();
                            }
                            else {
                                firstNumber=Double.parseDouble(tvResult.getText().toString());
                            }
                    }
                }
            }
            operator = false;
            isEqual = true;
        });

        btnAC.setOnClickListener(view -> {
            number=null;
            operator=false;
            tvResult.setText("0");
            tvHistory.setText("");
            firstNumber=0;
            lastNumber=0;
        });

        btnDelete.setOnClickListener(view -> {
            number=number.substring(0, number.length()-1);
            tvResult.setText(number);
        });

        btnDot.setOnClickListener(view -> {
            if(number==null) {
                number="0.";
            }
            else {
                number=number+".";
            }
            tvResult.setText(number);
        });

    }

    public  void onNumberClick (String view) {
        if (number == null) {
            number = view;
        }
        else {
            number = number + view;
        }

        tvResult.setText(number);
        operator = true;
    }

    public  void Minus() {
        if(firstNumber==0){
            firstNumber=Double.parseDouble(tvResult.getText().toString());
        }
        else {
            lastNumber=Double.parseDouble(tvResult.getText().toString());
            firstNumber=firstNumber-lastNumber;
        }
        tvResult.setText(decimalFormat.format(firstNumber));
    }

    public void Plus() {
        lastNumber=Double.parseDouble(tvResult.getText().toString());
        firstNumber=firstNumber+lastNumber;
        tvResult.setText(decimalFormat.format(firstNumber));
    }

    public void Multi() {
        if (firstNumber==0)
        {
            firstNumber=1;
        }
        lastNumber=Double.parseDouble(tvResult.getText().toString());
        firstNumber=firstNumber*lastNumber;
        tvResult.setText(decimalFormat.format(firstNumber));
    }

    public void Divide() {
        if (firstNumber==0)
        {
            lastNumber=Double.parseDouble(tvResult.getText().toString());
            firstNumber=lastNumber;
        }
        else {
            lastNumber=Double.parseDouble(tvResult.getText().toString());
            firstNumber=firstNumber/lastNumber;
        }
        tvResult.setText(decimalFormat.format(firstNumber));
    }




}