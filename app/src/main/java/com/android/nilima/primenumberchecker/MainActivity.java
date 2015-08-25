package com.android.nilima.primenumberchecker;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    EditText firstRangeET,secondRangeET;
    TextView resultView;
    Button okBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstRangeET=(EditText) findViewById(R.id.first_rangeET);
        secondRangeET=(EditText) findViewById(R.id.second_rangeET);
        resultView=(TextView) findViewById(R.id.prime_View);
        okBtn=(Button) findViewById(R.id.ok_btn);

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<Integer> myArray=new ArrayList<Integer>();
                Integer num1=Integer.parseInt(firstRangeET.getText().toString());
                Integer num2=Integer.parseInt(secondRangeET.getText().toString());

                for (int i=num1;i<=num2;i++){


                    if (is_prime(i)){
                        myArray.add(i);
                    }


                }
                resultView.setText(myArray.toString());


            }
        });


    }

    public Boolean is_prime(int number){

        Boolean status=true;
        if (number>1){
            if (number>2){
                for (int i=2;i<=number/2;i++){
                    if (number%i==0){
                        status=false;
                        break;
                    }
                }
            }
        }else status=false;
        return status;
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
}
