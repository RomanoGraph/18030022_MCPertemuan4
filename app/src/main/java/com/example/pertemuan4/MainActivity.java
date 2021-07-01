package com.example.pertemuan4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public abstract class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText phonenumber;
    EditText masukanurl;
    EditText masukanlokasi;
    EditText masukantext;
    Button buttonphonenumber;
    Button buttonmasukanlokasi;
    Button buttonmasukanurl;
    Button buttonmasukantext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phonenumber = findViewById(R.id.edtPhonenumber);
        masukanurl =findViewById(R.id.edtMasukanUrl);
        masukanlokasi = findViewById(R.id.edtMasukanLokasi);
        masukantext = findViewById(R.id.edtMasukanText);
        buttonphonenumber = findViewById(R.id.btnPhonenumber);
        buttonphonenumber.setOnClickListener(this);
        buttonmasukanlokasi = findViewById(R.id.btnMasukanLokasi);
        buttonmasukanlokasi.setOnClickListener(this);
        buttonmasukanurl = findViewById(R.id.btnMasukanUrl);
        buttonmasukanurl.setOnClickListener(this);
        buttonmasukantext =findViewById(R.id.btnMasukanText);
        buttonmasukantext.setOnClickListener(this);
    }
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnPhonenumber:
                if (phonenumber.getText().toString()==null || phonenumber.getText().toString().trim().equals("")){
                    Toast.makeText(getBaseContext(),"Tolong Isi Terlebih Dahulu", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent dialPhone = new Intent(Intent.ACTION_DIAL,
                            Uri.parse("tel:" + phonenumber.getText().toString()));
                    startActivity(dialPhone);
                }
                break;
            case R.id.btnMasukanUrl:
                if (masukanurl.getText().toString()==null || masukanurl.getText().toString().trim().equals("")){
                    Toast.makeText(getBaseContext(),"Tolong Isi Terlebih Dahulu", Toast.LENGTH_LONG).show();
                }
                else {
                    String url = masukanurl.getText().toString();
                    if (!url.startsWith("http://") && !url.startsWith("https://")) {
                        url = "http://" + url;
                        Intent openWebsite = new
                                Intent(Intent.ACTION_VIEW, Uri.parse
                                (url));
                        startActivity(openWebsite);
                        break;
                    }
                }
            case R.id.btnMasukanLokasi:
                if (masukanlokasi.getText().toString()==null || masukanlokasi.getText().toString().trim().equals("")){
                    Toast.makeText(getBaseContext(),"Tolong Isi Terlebih Dahulu", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent openLocation = new
                            Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" +
                            masukanlokasi.getText().toString()));
                    startActivity(openLocation);
                }
                break;
            case R.id.btnMasukanText:
                if (masukantext.getText().toString()==null || masukantext.getText().toString().trim().equals("")){
                    Toast.makeText(getBaseContext(),"Tolong Isi Terlebih Dahulu", Toast.LENGTH_LONG).show();
                }
                else {
                    ShareCompat.IntentBuilder
                            .from(this)
                            .setType("text/plan")
                            .setChooserTitle("Buka Teks Dengan : "
                            )
                            .setText(masukantext.getText().toString()).startChooser();
                }
                break;
        }
    }
}
