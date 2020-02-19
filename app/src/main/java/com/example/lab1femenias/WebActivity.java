package com.example.lab1femenias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        TextView txtVw = (TextView)findViewById(R.id.tv_address);
        WebView  webVw = (WebView)findViewById(R.id.webView);


        //CUANDO SE CARGA LA ACTIVIDAD SE CARGA TAMBIEN LA URL
        Intent myIntent = getIntent(); // gets the previously created intent
        if (myIntent.getData() != null) {
            String data = myIntent.getData().toString();
            String url = "https://"+data;
            txtVw.setText(url);
            webVw.loadUrl(url);
        }
    }
}
