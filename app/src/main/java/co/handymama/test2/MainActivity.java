package co.handymama.test2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Queue;

import static co.handymama.test2.GlobalDat.burgerItems;
import static co.handymama.test2.GlobalDat.checkboxData;
import static co.handymama.test2.GlobalDat.questions;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CheckBox br = (CheckBox) findViewById(R.id.cb_burg);
        final CheckBox pz = (CheckBox) findViewById(R.id.cb_pizz);

        final Button nextButton = (Button) findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // click on burger
                if(br.isChecked()) {
                    checkboxData.add("burger");
                }


                // click on pizza
                if(pz.isChecked()) {
                    checkboxData.add("pizza");
                }


                startAsking(checkboxData, questions);

            }
        });




    }





    // start asking questions
    void startAsking(final Queue<String> data, final Queue<ModelQs> prepQues){

            LinearLayout lm = (LinearLayout) findViewById(R.id.llayout);

            final Questions questions = new Questions(data.peek());
            data.remove();
            final CheckBox[] cbs = questions.prepareCB(MainActivity.this, prepQues.peek(),
                    burgerItems, lm);
            prepQues.remove();

            Button b = questions.addNextFinishButton(MainActivity.this, "Next", lm);

            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    for(CheckBox c : cbs) {
                        if(c.isChecked()) {
                            data.add(c.getText().toString());
                        }

                    }

                    startAsking(data, prepQues);

                }
            });


    }



}
