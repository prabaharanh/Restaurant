package com.example.admin.kavik;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity {

    Button btnAddmenu, btnSearchmenu, btntblSearch, btnAddmenuItem, btnUpdatemenuItem, btnSearchmenulist;
    LinearLayout layoutAddmenu, layoutSearch, layoutTable;
    EditText etmenuId, etmenuName, etmenuDescription, etmenuPrice, etmenuType, etsearchId;

    int counter=0;
    int size=0;
    ArrayList<GetTable> getallTable;
    final Database db = new Database(this);






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);




        btnAddmenu = (Button) findViewById(R.id.btnAddmenu);
        btnSearchmenu = (Button) findViewById(R.id.btnSearchMenu);
        btnSearchmenulist= (Button) findViewById( R.id.btnSearchmenulist );
        btntblSearch = (Button) findViewById(R.id.btntblSearch);
        layoutAddmenu = (LinearLayout) findViewById(R.id.layoutAddmenu);
        layoutSearch = (LinearLayout) findViewById(R.id.layoutSearch);
        layoutTable = (LinearLayout) findViewById(R.id.layoutTable);
        btnAddmenuItem =(Button) findViewById(R.id.btnAddmenuitem);
        btnUpdatemenuItem =(Button) findViewById(R.id.btnUpdatemenuitem);
        etmenuId= (EditText) findViewById(R.id.etmenuId);
        etmenuName= (EditText) findViewById(R.id.etmenuName);
        etmenuDescription= (EditText) findViewById(R.id.etmenuDescription);
        etmenuPrice= (EditText) findViewById(R.id.etmenuPrice);
        etmenuType= (EditText) findViewById(R.id.etmenuType);
        etsearchId = (EditText) findViewById( R.id.etsearchId );

        etmenuId.setOnFocusChangeListener( new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Toast.makeText(AdminActivity.this, "Enter menu ID to add", Toast.LENGTH_SHORT).show();
            }
        } );
        etmenuType.setOnFocusChangeListener( new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Toast.makeText( AdminActivity.this,"DINNER, ENTREE or LUNCH", Toast.LENGTH_SHORT).show();
            }
        } );


        getallTable = new Database(this).getTablelist();
        size=new Database(this).getTotalTableItems();

        loadTable();




         btnAddmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(layoutAddmenu.getVisibility() == View.VISIBLE){
                    layoutAddmenu.setVisibility(View.GONE);
                } else {
                    layoutAddmenu.setVisibility(View.VISIBLE);
                }
            }
        });

        btnSearchmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layoutSearch.getVisibility() == View.VISIBLE){
                    layoutSearch.setVisibility(View.GONE);
                }else{
                    layoutSearch.setVisibility((View.VISIBLE));
                }

            }
        });
        btntblSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(layoutTable.getVisibility()== View.VISIBLE){
                    layoutTable.setVisibility(View.GONE);
                }else {
                    layoutTable.setVisibility(View.VISIBLE);


                }
            }
        });
        btnAddmenuItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer menuId = Integer.valueOf(etmenuId.getText().toString());
                String menuName = etmenuName.getText().toString();
                String menuDescription = etmenuDescription.toString();
                Integer menuPrice =Integer.valueOf(etmenuPrice.getText().toString());
                String menuType = etmenuPrice.getText().toString();


                db.insertMenu(menuId, menuName, menuDescription, menuPrice, menuType);



                Toast.makeText(AdminActivity.this, "Menu Entered", Toast.LENGTH_SHORT ).show();

            }
        });
        btnUpdatemenuItem.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer menuId = Integer.valueOf(etmenuId.getText().toString());
                String menuName = etmenuName.getText().toString();
                String menuDescription = etmenuDescription.toString();
                Integer menuPrice =Integer.valueOf(etmenuPrice.getText().toString());
                String menuType = etmenuPrice.getText().toString();
                db.updateMenuList(menuId, menuName, menuDescription, menuPrice, menuType);
            }
        } );
        btnSearchmenulist.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        db.getMenulist();
                        Toast.makeText( AdminActivity.this,"Searching Item ", Toast.LENGTH_SHORT).show();
            }
        } );



    }


    private void loadTable() {

        for (int i=0; i<=(size-1); i++) {
            LinearLayout layoutTableList = new LinearLayout(this);


            layoutTableList.setOrientation(LinearLayout.VERTICAL);
            layoutTableList.setGravity(10);
           // layoutTableList.setActivityBackgroundColor(color);
            //tvTotal = findViewById(R.id.tvTotal);


            TextView tvtblDate = new TextView(this);
            TextView tvtblTime = new TextView(this);
           // tvtblDate.setTextSize(24);
            TextView tvtblPerson = new TextView(this);
            TextView tvtblName = new TextView(this);
            TextView tvtblPhone = new TextView(this);
            TextView tvtblEmail = new TextView(this);
            TextView tvtblInstruction = new TextView(this);


            tvtblDate.setText(getallTable.get(counter).getTblDate());
            tvtblTime.setText(getallTable.get(counter).getTblTime());
            tvtblPerson.setText(getallTable.get(counter).getTblPersons());
            tvtblName.setText(getallTable.get(counter).getTblName());
            tvtblPhone.setText(getallTable.get(counter).getTblPhone());
            tvtblEmail.setText(getallTable.get(counter).getTblEmail());
            tvtblInstruction.setText(getallTable.get(counter).getTblInstruction());


            layoutTableList.addView(tvtblDate);
            layoutTableList.addView(tvtblTime);
            layoutTableList.addView(tvtblPerson);
            layoutTableList.addView(tvtblName);
            layoutTableList.addView(tvtblEmail);
            layoutTableList.addView(tvtblInstruction);

            counter++;

            layoutTable.addView(layoutTableList);
        }


    }


}











