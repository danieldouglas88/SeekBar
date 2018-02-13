package com.daniel.seekbar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends Activity implements SeekBar.OnSeekBarChangeListener{

    private TextView textView;
    private TextView textView2;
    private TextView textView4;
    private TextView textView5;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get reference
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        //set listener
        seekBar.setOnSeekBarChangeListener(this);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        Toast.makeText(getApplicationContext(), "Seek bar progress " +
                progress, Toast.LENGTH_SHORT).show();
        textView.setText(progress + "M");

        DecimalFormat df = new DecimalFormat("#.##");
        double result = progress *1.62137;
        textView2.setText(df.format(result) + "KM");

        textView4.setText(progress + "KM");
        textView5.setText(df.format(progress / 1.609344 ) + "M");


    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        Toast.makeText(getApplicationContext(), "seekbar progress ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
