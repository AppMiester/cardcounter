package tribalway.cardcounter.com.cardcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Regular extends AppCompatActivity {

   // TextView plus = (TextView) findViewById(R.id.plus);
   // TextView minus = (TextView) findViewById(R.id.minus);
   // String countEquals = getString(R.string.count_equals);

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regular);
        invisible(0);
    }

    public void counting(View view){
        TextView plus = (TextView) findViewById(R.id.plus);
        TextView minus = (TextView) findViewById(R.id.minus);

        TextView countText = (TextView) findViewById(R.id.count);
        String countEquals = getString(R.string.count_equals);

        switch(view.getId()){

            case R.id.plus:
                count++;
                countText.setText(countEquals + " " + count);
                break;

            case R.id.minus:
                count--;
                countText.setText(countEquals + " " + count);
                break;

        }
    }

    public void selectDeck(View view){
        invisible(1);
    }

    public void done(View view){
        invisible(0);
    }


    public void invisible(int vision) {

        LinearLayout deckNumberSelection = (LinearLayout) findViewById(R.id.deck_number_selection);


        switch (vision) {

            case 0:
                deckNumberSelection.setVisibility(View.GONE);
                break;

            case 1:
                deckNumberSelection.setVisibility(View.VISIBLE);
                break;
        }

        }
    }
