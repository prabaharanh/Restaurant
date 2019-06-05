package com.example.admin.kavik;

        import android.Manifest;
        import android.content.Context;
        import android.content.Intent;
        import android.content.pm.PackageManager;
        import android.net.Uri;
        import android.support.v4.app.ActivityCompat;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ImageButton;
        import android.widget.Spinner;
        import android.widget.TextView;

public class ContactActivity extends AppCompatActivity{
    Button btnSend;
    ImageButton btnCall;
    EditText etName, etEmail, etMessage;
    Spinner spSubject;
    TextView tvPhonenumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);


        btnCall = (ImageButton) findViewById(R.id.btnCall);
        btnSend = (Button) findViewById(R.id.btnSend);
        etName =(EditText) findViewById(R.id.etName);
        spSubject =(Spinner) findViewById(R.id.spSubject);

        etEmail =(EditText) findViewById(R.id.etEmail);
        etMessage =(EditText) findViewById(R.id.etMessage);
        tvPhonenumber =(TextView) findViewById(R.id.tvPhoneNumber);
        //spinner =(Spinner) findViewById(R.id.spinner);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = String.format("tel: %s",
                        tvPhonenumber.getText().toString());
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                Intent intent = callIntent.setData(Uri.parse(phoneNumber));

                //return;
                if (ActivityCompat.checkSelfPermission(ContactActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                    startActivity(callIntent);


            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String email = etEmail.getText().toString();
                String message =etMessage.getText().toString();
                String totalMessage = message + "," + name + "," + email;
                String mailId="prha131@ess.ais.ac.nz";
                Intent sendIntent = new Intent(Intent.ACTION_SENDTO,Uri.fromParts("mailto",mailId,null));
                sendIntent.putExtra(Intent.EXTRA_SUBJECT, spSubject.getSelectedItem().toString());

                sendIntent.putExtra(Intent.EXTRA_TEXT, totalMessage);
                startActivity(Intent.createChooser(sendIntent,"Choose Mail App"));
            }
        });



    }


}
