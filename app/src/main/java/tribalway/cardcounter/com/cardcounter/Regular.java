package tribalway.cardcounter.com.cardcounter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import static android.widget.Toast.LENGTH_LONG;
import static java.util.Calendar.LONG;

public class Regular extends AppCompatActivity {


    int count = 0;
    int cards;
    int resetShoe;
    double decks = cards / 52;

    Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regular);
        invisible(0);
    }


    public void counting(View view) {
        TextView plus = (TextView) findViewById(R.id.plus);
        TextView minus = (TextView) findViewById(R.id.minus);


        if (cards > 0) {

            TextView countText = (TextView) findViewById(R.id.count);
            String countEquals = getString(R.string.count_equals);

            switch (view.getId()) {

                case R.id.plus:
                    count++;
                    cards--;
                    countText.setText(countEquals + " " + count);
                    setNumberOfDecksRemaining();
                    setTrueCount();
                    vibrate(40);
                    // trueCountPositive();
                    break;

                case R.id.minus:
                    count--;
                    cards--;
                    countText.setText(countEquals + " " + count);
                    setNumberOfDecksRemaining();
                    setTrueCount();
                    vibrate(40);
                    break;

            }
        }

        if (cards == 0 && count == 0) {
            Toast toast = Toast.makeText(this, R.string.select_number_decks, LENGTH_LONG);
            toast.show();
        }

        if (cards == 0 && count != 0) {
            Toast toast = Toast.makeText(this, R.string.reset_count, LENGTH_LONG);
            toast.show();
        }
    }


    public void selectDeck(View view) {
        invisible(1);
    }

    public void radioSelection(View view) {

        switch (view.getId()) {

            case R.id.one_deck:
                setCards(1);
                resetShoe = 1;
                break;

            case R.id.two_decks:
                setCards(2);
                resetShoe = 2;
                break;

            case R.id.four_decks:
                setCards(4);
                resetShoe = 4;
                break;

            case R.id.six_decks:
                setCards(6);
                resetShoe = 6;
                break;

            case R.id.eight_decks:
                setCards(8);
                resetShoe = 8;
                break;
        }

        setCount();
        setNumberOfDecksRemaining();
        setTrueCount();
    }


    public void done(View view) {
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


    public void goToMenu(View view) {
        Adds.incomingView = view.getId();
        Intent intent = new Intent(this, Adds.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Button button = (Button) findViewById(R.id.menu);
        goToMenu(button);
    }


    public void setCards(int decks) {
        cards = new Shoe(decks).cards;

        setNumberOfDecksRemaining();
    }


    public void setCount() {
        count = 0;
        TextView countText = (TextView) findViewById(R.id.count);
        String countEquals = getString(R.string.count_equals) + count;

        countText.setText(countEquals);


    }

    public void setNumberOfDecksRemaining() {
        TextView number = (TextView) findViewById(R.id.number_of_decks);

        decks = (double) cards / 52;

        String decksRemaining = getString(R.string.remaining_decks_equals);
        String remainingDecks = String.format("%s %.02f", decksRemaining, decks);

        number.setText(remainingDecks);
    }


    public void setTrueCount() {
        TextView trueCount = (TextView) findViewById(R.id.true_count);
        double truecount;

        if (decks > 1) {
            truecount = (double) count / decks;
        } else {
            truecount = count;
        }

        if (truecount >= 3.0) {
            trueCountPositive();
        }


        String realTrueCount = String.format("%s %.02f", getString(R.string.running_count_equals), truecount);
        trueCount.setText(realTrueCount);

    }


    public void resetShoe(View view) {
        count = 0;

        TextView countText = (TextView) findViewById(R.id.count);
        String countEquals = getString(R.string.count_equals) + "0";
        countText.setText(countEquals);

        setCards(resetShoe);
        setNumberOfDecksRemaining();
        setTrueCount();


    }


    //------------------ vibration methods
    //---------------------------------------------------


    public void vibrate(int duration) {
        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibe.vibrate(duration);
    }

    public void trueCountPositive() {
        Pattern.run();


    }
    static int x = 0;

    private Runnable Pattern = new Runnable(){

        @Override
        public void run() {


                vibrate(80);
                x++;

                handler.postDelayed(this, 600);
                if(x==3){
                    handler.removeCallbacks(this);
                }


            }



    };
}