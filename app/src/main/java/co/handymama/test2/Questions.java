package co.handymama.test2;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by User on 12/4/2017.
 */

public class Questions {

    Questions (String data){
        Log.d("Cons data", data);
    }


    CheckBox[] prepareCB(Context context, ModelQs obj, String[] cbItems, LinearLayout ll) {

        TextView tv = new TextView(context);
        tv.setText(""+obj.getQuesData());
        ll.addView(tv);

        final CheckBox[] cb = new CheckBox[cbItems.length];
        for(int i = 0; i < cbItems.length; i++) {
            cb[i] = new CheckBox(context);
            cb[i].setText(cbItems[i]);
            ll.addView(cb[i]);

        }

        return cb;
 }


    Button addNextFinishButton(Context context, String text, LinearLayout ll) {

        Button button =  new Button(context);
        button.setText(""+text);
        button.setTextColor(Color.WHITE);
        button.setBackgroundColor(Color.GREEN);
        button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);

        ll.addView(button);

        return button;
    }



}

