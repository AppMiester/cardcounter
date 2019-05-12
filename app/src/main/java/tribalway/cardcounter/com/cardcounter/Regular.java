package tribalway.cardcounter.com.cardcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Regular extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regular);
        invisible(0);
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
