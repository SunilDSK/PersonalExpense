package com.sunilkumar.expences.personalexpense;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //UI elements
    EditText income[] = new EditText[6];
    EditText expences[] = new EditText[6];
    Button compute,clear;
    TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //References of the UI elements

            //Incomes
            income[0] = (EditText) findViewById(R.id.income_jan);
            income[1] = (EditText) findViewById(R.id.income_feb);
            income[2] = (EditText) findViewById(R.id.income_mar);
            income[3] = (EditText) findViewById(R.id.income_apr);
            income[4] = (EditText) findViewById(R.id.income_may);
            income[5] = (EditText) findViewById(R.id.income_jun);

            //Expenses
            expences[0] = (EditText) findViewById(R.id.expense_jan);
            expences[1] = (EditText) findViewById(R.id.expense_feb);
            expences[2] = (EditText) findViewById(R.id.expense_mar);
            expences[3] = (EditText) findViewById(R.id.expense_apr);
            expences[4] = (EditText) findViewById(R.id.expense_may);
            expences[5] = (EditText) findViewById(R.id.expense_jun);

            //Answer and compute button
            answer = (TextView) findViewById(R.id.answer);
            compute = (Button) findViewById(R.id.compute);
            clear =(Button) findViewById(R.id.clear);

        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeSavings();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i = 0;i < 6;i++){
                    income[i].setText("");
                    expences[i].setText("");
                }
            }
        });
    }

    private void computeSavings() {
        //Local integer variables
        int totalincome = 0;
        int totalexpense = 0;
        int savings;
        try {
            //Get the total income and total expences
            for (int i = 0; i < 6; i++){
                int inc = Integer.parseInt(income[i].getText().toString());
                int exp = Integer.parseInt(expences[i].getText().toString());
                // Check if the user entered wrong information
                if (exp > inc){
                    Toast.makeText(this,"Wrong information : Expense can not be more than Income.",Toast.LENGTH_LONG).show();
                    inc = 0; exp = 0;
                    break;
                }else{
                totalincome += inc;
                totalexpense += exp;
                }
            }

            if(totalexpense > 0 && totalincome > 0){
                //compute the savings
                savings= totalincome - totalexpense;
                //Display the savings
                answer.setText("Your overall savings is = " + String.valueOf(savings));
            }
        }catch (Exception e){
            Toast.makeText(this,"Something went wrong please make sure that " +
                    "all income and expense fields are entered.",Toast.LENGTH_LONG).show();
        }
    }

}
