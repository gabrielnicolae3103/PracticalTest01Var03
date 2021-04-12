package ro.pub.cs.systems.eim.practicaltest01var03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PracticalTest01Var03SecondaryActivity extends AppCompatActivity {

    TextView operation;
    Button correctButton;
    Button incorrectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_secondary);

        this.operation = findViewById(R.id.operation);
        this.correctButton = findViewById(R.id.corect);
        this.incorrectButton = findViewById(R.id.incorect);
        this.correctButton.setOnClickListener(new ViewListener());
        this.incorrectButton.setOnClickListener(new ViewListener());

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey(Constants.OPERATION)) {
            String operationText = intent.getStringExtra(Constants.OPERATION);
            operation.setText(String.valueOf(operationText));
        }
    }

    public class ViewListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.corect: {
                    setResult(RESULT_OK, null);
                    finish();
                    break;
                }
                case R.id.incorect: {
                    setResult(RESULT_CANCELED, null);
                    finish();
                    break;
                }
            }

        }
    }
}
