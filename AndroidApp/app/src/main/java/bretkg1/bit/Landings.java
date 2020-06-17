package bretkg1.bit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Landings extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landings);

        Button btn = (Button) findViewById(R.id.btnGetStarted);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent changeActivity = new Intent(Landings.this, Quiz.class);
        startActivity(changeActivity);
    }
}