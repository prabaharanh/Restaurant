package com.example.admin.kavik;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "dbkavik";
    public static final Integer DATABASE_VERSION = 29;
    public static final String TABLE_MENU = "tbMenu";
    public static final String TABLE_BOOK = "tbReservation";
    public static final String TABLE_ORDER = "tbOrder";
    public static final String COLUMN_MENU_ID = "menuId";
    public static final String COLUMN_MENU_NAME = "menuName";
    public static final String COLUMN_MENU_DESCRIPTION = "menuDescription";
    public static final String COLUMN_MENU_PRICE = "menuPrice";
    public static final String COLUMN_MENU_TYPE = "menuType";
    public static final String COLUMN_ORDER_ID = "orderID";
    public static final String COLUMN_ORDER_CUS_NAME = "custName";
    public static final String COLUMN_ORDER_CUS_PHONENUMBER = "custPhonenumber";
    public static final String COLUMN_ORDER_CUS_EMAIL = "custEmail";
    public static final String COLUMN_ORDER_CUS_INSTRUCTION = "custInstruction";
    public static final String COLUMN_ORDER_CUS_LIST = "custList";
    public static final String COLUMN_TBL_DATE = "tblDate";
    public static final String COLUMN_TBL_TIME = "tblTime";
    public static final String COLUMN_TBL_NUMBERS = "tblNumber";
    public static final String COLUMN_TBL_NAME = "tblName";
    public static final String COLUMN_TBL_EMAIL = "tblEmail";
    public static final String COLUMN_TBL_PHONE = "tblPhone";
    public static final String COLUMN_TBL_INSTRUCTION = "tblInstruction";


    public Database(Context context) {
        super( context, DATABASE_NAME, null, DATABASE_VERSION );
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query1 = "Create table " + TABLE_MENU +
                "(" + COLUMN_MENU_ID + "INTEGER PRIMARY KEY, "
                + COLUMN_MENU_NAME + "TEXT, "
                + COLUMN_MENU_DESCRIPTION + "TEXT, "
                + COLUMN_MENU_PRICE + "NUMERIC, "
                + COLUMN_MENU_TYPE + "TEXT )";

        String query2 = "Create table " + TABLE_BOOK +
                "(" + COLUMN_TBL_DATE + "TEXT, "
                + COLUMN_TBL_TIME + "TEXT, "
                + COLUMN_TBL_NUMBERS + "TEXT, "
                + COLUMN_TBL_NAME + "TEXT, "
                + COLUMN_TBL_EMAIL + "TEXT, "
                + COLUMN_TBL_PHONE + "TEXT, "
                + COLUMN_TBL_INSTRUCTION + "TEXT )";

        String query3 = "Create table " + TABLE_ORDER +
                "(" + COLUMN_ORDER_ID + "INTEGER PRIMARY KEY, "
                + COLUMN_ORDER_CUS_NAME + "TEXT, "
                + COLUMN_ORDER_CUS_PHONENUMBER + "TEXT, "
                + COLUMN_ORDER_CUS_EMAIL + "TEXT, "
                + COLUMN_ORDER_CUS_LIST + "TEXT, "
                + COLUMN_ORDER_CUS_INSTRUCTION + "TEXT)";


        String insertbook1 = " Insert into " + TABLE_BOOK + "  Values('22/10/18', '18:30', '4', 'Praba', '0221606306', 'pharidass@outlook.com', 'Nothing')";
        String insertbook2 = " Insert into  " + TABLE_BOOK + "  Values('21/10/18', '16:30', '8', 'Shalu', '11222334455', 'pharidass@outlook.com', 'Nothing')";

        String insertmenu1 = " Insert into " + TABLE_MENU + " Values ( 1, 'Chicken noodles', 'Chicken cooked with noodles', 23, 'Lunch')";
        String insertmenu2 = " Insert into " + TABLE_MENU + " Values ( 2, 'Chicken Rice', 'Chicken cooked with Rice', 23, 'Dinner')";
        String insertmenu3 = " Insert into " + TABLE_MENU + " Values ( 3, 'New Zealand Whitebait', 'Free range egg, lemon, creme franchie',  28,  'Entrée')";
        String insertmenu4 = " Insert into " + TABLE_MENU + " Values ( 4, 'Raw Kingfish', 'cucumber, kimchi, sesame, avocado, lime', 26, 'Entrée')";
        String insertmenu5 = " Insert into " + TABLE_MENU + " Values ( 5, 'New Season Asparagus', 'black garlic, chevre, pickled red onion, hollandaise, pine nuts', 23, 'Entrée')";
        String insertmenu6 = " Insert into " + TABLE_MENU + " Values ( 6, 'Seared Scallops', 'Brown butter, dill pickles, jamon serrano, parsley', 28, 'Entrée')";
        String insertmenu7 = " Insert into " + TABLE_MENU + " Values ( 7, 'Hawke Bay Lamb Belly', 'Chevre, kumara, mint, garden peas', 26, 'Entrée')";

        //String insertorder1 = " Insert into " + TABLE_ORDER + " Values ( 1, 'Praba', '0221606306', 'pharidass@outlook.com', '1,2,3,4', 'make it quick')";

        sqLiteDatabase.execSQL( query1 );
        sqLiteDatabase.execSQL( query2 );
        sqLiteDatabase.execSQL( query3 );

        sqLiteDatabase.execSQL( insertmenu1 );
        sqLiteDatabase.execSQL( insertmenu2 );
        sqLiteDatabase.execSQL( insertmenu3 );
        sqLiteDatabase.execSQL( insertmenu4 );
        sqLiteDatabase.execSQL( insertmenu5 );
        sqLiteDatabase.execSQL( insertmenu6 );
        sqLiteDatabase.execSQL( insertmenu7 );

        sqLiteDatabase.execSQL( insertbook1 );
        sqLiteDatabase.execSQL( insertbook2 );

       // sqLiteDatabase.execSQL( insertorder1 );



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL( " Drop table if exists " + TABLE_MENU );
        db.execSQL( " Drop table if exists " + TABLE_BOOK );
        db.execSQL( " Drop table if exists " + TABLE_ORDER );
        onCreate( db );

    }

    public void insertMenu(Integer menuId, String menuName, String menuDescription, Integer menuPrice, String menuType) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put( COLUMN_MENU_ID, menuId );
        contentValues.put( COLUMN_MENU_NAME, menuName );
        contentValues.put( COLUMN_MENU_DESCRIPTION, menuDescription );
        contentValues.put( COLUMN_MENU_PRICE, menuPrice );
        contentValues.put( COLUMN_MENU_TYPE, menuType );
        database.insert( TABLE_MENU, null, contentValues );
        database.close();
    }

    public void insertBook(String date, String time, String persons, String name, String phone, String email, String instruction) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put( COLUMN_TBL_DATE, date );
        contentValues.put( COLUMN_TBL_TIME, time );
        contentValues.put( COLUMN_TBL_NUMBERS, persons );
        contentValues.put( COLUMN_TBL_NAME, name );
        contentValues.put( COLUMN_TBL_PHONE, phone );
        contentValues.put( COLUMN_TBL_EMAIL, email );
        contentValues.put( COLUMN_TBL_INSTRUCTION, instruction );
        database.insert( TABLE_BOOK, null, contentValues );
        database.close();
    }
    public void insertOrder(String cusName, String cusPhone, String cusEmail, String cusInstruction){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put( COLUMN_ORDER_CUS_NAME,cusName);
        contentValues.put( COLUMN_ORDER_CUS_PHONENUMBER,cusPhone );
        contentValues.put( COLUMN_ORDER_CUS_EMAIL,cusEmail );
        contentValues.put( COLUMN_ORDER_CUS_INSTRUCTION,cusInstruction );
        database.close();
    }

    public Cursor getMenudata(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "Select * from tbMenu where id = " + id + "", null );
        return res;

    }




    public ArrayList<GetMenu> getMenulist() {
        String query = "Select * from " + TABLE_MENU;

        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery( query, null );

        ArrayList<GetMenu> localCompleteMenu = new ArrayList<GetMenu>();

        if (cursor.moveToFirst()) ;
        {
            do {
                GetMenu aMenutlist = new GetMenu( cursor.getInt( 0 ), cursor.getString( 1 ), cursor.getString( 2 ), cursor.getInt( 3 ), cursor.getString( 4 ) );
                localCompleteMenu.add( aMenutlist );
            } while (cursor.moveToNext());
        }
        cursor.close();
        database.close();
        return localCompleteMenu;


    }

    public int getTotalMenuItems() {
        SQLiteDatabase database = this.getReadableDatabase();
        String query = " Select * from " + TABLE_MENU;
        Cursor cursor = database.rawQuery( query, null );
        int counter = cursor.getCount();

        cursor.close();
        database.close();

        return counter;
    }

    public ArrayList<GetTable> getTablelist() {
        String query = "Select * from " + TABLE_BOOK;

        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery( query, null );

        ArrayList<GetTable> localCompleteTable = new ArrayList<GetTable>();

        if (cursor.moveToFirst()) ;
        {
            do {
                GetTable aTablelist = new GetTable( cursor.getString( 0 ), cursor.getString( 1 ), cursor.getString( 2 ), cursor.getString( 3 ), cursor.getString( 4 ), cursor.getString( 5 ), cursor.getString( 6 ) );
                localCompleteTable.add( aTablelist );
            } while (cursor.moveToNext());
        }
        cursor.close();
        database.close();
        return localCompleteTable;
    }

    public int getTotalTableItems() {
        SQLiteDatabase database = this.getReadableDatabase();
        String query = " Select * from " + TABLE_BOOK;
        Cursor cursor = database.rawQuery( query, null );
        int counter = cursor.getCount();

        cursor.close();
        database.close();

        return counter;
    }

    public void updateMenuList(int menuId, String menuName, String menuDescription, int menuPrice, String menuType) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put( COLUMN_MENU_NAME, menuName );
        contentValues.put( COLUMN_MENU_DESCRIPTION, menuDescription );
        contentValues.put( COLUMN_MENU_PRICE, menuPrice );
        contentValues.put( COLUMN_MENU_TYPE, menuType );

        db.update( TABLE_MENU, contentValues, COLUMN_MENU_ID + " = " + menuId, null );
    }

    public ArrayList<GetOrder> getOrderlist() {
        String query = "Select * from " + TABLE_ORDER;

        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery( query, null );

        ArrayList<GetOrder> localCompleteOrder = new ArrayList<>();

        if (cursor.moveToFirst()) ;
        {
            do {
                GetOrder aOrderlist = new GetOrder( cursor.getString( 0 ), cursor.getString( 1 ), cursor.getString( 2 ), cursor.getString( 3 ), cursor.getString( 4 ), cursor.getString( 5 ) );
                localCompleteOrder.add( aOrderlist );
            } while (cursor.moveToNext());
        }
        cursor.close();
        database.close();
        return localCompleteOrder;
    }
    public int getTotalorder() {
        SQLiteDatabase database = this.getReadableDatabase();
        String query = " Select * from " + TABLE_ORDER;
        Cursor cursor = database.rawQuery( query, null );
        int counter = cursor.getCount();

        cursor.close();
        database.close();

        return counter;
    }



}
