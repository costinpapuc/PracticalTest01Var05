package practicaltest01var05.eim.systems.cs.pub.ro.practicaltest01var05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var05SecondaryActivity extends AppCompatActivity {

    private TextView counter = null;
    private TextView seq = null;
    private Button registerButton = null;
    private Button cancelButton = null;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.register_button:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.cancel_button:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_secondary);

        counter = (TextView)findViewById(R.id.first_text_view);
        seq = (TextView)findViewById(R.id.second_text_view);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("counter")
                && intent.getExtras().containsKey("seq")) {
            counter.setText(String.valueOf(intent.getIntExtra("counter", -1)));
            seq.setText(intent.getStringExtra("seq"));
        }

        registerButton = (Button)findViewById(R.id.register_button);
        registerButton.setOnClickListener(buttonClickListener);
        cancelButton = (Button)findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(buttonClickListener);
    }

}
