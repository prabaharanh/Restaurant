package com.example.admin.kavik;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    int counter = 0;
    int sizemenu;

    ArrayList<GetMenu> getallMenu;
    LinearLayout layoutMenuList;
    TextView tvTotal;
    //TextView tvPlaceorder;

    //Database db = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        getallMenu = new Database(this).getMenulist();
        sizemenu = new Database(this).getTotalMenuItems();


       // tvPlaceorder= findViewById(R.id.tvPlaceorder);


       loadMenu();



    }



    public void loadMenu() {



        layoutMenuList = (LinearLayout) findViewById(R.id.layoutMenuList);
        for (int i = 0; i <= (sizemenu - 1); i++) {
            LinearLayout layoutList = new LinearLayout(this);

            layoutList.setOrientation(LinearLayout.VERTICAL);
            tvTotal = findViewById(R.id.tvTotal);


            TextView tvMenuid = new TextView(this);
            TextView tvMenuName = new TextView(this);
            tvMenuName.setTextSize(24);
            final TextView tvMenuDescription = new TextView(this);
            final TextView tvMenuPrice = new TextView(this);
            TextView tvMenuType = new TextView(this);
            Button btnCart = new Button(this);

            tvMenuid.setText(Integer.toString(getallMenu.get(counter).getMenuId()));
            tvMenuName.setText(getallMenu.get(counter).getMenuName());
            tvMenuDescription.setText(getallMenu.get(counter).getMenuDescription());
            tvMenuPrice.setText(Integer.toString(getallMenu.get(counter).getMenuPrice()));
            tvMenuType.setText(getallMenu.get(counter).getMenuType());
            btnCart.setText("Add to Cart");

            layoutList.addView(tvMenuid);
            layoutList.addView(tvMenuName);
            layoutList.addView(tvMenuDescription);
            layoutList.addView(tvMenuPrice);
            layoutList.addView(tvMenuType);

            counter++;

            layoutMenuList.addView(layoutList);
            layoutList.addView(btnCart);

            tvMenuDescription.setOnTouchListener( new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    tvMenuDescription.setTextSize(24);
                    return false;
                }
            } );

            btnCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int number = Integer.valueOf(tvMenuPrice.getText().toString());
                    int cart = Integer.valueOf(tvTotal.getText().toString());
                    int total = cart + number;

                    tvTotal.setText("" + total);
                }
            });


        }

    }
}
