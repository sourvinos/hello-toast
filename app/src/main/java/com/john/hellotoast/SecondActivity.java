package com.john.hellotoast;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity
{
    private static final String LOG_TAG = SecondActivity.class.getSimpleName();
    public final static String RETURN_MESSAGE = "com.john.hellotoast.RETURN_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent(); // New intent object
        String message = intent.getStringExtra(MainActivity.MESSAGE); // Get the message from the main activity
        TextView mMessage = findViewById(R.id.simpleText); // Find the textView in the second activity
        mMessage.setText(String.valueOf(message)); // Assing the message to the textView

        Log.d(LOG_TAG, "on--Create...");
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d(LOG_TAG,"on--Start...");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d(LOG_TAG,"on--Resume...");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d(LOG_TAG,"on--Pause...");
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.d(LOG_TAG,"on--Restart...");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d(LOG_TAG,"on--Stop...");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d(LOG_TAG,"on--Destroy...");
    }

    // Code to run when the respond button is clicked
    public void Respond(View view)
    {
        Intent returnIntent = new Intent(); // New intent object
        returnIntent.putExtra(RETURN_MESSAGE, "Hello from the second activity!"); // Message to return to the main activity
        setResult(RESULT_OK, returnIntent); // The response to the main activity was successful
        finish(); // Close the current (second) activity
    }

    // Code to run when the abort button is clicked
    public void Abort(View view)
    {
        finish(); // Close the current (second) activity
    }
}
