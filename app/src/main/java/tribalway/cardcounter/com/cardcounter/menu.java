package tribalway.cardcounter.com.cardcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        textBorder();
    }


    public void goToAdd(View view){
        Adds.incomingView = view.getId();
        Intent intent = new Intent(this, Adds.class);
        startActivity(intent);

        }






    public void textBorder() {

        TextView regular = (TextView) findViewById(R.id.regular);
        TextView advanced = (TextView) findViewById(R.id.advanced);
        TextView stradegy = (TextView) findViewById(R.id.stradegy);

        regular.setBackgroundResource(R.drawable.border);
        advanced.setBackgroundResource(R.drawable.border);
        stradegy.setBackgroundResource(R.drawable.border);
        }


}