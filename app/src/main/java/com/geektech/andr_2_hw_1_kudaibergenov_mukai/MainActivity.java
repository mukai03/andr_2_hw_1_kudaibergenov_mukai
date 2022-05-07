package com.geektech.andr_2_hw_1_kudaibergenov_mukai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etTheme;
    private EditText etText;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.et_email);
        etTheme = findViewById(R.id.et_theme);
        etText = findViewById(R.id.et_text);

        btnSend = findViewById(R.id.btn_send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!etEmail.getText().toString().isEmpty() && !etTheme.getText().toString().isEmpty()
                && !etText.getText().toString().isEmpty()) {

                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{etEmail.getText().toString()});
                    intent.putExtra(Intent.EXTRA_SUBJECT, etTheme.getText().toString());
                    intent.putExtra(Intent.EXTRA_TEXT, etText.getText().toString());
                    intent.setData(Uri.parse("mailto:"));
                    if (intent.resolveActivity(getPackageManager()) !=null){
                        startActivity(intent);
                    }else {
                        Toast.makeText(MainActivity.this, "There is on application that support this action",
                                Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(MainActivity.this, "Please fill all the fields",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}