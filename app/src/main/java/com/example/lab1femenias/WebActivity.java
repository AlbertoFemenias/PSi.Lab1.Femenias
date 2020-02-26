package com.example.lab1femenias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("NUEVO ESTADO","WebActivity en estado OnCreate()");
        setContentView(R.layout.activity_web);

        TextView txtVw = (TextView)findViewById(R.id.tv_address);
        WebView  webVw = (WebView)findViewById(R.id.webView);


        //CUANDO SE CARGA LA ACTIVIDAD SE CARGA TAMBIEN LA URL
        Intent myIntent = getIntent(); // gets the previously created intent
        if (myIntent.getData() != null) {
            String data = myIntent.getData().toString();
            String url = "http://"+data;
            txtVw.setText(url);
            webVw.loadUrl(url);
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("NUEVO ESTADO","WebActivity en estado OnStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("NUEVO ESTADO","WebActivity en estado OnResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("NUEVO ESTADO","WebActivity en estado OnPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("NUEVO ESTADO","WebActivity en estado OnStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("NUEVO ESTADO","WebActivity en estado OnRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("NUEVO ESTADO","WebActivity en estado OnDestroy()");
    }
}
