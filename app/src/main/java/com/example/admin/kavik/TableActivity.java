package com.example.admin.kavik;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

public class TableActivity extends AppCompatActivity {

    EditText etDate, etTime, etName, etPhone, etEmail,etSpinstruction;
    Button btnbook;
    Spinner tblSpinner;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        final Calendar myCalendar = Calendar.getInstance();


        etDate =(EditText) findViewById(R.id.etDate);
        etTime =(EditText) findViewById(R.id.etTime);
        etName =(EditText) findViewById(R.id.etName);
        etPhone =(EditText) findViewById(R.id.etPhone);
        etEmail =(EditText) findViewById(R.id.etEmail);
        etSpinstruction =(EditText) findViewById(R.id.etSpinstruction);
        btnbook = (Button) findViewById(R.id.btnBook);
        tblSpinner = (Spinner) findViewById(R.id.tblSpinner);


        final Database db = new Database(this);

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

            private void updateLabel() {
                String myFormat = "dd/MM/YY"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                etDate.setText(sdf.format(myCalendar.getTime()));
            }
        };

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(TableActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        etTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(TableActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        etTime.setText(hourOfDay + ":" + minute);

                    }
                },0, 0, false);
                timePickerDialog.show();

            }
        });

        btnbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = etDate.getText().toString();
                String time = etTime.getText().toString();
                String persons = tblSpinner.getSelectedItem().toString();
                String name = etName.getText().toString();
                String phone = etPhone.getText().toString();
                String email = etEmail.getText().toString();
                String spInstruction = etSpinstruction.getText().toString();

                //GetTable getTable = new GetTable(date, time, persons, name, phone, email, spInstruction);
              /*  getTable.setTblDate(date);
                getTable.setTblDate(time);
                getTable.setTblPersons(persons);
                getTable.setTblName(name);
                getTable.setTblPhone(phone);
                getTable.setTblEmail(email);
                getTable.setTblInstruction(spInstruction); */


                db.insertBook(date, time, persons, name, phone, email, spInstruction);
                Toast.makeText(TableActivity.this,"Table Booked on " +  date  +" at " + time +" for " + persons + " Persons,  you will receive confirmation shortly",Toast.LENGTH_LONG).show();
            }
        });





    }

}
