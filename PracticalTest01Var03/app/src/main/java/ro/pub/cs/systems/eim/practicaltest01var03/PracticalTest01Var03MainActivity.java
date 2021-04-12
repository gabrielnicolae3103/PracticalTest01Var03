package ro.pub.cs.systems.eim.practicaltest01var03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var03MainActivity extends AppCompatActivity {

    EditText number1;
    EditText number2;
    Button plusButton;
    Button minusButton;
    TextView result;
    char operation = ' ';
    Button navigateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_main);

        this.number1 = findViewById(R.id.number1EditText);
        this.number2 = findViewById(R.id.number2EditText);
        this.plusButton = findViewById(R.id.plusButton);
        this.minusButton = findViewById(R.id.minusButton);
        this.result = findViewById(R.id.result);
        this.navigateButton = findViewById(R.id.navigate);

        this.plusButton.setOnClickListener(new ViewListener());
        this.minusButton.setOnClickListener(new ViewListener());
        this.navigateButton.setOnClickListener(new ViewListener());
    }


    public class ViewListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.plusButton: {
                    String n1 = number1.getText().toString();
                    String n2 = number2.getText().toString();
                    if (!isInteger(n1) || !isInteger(n2)) {
                        Toast.makeText(getApplicationContext(), "Introdu numere", Toast.LENGTH_LONG).show();
                        break;
                    }
                    int resultN = Integer.parseInt(n1) + Integer.parseInt(n2);
                    String resultText = n1 + " + " + n2 + " = " + String.valueOf(resultN);
                    result.setText(resultText);
                    operation = '+';
                    break;
                }
                case R.id.minusButton: {
                    String n1 = number1.getText().toString();
                    String n2 = number2.getText().toString();
                    if (!isInteger(n1) || !isInteger(n2)) {
                        Toast.makeText(getApplicationContext(), "Introdu numere", Toast.LENGTH_LONG).show();
                        break;
                    }
                    int resultN = Integer.parseInt(n1) - Integer.parseInt(n2);
                    String resultText = n1 + " - " + n2 + " = " + String.valueOf(resultN);
                    result.setText(resultText);
                    operation = '-';
                    break;
                }
                case R.id.navigate: {
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var03SecondaryActivity.class);
                    intent.putExtra(Constants.OPERATION, result.getText().toString());
                    startActivityForResult(intent, Constants.SECONDARY_ACTIVITY_REQUEST_CODE);
                    break;
                }
                default: {
                    return;
                }

            }
        }
    }

    public static boolean isInteger(String s) {
        return isInteger(s,10);
    }

    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty() || s == null) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(Constants.NUMBER_1, number1.getText().toString());
        savedInstanceState.putString(Constants.NUMBER_2, number2.getText().toString());
        savedInstanceState.putString(Constants.RESULT, result.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String s1 = "";
        String s2 ="";
        if (savedInstanceState.containsKey(Constants.NUMBER_1)) {
            s1 = savedInstanceState.getString(Constants.NUMBER_1);
            number1.setText(s1);
        }
        if (savedInstanceState.containsKey(Constants.NUMBER_2)) {
            s2 = savedInstanceState.getString(Constants.NUMBER_2);
            number2.setText(s2);
        }
        if (savedInstanceState.containsKey(Constants.RESULT)) {
            String s3 = savedInstanceState.getString(Constants.RESULT);
            result.setText(s3);
        }
        Toast.makeText(getApplicationContext(), "Numerele sunt " + s1 + " " + s2, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == Constants.SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }
}