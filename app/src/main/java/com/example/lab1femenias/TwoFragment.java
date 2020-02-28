package com.example.lab1femenias;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class TwoFragment extends Fragment {


    Button button;
    onBlockPressedListener listener;
    TextView textView;

    public interface onBlockPressedListener {
        public void onBlockPressed();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof onBlockPressedListener) {
            listener = (onBlockPressedListener) context; // callback
        } else { throw new ClassCastException ("Context "+context.toString()
                +" must implement onButtonPressedListener");
        }
    }


    public void setTextSize (int size){
        textView.setTextSize(size);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle saved) {
        View view = inflater.inflate(R.layout.fragm_two, container, false);

        button = (Button) view.findViewById(R.id.but_block);
        textView = (TextView) view.findViewById(R.id.tv_fragm2);

        button.setOnClickListener(new View.OnClickListener() { // anonymous class
            @Override
            public void onClick(View view) { // can not access to global atributes
                listener.onBlockPressed();
            }
        });

        return view;
    }



}
