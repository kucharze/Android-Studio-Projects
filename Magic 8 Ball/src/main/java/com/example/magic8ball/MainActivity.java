package com.example.magic8ball;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
public static String fortunes[];
        //{"Hello","You will not get anything nice","This is a test","It is certain","Not very likely"};
    TextView tv_text;
    Typeface ttf;
    Random ran;
    MediaPlayer md;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ttf = Typeface.createFromAsset(getAssets(),"font.ttf");
        tv_text=(TextView)findViewById(R.id.eightBall);
       // tv_text.setTypeface(ttf);
        md = MediaPlayer.create(MainActivity.this, R.raw.swish);

        fortunes = getResources().getStringArray(R.array.fortunes);
        ran = new Random();

        tv_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int r = ran.nextInt(10);
                System.out.println(fortunes[r]);
                tv_text.setText(fortunes[r]);
                md.start();
            }
        });
    }
}
