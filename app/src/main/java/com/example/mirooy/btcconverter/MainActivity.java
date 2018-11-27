package com.example.mirooy.btcconverter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText from_curr, to_curr;
    private RadioButton USD_1,USD_2,BTC_1, BTC_2,DOGE_1, DOGE_2;
    private RadioGroup group_1, group_2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        from_curr = (EditText)findViewById(R.id.text_1);
        to_curr = (EditText)findViewById(R.id.text_2);
        USD_1 = (RadioButton)findViewById(R.id.but_1);
        BTC_1= (RadioButton)findViewById(R.id.but_2);
        DOGE_1 = (RadioButton)findViewById(R.id.but_3);
        USD_2 = (RadioButton)findViewById(R.id.but_4);
        BTC_2 = (RadioButton)findViewById(R.id.but_5);
        DOGE_2 = (RadioButton)findViewById(R.id.but_6);
        group_1 = (RadioGroup)findViewById(R.id.rg_1);
        group_2 = (RadioGroup)findViewById(R.id.rg_2);


        from_curr.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 0) {
                    Double doublefromcurr = 0.0;
                    to_curr.setText(Double.toString(doublefromcurr));
                }
                if(charSequence.length() > 0){
                    if (USD_1.isChecked() && USD_2.isChecked()) {
                        to_curr.setText(from_curr.getText());
                    } else if (USD_1.isChecked() && BTC_2.isChecked()) {
                        Double doublefromcurr = Double.parseDouble(from_curr.getText().toString()) * 0.000092;
                        to_curr.setText(Double.toString(doublefromcurr));

                    } else if (USD_1.isChecked() && DOGE_2.isChecked()) {
                        Double doublefromcurr = Double.parseDouble(from_curr.getText().toString()) * 0.0069;
                        to_curr.setText(Double.toString(doublefromcurr));
                    } else if (BTC_1.isChecked() && BTC_2.isChecked()) {
                        to_curr.setText(from_curr.getText());
                    } else if (BTC_1.isChecked() && USD_2.isChecked()) {
                        Double doublefromcurr = Double.parseDouble(from_curr.getText().toString()) / 0.000092;
                        to_curr.setText(Double.toString(doublefromcurr));
                    } else if (BTC_1.isChecked() && DOGE_2.isChecked()) {
                        Double doublefromcurr = Double.parseDouble(from_curr.getText().toString()) / 0.00000023;
                        to_curr.setText(Double.toString(doublefromcurr));
                    } else if (DOGE_1.isChecked() && USD_2.isChecked()) {
                        Double doublefromcurr = Double.parseDouble(from_curr.getText().toString()) / 0.0069;
                        to_curr.setText(Double.toString(doublefromcurr));
                    } else if (DOGE_1.isChecked() && BTC_2.isChecked()) {
                        Double doublefromcurr = Double.parseDouble(from_curr.getText().toString()) * 0.00000023;
                        to_curr.setText(Double.toString(doublefromcurr));
                    } else if (DOGE_1.isChecked() && DOGE_2.isChecked()) {
                        to_curr.setText(from_curr.getText());
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }







    //to_curr = Double.parseDouble(to_curr.getText().toString());

               // return to_curr;








}
