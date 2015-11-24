package seb.mah.se;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.MessageFormat;

public class Lab1bActivity extends Activity {


    private EditText etName;
    private EditText etPhone;
    private EditText etEmail;
    private TextView tvSummary;
    private TextView tvName;
    private Button btnSummary;
    private Button btnColor;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initializeComponents();
        registerListeners();
    }

    private void registerListeners() {
        btnColor.setOnClickListener(new ChangeColor());
        btnSummary.setOnClickListener(new ButtonListener());
    }

    private void initializeComponents() {
        etName = (EditText) findViewById(R.id.etName);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etEmail = (EditText) findViewById(R.id.etEmail);
        tvSummary = (TextView) findViewById(R.id.tvSummary);
        tvName= (TextView) findViewById(R.id.tvName);
        btnSummary = (Button)findViewById(R.id.btnSummary);
        btnColor = (Button) findViewById(R.id.btnColor);
    }

    private class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String str = summary();
            tvSummary.setText(str);

        }

        private String summary() {
            String res;
            res = MessageFormat.format("Name= {0}, phone={1}, email={2}",etName.getText().toString(),etPhone.getText().toString(),etEmail.getText().toString());
            return res;
        }
    }

    private class ChangeColor implements View.OnClickListener {
        private boolean redColor = true;

        @Override
        public void onClick(View v) {
            if (redColor) {
                tvName.setTextColor(0xFFFF6600);

            }
            else {
                tvName.setTextColor(Color.RED);
            }
            redColor = !redColor;
        }
    }
}
