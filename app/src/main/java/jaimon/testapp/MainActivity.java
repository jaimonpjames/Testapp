package jaimon.testapp;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends Activity {

    int  numberOfCoffeesOrdered =2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox ch1 = (CheckBox) findViewById(R.id.checkBox);
        boolean whimboolean = ch1.isChecked();
        CheckBox ch2 = (CheckBox) findViewById(R.id.cbchocolate);
        boolean whimboolean2 = ch2.isChecked();
        //Log.v("MainActivity" , "ch2.isChecked() = " +whimboolean2);
        if(whimboolean) {

        }
        displayPrice(numberOfCoffeesOrdered,ch1,ch2);
        display(numberOfCoffeesOrdered);
        String s =displayOrder(numberOfCoffeesOrdered ,whimboolean + " & "+ whimboolean2);
        TextView t1= (TextView)findViewById(R.id.textView2);
        TextView t2= (TextView)findViewById(R.id.nametext);
        String ss =getString(R.string.thank);
        t1.setText(s+"\n"+t2.getText()+"\n"+ss);
    }
    public String displayOrder(int quantity, String whimboolean) {

        return "quantity : " + quantity + "\n WhimCream & Chocolate : " + whimboolean;
   }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number,CheckBox ch1,CheckBox ch2) {
        int price = number*5;

        if(ch1.isChecked()) {
            price += number * 1;
        }
        if(ch2.isChecked()) {
            price += number * 2;
        }

        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(price));
    }

    public void increment (View view) {

        numberOfCoffeesOrdered++;
        display(numberOfCoffeesOrdered);

    }

    public void decrement(View view) {

      numberOfCoffeesOrdered--;
      display(numberOfCoffeesOrdered);
    }
    public void mail(View view) {

        Intent intent;
        intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        startActivity(intent);
    }
}
