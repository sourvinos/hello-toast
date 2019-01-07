package com.john.hellotoast;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity
{
        private static final String LOG_TAG = MainActivity.class.getSimpleName();
        public final static String RETURN_MESSAGE = "com.john.hellotoast.RETURN_MESSAGE";

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
                super.onCreate(savedInstanceState);

                setContentView(R.layout.activity_second);

                Log.d(LOG_TAG, "Second activity created!");

                Intent intent = getIntent(); // New intent object
                String message = intent.getStringExtra(MainActivity.MESSAGE); // Get the message from the previous activity
                TextView mMessage = findViewById(R.id.simpleText); // Find the textView
                mMessage.setText(String.valueOf(message)); // Assing the message to the textView
        }

        public void Respond(View view)
        {
                Intent returnIntent = new Intent();

                returnIntent.putExtra(RETURN_MESSAGE, "Hello from the second activity!");

                setResult(RESULT_OK, returnIntent);

                finish();
        }

        public void Abort(View view)
        {
                finish();
        }
}
