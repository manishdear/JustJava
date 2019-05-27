package com.example.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int noOfCoffe = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayPrice(5);
    }

    private void displayPrice(int number){
        TextView price = findViewById(R.id.price_text_view);
        price.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    public void submitOrder(View view){
        boolean isWhipped = isWhippedChecked();
        boolean isTopping = isToppingChecked();
        orderSummaryHeading("ORDER SUMMARY");
        double total_bill = calculatePrice(noOfCoffe, isWhipped, isTopping);
        String summary = orderSummary(total_bill, isWhipped, isTopping);
        displaySummary(summary);
    }

    private boolean isWhippedChecked(){
        CheckBox checkBox = findViewById(R.id.cb_wipped);
        return checkBox.isChecked();
    }

    private boolean isToppingChecked(){
        CheckBox checkBox = findViewById(R.id.cb_topping);
        return checkBox.isChecked();
    }

    private void orderSummaryHeading(String msg){
        TextView heading = findViewById(R.id.orderSummary_heading);
        heading.setText(msg);
    }

    private double calculatePrice(int quantity, boolean isWhipped, boolean isTopping){
        double total = quantity*5;
        if(isWhipped == true){
            total += quantity* 2;
        }

        if(isTopping == true){
            total += quantity* 3;
        }
        return total;
    }

    public void increment(View view){
       displayQuantity(++noOfCoffe);
    }

    public void decrement(View view){
        displayQuantity(--noOfCoffe);
    }

    private void displayQuantity(int noOfCoffe){
        TextView quantity = findViewById(R.id.quantity_text_view);
        quantity.setText(noOfCoffe);
    }

    private String getName(){
        EditText name = findViewById(R.id.name);
        String userName = name.getText().toString();
        return  userName;
    }

    private String orderSummary(double total, boolean isWhipped, boolean isTopping){
        String summary = "Name: " + getName() +"\n"
                + "Quantity: " + noOfCoffe + "\n"
                + "Add Whipped Cream? " + isWhipped + "\n"
                + "Add Chocolate Topping? " + isTopping + "\n"
                + "Total: " + NumberFormat.getCurrencyInstance().format(total) + "\n"
                + "THANK YOU ); " +"\n";
        return summary;
    }

    private void displaySummary(String summary){
        TextView order = findViewById(R.id.price_text_view);
        order.setText(summary);
    }

}
