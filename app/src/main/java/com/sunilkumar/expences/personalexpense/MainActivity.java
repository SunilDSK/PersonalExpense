package com.sunilkumar.expences.personalexpense;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //UI elements
    EditText income[] = new EditText[6];
    EditText expences[] = new EditText[6];
    Button compute;
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

        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeSavings();
            }
        });
    }

    private void computeSavings() {
        //Local integer variables
        int totalincome = 0;
        int totalexpense = 0;

        //Get the total income and total expences
        for (int i = 0; i < 6; i++)
            totalincome += Integer.parseInt(income[i].getText().toString());
        for (int i = 0; i < 6; i++)
            totalexpense += Integer.parseInt(expences[i].getText().toString());

        //compute the savings
        int savings = totalincome - totalexpense;

        //Display the savings value
        answer.setText("Your overall savings is = "+String.valueOf(savings));
    }

}
