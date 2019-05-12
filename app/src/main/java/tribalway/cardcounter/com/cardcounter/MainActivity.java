package tribalway.cardcounter.com.cardcounter;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTextBorder();
    }



    public void goToMenu(View view){

        boolean terms = isTermsChecked();

        if(terms){

            Intent intent = new Intent(this,menu.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Check Box To Agree With Terms Before Entering", Toast.LENGTH_LONG).show();
        }


    }




    public void setTextBorder(){
        TextView enter = (TextView) findViewById(R.id.enter_text);

        enter.setBackgroundResource(R.drawable.border);
    }

    public boolean isTermsChecked(){
        CheckBox checkBox = (CheckBox) findViewById(R.id.check_box);

        if(checkBox.isChecked()){
            return true;
        }else{
            return false;
        }

    }



}
