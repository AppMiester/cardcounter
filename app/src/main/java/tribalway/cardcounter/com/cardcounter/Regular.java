package tribalway.cardcounter.com.cardcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Regular extends AppCompatActivity {


    int count = 0;
    int cards;
    double decks = cards / 52;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regular);
        invisible(0);
    }


    public void counting(View view) {
        TextView plus = (TextView) findViewById(R.id.plus);
        TextView minus = (TextView) findViewById(R.id.minus);



        TextView countText = (TextView) findViewById(R.id.count);
        String countEquals = getString(R.string.count_equals);

        switch (view.getId()) {

            case R.id.plus:
                count++;
                cards--;
                countText.setText(countEquals + " " + count);
                setNumberOfDecksRemaining();
                setTrueCount();
                break;

            case R.id.minus:
                count--;
                cards--;
                countText.setText(countEquals + " " + count);
                setNumberOfDecksRemaining();
                setTrueCount();
                break;

        }
    }


    public void selectDeck(View view) {
        invisible(1);
    }

    public void radioSelection(View view){

        switch(view.getId()){

            case R.id.one_deck:
                setCards(1);
                break;

            case R.id.two_decks:
                setCards(2);
                break;

            case R.id.four_decks:
                setCards(4);
                break;

            case R.id.six_decks:
                setCards(6);
                break;

            case R.id.eight_decks:
                setCards(8);
                break;
        }
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

    public void setNumberOfDecksRemaining(){
        TextView number= (TextView) findViewById(R.id.number_of_decks);

        double decks = (double) cards / 52;

        String decksRemaining = getString(R.string.remaining_decks_equals);
        String remainingDecks = String.format("%s %.02f", decksRemaining, decks);

        number.setText(remainingDecks);
    }

    public void setTrueCount(){
        TextView trueCount = (TextView) findViewById(R.id.true_count);

        double truecount = (double) count / decks;

        String realTrueCount = String.format("%s %.02f", getString(R.string.running_count_equals),truecount);
        trueCount.setText(realTrueCount);
    }

}