package com.example.lab1femenias;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity  {

    final int REQUEST_CODE = 554;
    EditText edTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edTxt = (EditText)findViewById(R.id.et_text);
        Button btn_param = (Button)findViewById(R.id.but_param);

        //CUANDO SE CLICKA "OK" SE MANDA LA URL A LA ACTIVITY PARAM
        btn_param.setOnClickListener(new OnClickListener() { // anonymous class
            @Override
            public void onClick(View view) { // can not access to global atributes
                Intent myIntent;
                myIntent = new Intent(MainActivity.this, ParamActivity.class);
                myIntent.putExtra(ParamActivity.KEY, edTxt.getText().toString());
                startActivityForResult(myIntent, REQUEST_CODE);
            }
        });

    }


    //ESTA CLASE LA LLAMA EL SISTEMA SOLITO!!!
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        // check if result is ok or not (e.g.: RESULT_CANCEL)
        // AND check the request code (to consider different resquests)
        if (requestCode==REQUEST_CODE && resultCode==RESULT_OK) {
            // Use the same key to recover the returned value
            edTxt.setText(data.getStringExtra(ParamActivity.KEY));
        }
    }

    
}
