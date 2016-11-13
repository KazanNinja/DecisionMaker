package com.example.asehic.decisionmaker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "Zs35sEsp8dumTIHMliN2aQnI0";
    private static final String TWITTER_SECRET = "kkmSLYowso5UbIG3B1e7SBsws6oXV1McRTCCfHysYU1bNZzoh1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void buttonClick(View view) {
        //Sets animations and variable
        final Animation in = new AlphaAnimation(0.0f, 1.0f);
        in.setDuration(700);

        final Animation out = new AlphaAnimation(1.0f, 0.0f);
        out.setDuration(700);

        TextView decisionMessage = (TextView) findViewById(R.id.textAnswer);
        TextView subMessage = (TextView) findViewById(R.id.textAnswerSub);

        EditText inputQuestion = (EditText) findViewById(R.id.inputQuestion);
        String inQuestionString = inputQuestion.getText().toString();

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        //Random int for the decision
        int random = (int) (Math.random() * 2);

        //decides yes or no
        if (random == 1) {

            decisionMessage.startAnimation(out);
            decisionMessage.setText("YES");

            if (inQuestionString.isEmpty()) {
                subMessage.startAnimation(in);
                subMessage.setText("You should go do that");
            }
            else {
                subMessage.startAnimation(in);
                subMessage.setText("You should " + inQuestionString);
            }


            decisionMessage.startAnimation(in);

        }
        else if (random == 0) {

            decisionMessage.startAnimation(out);
            decisionMessage.setText("NO");

            if (inQuestionString.isEmpty()) {
                subMessage.startAnimation(in);
                subMessage.setText("You shouldn't do that");
            }
            else {
                subMessage.startAnimation(in);
                subMessage.setText("You shouldn't " + inQuestionString);
            }

            decisionMessage.startAnimation(in);
        }

    }

    public void clearClick(View view) {
        EditText inputQuestion = (EditText) findViewById(R.id.inputQuestion);
        inputQuestion.setText("");
    }
}
