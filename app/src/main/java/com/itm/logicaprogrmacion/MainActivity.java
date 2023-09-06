package com.itm.logicaprogrmacion;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText from;
    EditText  to;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    TextView text;
    List<Button> buttonList = new ArrayList<>();

    int color1 = 0xff7720BB;
    int color2 = 0xff029E52;
    int status ;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        from = (EditText)  findViewById(R.id.editTextTextPersonName);
        to = (EditText)  findViewById(R.id.editTextTextPersonName2);
        one  = findViewById(R.id.button7);
        two  = findViewById(R.id.button17);
        three  = findViewById(R.id.button19);
        four  = findViewById(R.id.button18);
        five  = findViewById(R.id.button20);

        text = findViewById(R.id.textView);
        status = 1;
        text.setMovementMethod(new ScrollingMovementMethod());
        buttonList.add(one);
        buttonList.add(two);
        buttonList.add(three);
        buttonList.add(four);
        buttonList.add(five);
        changeStatus(status);
        one.setBackgroundColor(color2);
    }

    public boolean newStatus(int status) {
        changeStatus(status);
        buttonList.get(status - 1).setBackgroundColor(color2);
        return  true;
    }

    public void pressOne(View v) {newStatus(1);}
    public void pressTwo(View v) {newStatus(2);}
    public void pressThree(View v) {newStatus(3);}
    public void pressFour(View v) {newStatus(4);}
    public void pressFive(View v) {newStatus(5);}


    public void changeColors() {
        for(Button buton :buttonList) {
            buton.setBackgroundColor(color1);
        }
    }

    public void press(View v) {

        try {
            String initText = "";
            int init = Integer.parseInt(from.getText().toString());
            int end = Integer.parseInt(to.getText().toString());

            if (status == 1 || status == 2 || status == 3) {
                pressOneToThree(init, end);
            } else {
                pressFourAndFive(init, end);
            }
        } catch (Exception e) {
            text.setText("Introduzca valores numericos validos");
            text.setTextColor(Color.RED);
        }finally {
        }
    }

    public void pressOneToThree(int init, int end) {

            String initText = "";
            if (init < end) {
                while (init != end + 1 ) {
                    initText = initText +" " + String.valueOf(init) + " ";
                    init++;
                }
                text.setTextColor(Color.WHITE);
                text.setText(initText);
            } else {
                text.setTextColor(Color.YELLOW);
                text.setText("El valor inicial no puede ser mayor al final");
            }
    }

    public void pressFourAndFive(int init, int end) {
        int value = 0;
        final int saveInit = init;

        while (init != end + 1) {
            value += init;
            init++;
        }
        text.setText("La suma de todos los numeros desde "+String.valueOf(saveInit)+" hasta "+String.valueOf(end)+ " es "+ String.valueOf(value));
    }

    public boolean changeStatus(int status) {
    this.status = status;
        changeColors();

        switch (status) {
            case 1:
                from.setEnabled(false);
                from.setText("1");
                to.setEnabled(false);
                to.setText("100");
                break;
            case 2:
            case 4:
                from.setEnabled(false);
                from.setText("1");
                to.setEnabled(true);
                to.setText("");
                break;
            case 5:
            case 3:
                from.setEnabled(true);
                from.setText("");
                to.setEnabled(true);
                to.setText("");
                break;
        }
            return true;
    }
}