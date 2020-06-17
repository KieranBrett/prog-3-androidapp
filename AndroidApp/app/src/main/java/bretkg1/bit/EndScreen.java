package bretkg1.bit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EndScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        Intent howIGotHere = getIntent();
        int score = howIGotHere.getIntExtra("result", -1);
        TextView tv = (TextView) findViewById(R.id.textView6);
        tv.setText(score + " out of 10");
    }
}