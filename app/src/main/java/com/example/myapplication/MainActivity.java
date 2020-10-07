package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.mtext);
        button = (Button)findViewById(R.id.button);

        // show the last saved text on shared preference
        final SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);

        String item = sharedPreferences.getString("item","Nothing saved yet...");

        editText.setText(item);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("item",editText.getText().toString());
                editor.commit();

                Animation animation = new AlphaAnimation(1.0f,0.0f);
                animation.setDuration(1000);
                button.startAnimation(animation);
            }
        });




    }
}