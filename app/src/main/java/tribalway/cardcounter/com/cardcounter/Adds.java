package tribalway.cardcounter.com.cardcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Adds extends AppCompatActivity {

    static int incomingView;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adds);
        borderView();
    }



    public void closeToNext(View view){
         Intent intent = null;

        switch (incomingView){

            case R.id.regular :
                 intent = new Intent(this,Regular.class);
                 break;

            case R.id.menu :
                intent = new Intent(this,menu.class);
                break;

            case R.id.advanced:
                intent = new Intent(this,Advanced.class);
                break;
        }
        startActivity(intent);
    }






    public void borderView() {




        TextView close = (TextView) findViewById(R.id.close);

        close.setBackgroundResource(R.drawable.border);
    }


}