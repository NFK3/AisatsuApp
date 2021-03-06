package jp.techacademy.naoto.fukuda.aisatsuapp;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.TimePicker;

import java.sql.Time;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 =(Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);

        mTextView = (TextView)findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.button1){
            showTimePickerDialog();
        }
    }

    private void showTimePickerDialog(){
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener(){
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI_PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));

                        if (0 <= hourOfDay && hourOfDay < 2) {
                            mTextView.setText("こんばんは");
                        }else if (2 <= hourOfDay && hourOfDay < 10){
                            mTextView.setText("おはよう");
                        }else if(10 <= hourOfDay && hourOfDay < 18){
                            mTextView.setText("こんにちは");
                        }else if (18 <= hourOfDay && hourOfDay <= 24) {
                            mTextView.setText("こんばんは");
                        }
                    }
                },
                13, //初期値（時間)
                0, //初期値 (分)
                true);
        timePickerDialog.show();

    }
}
