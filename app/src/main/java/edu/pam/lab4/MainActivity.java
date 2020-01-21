package edu.pam.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import edu.pam.lab4.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startAsynctTask();
    }

    public void startAsynctTask(){
        ExampleAsyncTask task = new ExampleAsyncTask();
        task.execute(70);
    }

    private class ExampleAsyncTask extends AsyncTask<Integer,Integer,String> {
        ImageView img;
        AnimationDrawable frameAnimation;
        Button startButton = (Button) findViewById(R.id.button);
        Button stopButton = (Button) findViewById(R.id.button2);
        int i=0;
        @SuppressLint("WrongThread")
        @Override
        protected String doInBackground(final Integer... integers) {
            startButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(frameAnimation.isRunning())
                    {

                        frameAnimation.stop();
                    }
                    for(i=0; i <integers[0];i++){

                        frameAnimation.start();
                    }
                }
            });

            stopButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    frameAnimation.stop();
                }

            });
            return "Finish";
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            img = (ImageView) findViewById(R.id.imageView);
            img.setBackgroundResource(R.drawable.animation);
            frameAnimation = (AnimationDrawable) img.getBackground();

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }
    }
}
