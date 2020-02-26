package com.example.lab1femenias;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    final int REQUEST_CODE = 554;
    static String KEY = "url";

    EditText edTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("NUEVO ESTADO","MainActivity en estado OnCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edTxt = (EditText)findViewById(R.id.et_text);
        Button btn_param = (Button)findViewById(R.id.but_param);
        Button btn_main = (Button)findViewById(R.id.but_main);
        Button btn_web = (Button)findViewById(R.id.but_implicit);


        Button btn_ok = (Button)findViewById(R.id.but_ok);

        //CUANDO SE CARGA LA ACTIVIDAD SE CARGA TAMBIEN LA URL
        Intent myIntent = getIntent(); // gets the previously created intent
        if (myIntent.getExtras() != null) {
            String url = myIntent.getExtras().getString(KEY, "");
            edTxt.setText(url);
        } else {
            btn_ok.setEnabled(false);
        }

        //CUANDO SE CLICKA "PARAM" SE MANDA LA URL A LA ACTIVITY PARAM
        btn_param.setOnClickListener(new OnClickListener() { // anonymous class
            @Override
            public void onClick(View view) { // can not access to global atributes
                Intent myIntent;
                myIntent = new Intent(MainActivity.this, ParamActivity.class);
                myIntent.putExtra(KEY, edTxt.getText().toString());
                startActivityForResult(myIntent, REQUEST_CODE);
            }
        });

        //CUANDO SE CLICKA "MAIN" SE MANDA LA URL A LA ACTIVITY MAIN
        btn_main.setOnClickListener(new OnClickListener() { // anonymous class
            @Override
            public void onClick(View view) { // can not access to global atributes
                Intent myIntent;
                myIntent = new Intent(MainActivity.this, MainActivity.class);
                myIntent.putExtra(KEY, edTxt.getText().toString());
                startActivityForResult(myIntent, REQUEST_CODE);
            }
        });

        //CUANDO SE CLICKA "OK" SE MANDA LA URL DE VUELTA A QUIEN LO HA LLAMADO
        btn_ok.setOnClickListener(new View.OnClickListener() { // anonymous class
            @Override
            public void onClick(View view) { // can not access to global atributes
                Intent data = new Intent(); // create a new Intent to send back
                data.putExtra(KEY , edTxt.getText().toString()); // add the parameter(s)
                setResult(RESULT_OK, data); // indicate that all it is correct
                finish();
            }
        });


        //IMPLICIT INTENT
        btn_web.setOnClickListener(new View.OnClickListener() { // anonymous class
            @Override
            public void onClick(View view) { // can not access to global atributes
                // Create the text message with a string
                Uri uri = Uri.parse( edTxt.getText().toString() );
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setDataAndType(uri, "text/plain");
                if (sendIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(sendIntent);
                }
            }
        });


    }


    //RECIBE LOS DATOS DE VUELTA - ESTA FUNC LA LLAMA EL SISTEMA SOLITO!!!
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        // check if result is ok or not (e.g.: RESULT_CANCEL)
        // AND check the request code (to consider different resquests)
        if (requestCode==REQUEST_CODE && resultCode==RESULT_OK) {
            // Use the same key to recover the returned value
            edTxt.setText(data.getStringExtra(KEY));
        }
    }

    //EL USER TIENE QUE PULSAR EL BACK DOS VECES EN MENOS DE DOS SEGUNDOS
    private long mBackPressed;

    @Override
    public void onBackPressed()
    {
        if (mBackPressed + 2000 > System.currentTimeMillis())
        {
            super.onBackPressed();
            return;
        }
        else { Toast.makeText(getBaseContext(), "Tap back button in order to exit", Toast.LENGTH_SHORT).show(); }

        mBackPressed = System.currentTimeMillis();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("NUEVO ESTADO","MainActivity en estado OnStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("NUEVO ESTADO","MainActivity en estado OnResume()");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("NUEVO ESTADO","MainActivity en estado OnPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("NUEVO ESTADO","MainActivity en estado OnStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("NUEVO ESTADO","MainActivity en estado OnRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("NUEVO ESTADO","MainActivity en estado OnDestroy()");
    }
}
