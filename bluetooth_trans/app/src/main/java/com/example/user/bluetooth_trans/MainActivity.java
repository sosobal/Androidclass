package com.example.user.bluetooth_trans;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.BtSend);
        button.setOnClickListener(this);
        button = (Button) findViewById(R.id.BtYes);
        button.setOnClickListener(this);
        button = (Button) findViewById(R.id.BtNo);
        button.setOnClickListener(this);
        button = (Button) findViewById(R.id.checkbox);
        button.setOnClickListener(this);

        SeekBar bar = (SeekBar)findViewById(R.id.seek_bar);
        bar.setOnSeekBarChangeListener(this);
        bar.setMax(1000);
    }

    @Override
    public void onClick(View v) {
        String str = new String();
        switch (v.getId()) {
            case R.id.BtYes:
                str = "\"예\"버튼을 눌렀습니다.";
                break;
            case R.id.BtNo:
                str = "\"아니오\"버튼을 눌렀습니다.";
                break;
            case R.id.BtSend:
                str = "\"전송\"버튼을 눌렀습니다.";

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("전송 문자열");
                EditText editText = (EditText)findViewById(R.id.edit_text);
                String dialogstr = String.valueOf(editText.getText());
                builder.setMessage(dialogstr);
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setPositiveButton("OK", null);
                builder.setNegativeButton("Cancel", null);

                AlertDialog alter = builder.create();
                alter.show();
                break;

            case R.id.checkbox:
                TextView textView2 = (TextView) findViewById(R.id.textView2);
                CheckBox checkBox = (CheckBox)findViewById(R.id.checkbox);
                    if (checkBox.isChecked()) textView2.setText("항상켜기");
                    else textView2.setText("항상켜지않기");

                    str = "체크박스를 눌렀습니다";
                    break;
        }
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Toast.makeText(getApplicationContext(), "밝기가 변경되었습니다", Toast.LENGTH_LONG).show();

        String str = String.valueOf(progress);
        EditText textField = (EditText)findViewById(R.id.edit_text);
        textField.setText(str);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
