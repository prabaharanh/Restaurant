package com.example.admin.kavik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    int counter = 0;
    int sizemenu;

    ArrayList<GetOrder> getallOrder;
    LinearLayout layoutOrderList;
    TextView tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_cart );

        getallOrder = new Database(this).getOrderlist();
        sizemenu = new Database(this).getTotalorder();

        loadOrder();

    }
    public void loadOrder() {


        layoutOrderList = (LinearLayout) findViewById( R.id.layoutOrderList );
        for (int i = 0; i <= (sizemenu - 1); i++) {
            LinearLayout layoutList = new LinearLayout( this );

            layoutList.setOrientation( LinearLayout.VERTICAL );
            tvTotal = findViewById( R.id.tvTotal );


            TextView tvOrderid = new TextView( this );
            TextView tvOrderName = new TextView( this );
            tvOrderName.setTextSize(24);
            final TextView tvOrderlist = new TextView( this );
            final TextView tvOrderphone = new TextView( this );
            TextView tvOrderemail = new TextView( this );
            TextView tvOrderinstruction = new TextView( this );


            tvOrderid.setText( getallOrder.get( counter ).getOrderId() );
            tvOrderName.setText( getallOrder.get( counter ).getOrderName() );
            tvOrderlist.setText( getallOrder.get( counter ).getOrderList() );
            tvOrderphone.setText( getallOrder.get( counter ).getOrderPhone() );
            tvOrderemail.setText( getallOrder.get( counter ).getOrderEmail() );
            tvOrderinstruction.setText( getallOrder.get( counter ).getOrderInstruction() );

            layoutList.addView( tvOrderid );
            layoutList.addView( tvOrderName );
            layoutList.addView( tvOrderlist );
            layoutList.addView( tvOrderphone );
            layoutList.addView( tvOrderemail );
            layoutList.addView( tvOrderinstruction );

            counter++;

            layoutOrderList.addView( layoutList );
        }
    }

}
