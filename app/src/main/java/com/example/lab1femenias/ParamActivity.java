package com.example.lab1femenias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ParamActivity extends AppCompatActivity {
    static String KEY = "url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_param);

        final EditText edTxt = (EditText)findViewById(R.id.et_text_p);
        Button btn = (Button)findViewById(R.id.but_ok_p);

        //CUANDO SE CARGA LA ACTIVIDAD SE CARGA TAMBIEN LA URL
        Intent myIntent = getIntent(); // gets the previously created intent
        if (myIntent.getExtras() != null) {
            String url = myIntent.getExtras().getString(KEY, "");
            edTxt.setText(url);
        }


        //CUANDO SE CLICKA "OK" SE MANDA LA URL DE VUELTA A QUIEN LO HA LLAMADO
        btn.setOnClickListener(new View.OnClickListener() { // anonymous class
            @Override
            public void onClick(View view) { // can not access to global atributes
                Intent data = new Intent(); // create a new Intent to send back
                data.putExtra(KEY , edTxt.getText().toString()); // add the parameter(s)
                setResult(RESULT_OK, data); // indicate that all it is correct
                finish();
            }
        });

    }
}
