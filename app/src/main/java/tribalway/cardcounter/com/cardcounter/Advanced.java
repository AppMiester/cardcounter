package tribalway.cardcounter.com.cardcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Advanced extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced);
        invisible(0);
    }








    public void selectDeckAdvanced(View view) {
        invisible(1);
    }

    public void doneAdvanced(View view) {
        invisible(0);
    }

    public void goToMenu(View view) {
        Adds.incomingView = R.id.menu;
        Intent intent = new Intent(this, Adds.class);
        startActivity(intent);
    }




    public void invisible(int vision) {

        LinearLayout deckNumberSelectionAdvanced = (LinearLayout) findViewById(R.id.deck_number_selection_advanced);


        switch (vision) {

            case 0:
                deckNumberSelectionAdvanced.setVisibility(View.GONE);
                break;

            case 1:
                deckNumberSelectionAdvanced.setVisibility(View.VISIBLE);
                break;
        }

    }

    @Override
    public void onBackPressed(){
        Button button = (Button) findViewById(R.id.menu);
        goToMenu(button);
    }
}
