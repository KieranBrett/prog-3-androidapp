package bretkg1.bit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Quiz extends AppCompatActivity implements View.OnClickListener{
    private Question[] questions = new Question[10];
    private int score = 0;
    private int questionNumber = 0;
    private TextView[] images = new TextView[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Setting buttun to have click
        Button btn = (Button) findViewById(R.id.btnNext);
        btn.setOnClickListener(this);

        // Setting references to all textViews in an array
        images[0] = ((TextView)findViewById(R.id.image1));
        images[1] = ((TextView)findViewById(R.id.image2));
        images[2] = ((TextView)findViewById(R.id.image3));
        images[3] = ((TextView)findViewById(R.id.image4));
        // Setting click event
        images[0].setOnClickListener(this);
        images[1].setOnClickListener(this);
        images[2].setOnClickListener(this);
        images[3].setOnClickListener(this);
        // Setting gravity so text is in center
        images[0].setGravity(Gravity.CENTER);
        images[1].setGravity(Gravity.CENTER);
        images[2].setGravity(Gravity.CENTER);
        images[3].setGravity(Gravity.CENTER);
        // Calling set up method and starting game
        setUpQuestions();
        showQuestion();
    }

    private void setUpQuestions(){ // All the questions get set up in this method, could be optimised by using a json file instead
        questions[0] = new Question(R.drawable.dunedin, R.drawable.moscow, R.drawable.shenzen, R.drawable.meieki, "Correct\nDunedin", "Wrong\nMoscow", "Wrong\nShenzen", "Wrong\nMeieki", "Correct\nDunedin");
        questions[1] = new Question(R.drawable.bangkok, R.drawable.auckland, R.drawable.osaka, R.drawable.newy, "Wrong\nBangkok", "Correct\nAuckland", "Wrong\nOsaka", "Wrong\nNew York", "Correct\nAuckland");
        questions[2] = new Question(R.drawable.invercargill, R.drawable.harbin, R.drawable.saltlakecity, R.drawable.pyongyang, "Correct\nInvercargill", "Wrong\nHarbin", "Wrong\nSalt Lake City", "Wrong\nPyongyang", "Correct\nInvercargill");
        questions[3] = new Question(R.drawable.rio, R.drawable.dalian, R.drawable.harar, R.drawable.hamilton, "Wrong\nRio", "Wrong\nDalian", "Wrong\nHarar", "Correct\nHamilton", "Correct\nHamilton");
        questions[4] = new Question(R.drawable.levent, R.drawable.wellington, R.drawable.meieki, R.drawable.richmond, "Wrong\nLevent", "Correct\nWellington", "Wrong\nMeieiki", "Wrong\nRichmond", "Correct\nWellington");
        questions[5] = new Question(R.drawable.christchurch, R.drawable.toronto, R.drawable.tokyo, R.drawable.kolkata, "Correct\nChristchurch", "Wrong\nToronto", "Wrong\nTokyo", "Wrong\nKolkata", "Correct\nChristchurch");
        questions[6] = new Question(R.drawable.timaru, R.drawable.fukuoaka, R.drawable.bangkok, R.drawable.harar, "Correct\nTimaru", "Wrong\nFukuoaka", "Wrong\nBangkok", "Wrong\nHarar", "Correct\nTimaru");
        questions[7] = new Question(R.drawable.dalian, R.drawable.whangarei, R.drawable.dallas, R.drawable.la, "Wrong\nDalian", "Correct\nWhangarei", "Wrong\nDallas", "Wrong\nL.A", "Correct\nWhangarei");
        questions[8] = new Question(R.drawable.tauranga, R.drawable.tehran, R.drawable.toronto, R.drawable.pyongyang, "Correct\nTauranga", "Wrong\nTehran", "Wrong\nToronto", "Wrong\nPyongyang", "Correct\nTauranga");
        questions[9] = new Question(R.drawable.harbin, R.drawable.delhi, R.drawable.shanghai, R.drawable.nelson, "Wrong\nHarbin", "Wrong\nDelhi", "Wrong\nShanghai", "Correct\nNelson", "Correct\nNelson");
    }

    private void showQuestion(){ // Show all images for each text view
        images[0].setText("");
        images[1].setText("");
        images[2].setText("");
        images[3].setText("");
        images[0].setBackgroundResource(questions[questionNumber].getImg1());
        images[1].setBackgroundResource(questions[questionNumber].getImg2());
        images[2].setBackgroundResource(questions[questionNumber].getImg3());
        images[3].setBackgroundResource(questions[questionNumber].getImg4());
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.image1){ // Checking what text view is clicked
            images[0].setBackground(null); // Setting its background to null/nothing
            images[0].setText(questions[questionNumber].getStr1()); // Setting text to its result
            questions[questionNumber].CheckAnswer(questions[questionNumber].getStr1()); // Checking the answer against the result

            makeToast(); // Display toast based on input
        }
        else if (v.getId() == R.id.image2){
            images[1].setBackground(null);
            images[1].setText(questions[questionNumber].getStr2());
            questions[questionNumber].CheckAnswer(questions[questionNumber].getStr2());

            makeToast();
        }
        else if (v.getId() == R.id.image3){
            images[2].setBackground(null);
            images[2].setText(questions[questionNumber].getStr3());
            questions[questionNumber].CheckAnswer(questions[questionNumber].getStr3());

            makeToast();
        }
        else if (v.getId() == R.id.image4){
            images[3].setBackground(null);
            images[3].setText(questions[questionNumber].getStr4());
            questions[questionNumber].CheckAnswer(questions[questionNumber].getStr4());

            makeToast();
        }
        else{ // If its the next button being pressed
            if (questions[questionNumber].isAnswered()) { // Only if the question is answered
                questionNumber++; // Increment question
                score++; // Increment score

                if (questionNumber > questions.length - 1) { // If completed all questions
                    Intent changeActivity = new Intent(Quiz.this, EndScreen.class);
                    changeActivity.putExtra("result", score);
                    startActivity(changeActivity); // Start new activity and pass score
                } else { // If havent finished, show next question
                    showQuestion();
                }
            }
        }
    }

    private void makeToast(){
        if (questions[questionNumber].isAnswered()){
            Toast.makeText(this, "You Can Continue", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
        }
    }
}