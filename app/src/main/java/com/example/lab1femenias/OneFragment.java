package com.example.lab1femenias;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;





public class OneFragment extends Fragment {

    SeekBar seekbar;
    onSeekbarChangedListener listener;

    public interface onSeekbarChangedListener {
        void onSeekBarChanged(int position);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof onSeekbarChangedListener) {
            listener = (onSeekbarChangedListener) context; // callback
        } else { throw new ClassCastException ("Context "+context.toString()
                +" must implement onSeekbarChangedListener");
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle saved) {
        View view = inflater.inflate(R.layout.fragm_one, container, false);
        seekbar = (SeekBar) view.findViewById(R.id.sb_fragm1);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) { }

            public void onStopTrackingTouch(SeekBar seekBar) {
                listener.onSeekBarChanged(progressChangedValue);
            }
        });

        return view;
    }





}
