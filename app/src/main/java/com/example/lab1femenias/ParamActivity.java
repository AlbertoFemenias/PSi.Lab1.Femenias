package com.example.lab1femenias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ParamActivity extends AppCompatActivity {
    static String KEY = "url";

    final int REQUEST_CODE = 554;

    EditText edTxt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("NUEVO ESTADO","ParamActivity en estado OnCreate()");
        setContentView(R.layout.activity_param);

        edTxt = (EditText)findViewById(R.id.et_text_p);
        Button btn_ok = (Button)findViewById(R.id.but_ok_p);
        Button btn_main = (Button)findViewById(R.id.but_main_p);
        Button btn_param = (Button)findViewById(R.id.but_param_p);
        Button btn_web = (Button)findViewById(R.id.but_implicit_p);



        //CUANDO SE CARGA LA ACTIVIDAD SE CARGA TAMBIEN LA URL
        Intent myIntent = getIntent(); // gets the previously created intent
        if (myIntent.getExtras() != null) {
            String url = myIntent.getExtras().getString(KEY, "");
            edTxt.setText(url);
        }


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

        //CUANDO SE CLICKA "MAIN" SE MANDA LA URL A LA ACTIVITY MAIN
        btn_main.setOnClickListener(new View.OnClickListener() { // anonymous class
            @Override
            public void onClick(View view) { // can not access to global atributes
                Intent myIntent;
                myIntent = new Intent(ParamActivity.this, MainActivity.class);
                myIntent.putExtra(KEY, edTxt.getText().toString());
                startActivityForResult(myIntent, REQUEST_CODE);
            }
        });

        //CUANDO SE CLICKA "PARAM" SE MANDA LA URL A LA ACTIVITY PARAM
        btn_param.setOnClickListener(new View.OnClickListener() { // anonymous class
            @Override
            public void onClick(View view) { // can not access to global atributes
                Intent myIntent;
                myIntent = new Intent(ParamActivity.this, ParamActivity.class);
                myIntent.putExtra(KEY, edTxt.getText().toString());
                startActivityForResult(myIntent, REQUEST_CODE);
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

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        // check if result is ok or not (e.g.: RESULT_CANCEL)
        // AND check the request code (to consider different resquests)
        if (requestCode==REQUEST_CODE && resultCode==RESULT_OK) {
            // Use the same key to recover the returned value
            edTxt.setText(data.getStringExtra(KEY));
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("NUEVO ESTADO","ParamActivity en estado OnStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("NUEVO ESTADO","ParamActivity en estado OnResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("NUEVO ESTADO","ParamActivity en estado OnPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("NUEVO ESTADO","ParamActivity en estado OnStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("NUEVO ESTADO","ParamActivity en estado OnRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("NUEVO ESTADO","ParamActivity en estado OnDestroy()");
    }
}
