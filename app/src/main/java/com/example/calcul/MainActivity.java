package com.example.calcul;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private double number1=0;
    private double number2=0;
    private String operation="";
    private boolean virgule=false;
    private int vi=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void affiche(){
        TextView affiche=findViewById(R.id.textView2);
        if (!operation.equals("")&&number2!=0)
            affiche.setText(Double.toString(number1)+" "+operation+" "+Double.toString(number2));
        if (!operation.equals("")&&number2==0)
            affiche.setText(Double.toString(number1)+" "+operation);
        if (operation.equals(""))
            affiche.setText(Double.toString(number1));

    }

    public void setOperator(View view){
        view.getId();
        switch (view.getId()){
            case R.id.bDiv:operation="/";
                break;
            case R.id.bMul:operation="*";
                break;
            case R.id.bPlus:operation="+";
                break;
            case R.id.bMinus:operation="-";
                break;
        }
        vi=1;
        virgule=false;
        affiche();
    }

    public void ajouterNbr(View view){
        Button b=findViewById(view.getId());
        if (operation.equals("")) {
            if (virgule){
                vi*=10;
                number1 = number1 +(Double.parseDouble((String) b.getText())/vi);
                System.out.println(Double.parseDouble((String) b.getText())/vi);
            }
            else
                number1 = number1 * 10 + Integer.parseInt((String) b.getText());
        }
        else {
            if (virgule){
                vi*=10;
                number2 = number2 +(Double.parseDouble((String) b.getText())/vi);
            }
            else
                number2 = number2 * 10 + Integer.parseInt((String) b.getText());
        }

        affiche();
    }
    public void setVirgule(View view){
        virgule=true;
    }

    public void calculer(View view){
        TextView affiche=findViewById(R.id.textView2);
        affiche.setText("");
        switch (operation){
            case "+":number1+=number2; break;
            case "-":number1-=number2; break;
            case "/":number1/=number2; break;
            case "*":number1*=number2; break;
        }

        number2=0;
        operation="";
        vi=1;
        virgule=false;
        affiche();
    }

    public void clean(View view){
        TextView affiche=findViewById(R.id.textView2);
        affiche.setText("");
        number1=0;
        number2=0;
        operation="";
        vi=1;
        virgule=false;
    }

}