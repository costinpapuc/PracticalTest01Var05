package practicaltest01var05.eim.systems.cs.pub.ro.practicaltest01var05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var05MainActivity extends AppCompatActivity {

    private Button nButton;
    private Button wButton;
    private Button eButton;
    private Button sButton;
    private Button secondButton;

    private TextView textView;

    private int counter = 0;

    private static final int SECONDARY_ACTIVITY_REQUEST_CODE = 1;

    private class MyListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.second_button) {
                Intent intent = new Intent(getApplicationContext(), PracticalTest01Var05SecondaryActivity.class);
                String seq = textView.getText().toString();
                intent.putExtra("counter", counter);
                intent.putExtra("seq", seq);
                startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
            }
            else {
                switch (v.getId()) {
                    case R.id.n_button:
                        textView.setText(textView.getText().toString()+"N,");
                        break;
                    case R.id.w_button:
                        textView.setText(textView.getText().toString()+"W,");
                        break;
                    case R.id.e_button:
                        textView.setText(textView.getText().toString()+"E,");
                        break;
                    case R.id.s_button:
                        textView.setText(textView.getText().toString()+"S,");
                        break;
                }
                counter++;
                //Toast.makeText(this, "Activity returned with result " + counter, Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d("COUNTER", "counter is: " + counter);
        outState.putInt("counter", counter);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("counter"))
            this.counter = savedInstanceState.getInt("counter");
        Log.d("COUNTER", "counter is: " + counter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_main);

        MyListener myListener = new MyListener();

        nButton = (Button)findViewById(R.id.n_button);
        wButton = (Button)findViewById(R.id.w_button);
        eButton = (Button)findViewById(R.id.e_button);
        sButton = (Button)findViewById(R.id.s_button);
        secondButton = (Button)findViewById(R.id.second_button);
        textView = (TextView)findViewById(R.id.text_view);
        textView.setText("");
        nButton.setOnClickListener(myListener);
        wButton.setOnClickListener(myListener);
        eButton.setOnClickListener(myListener);
        sButton.setOnClickListener(myListener);
        secondButton.setOnClickListener(myListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "Activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }
}
