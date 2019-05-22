package com.example.counter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment implements View.OnClickListener {

    Button btnPlus, btnEqual, btnClear;
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;


    public  TextView _screen ;
    public static String display = "" ;
    public static String currentOperator = "";
    public static String result = "";

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        View view = inflater.inflate(R.layout.fragment_second, container, false);
        button0 = view.findViewById(R.id.button0);
        button1 = view.findViewById(R.id.button1);
        button2 = view.findViewById(R.id.button2);
        button3 = view.findViewById(R.id.button3);
        button4 = view.findViewById(R.id.button4);
        button5 = view.findViewById(R.id.button5);
        button6 = view.findViewById(R.id.button6);
        button7 = view.findViewById(R.id.button7);
        button8 = view.findViewById(R.id.button8);
        button9 = view.findViewById(R.id.button9);
        btnPlus = view.findViewById(R.id.btnPlus);
        btnEqual = view.findViewById(R.id.btnEquals);
        btnClear = view.findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        _screen = view.findViewById(R.id.playerTwoTextView);
        _screen.setText(display);



        return view;

    }



    private void updateScreen() {

        _screen.setText(display);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button0:
                display += button0.getText();
                updateScreen();
                break;
            case R.id.button1:
                display += button1.getText();
                updateScreen();
                break;
            case R.id.button2:
                display += button2.getText();
                updateScreen();
                break;
            case R.id.button3:
                display += button3.getText();
                updateScreen();
                break;
            case R.id.button4:
                display += button4.getText();
                updateScreen();
                break;
            case R.id.button5:
                display += button5.getText();
                updateScreen();
                break;
            case R.id.button6:
                display += button6.getText();
                updateScreen();
                break;
            case R.id.button7:
                display += button7.getText();
                updateScreen();
                break;
            case R.id.button8:
                display += button8.getText();
                updateScreen();
                break;
            case R.id.button9:
                display += button9.getText();
                updateScreen();
                break;
            case R.id.btnPlus:
                if (result != "") {
                    String _display = result;
                    clear();
                    display = _display;
                }

                if (currentOperator != "") {
                    Log.d("CalcX", "" + display.charAt(display.length() - 1));
                    if (isOperator(display.charAt(display.length() - 1))) {
                        display = display.replace(display.charAt(display.length() - 1), btnPlus.getText().charAt(0));
                        updateScreen();
                        return;
                    } else {
                        getResult();
                        display = result;
                        result = "";
                    }
                    currentOperator = btnPlus.getText().toString();
                }
                display += btnPlus.getText();
                currentOperator = btnPlus.getText().toString();
                updateScreen();
                break;
            case R.id.btnEquals:
                if (display == "") return;
                if (!getResult()) return;
                _screen.setText(display + "\n" + String.valueOf(result));
                break;
            case R.id.btnClear:
                clear();
                updateScreen();
                break;


        }
    }

    private boolean isOperator(char op) {
        switch (op) {
            case '+':
            case '-':
            case 'x':
            case '÷':
                return true;
            default:
                return false;
        }
    }

    private void clear() {
        display = "";
        currentOperator = "";
        result = "";
    }


    private int operate(String a, String b, String op) {
        switch (op) {
            case "+":
                return Integer.valueOf(a) + Integer.valueOf(b);
            case "-":
                return Integer.valueOf(a) - Integer.valueOf(b);
            case "x":
                return Integer.valueOf(a) * Integer.valueOf(b);
            case "÷":
                try {
                    return Integer.valueOf(a) / Integer.valueOf(b);
                } catch (Exception e) {
                    Log.d("Calc", e.getMessage());
                }
            default:
                return -1;
        }
    }

    private boolean getResult() {
        if (currentOperator == "") return false;
        String[] operation = display.split(Pattern.quote(currentOperator));
        if (operation.length < 2) return false;
        result = String.valueOf(operate(operation[0], operation[1], currentOperator));
        return true;
    }



    }
