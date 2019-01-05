package com.john.hellotoast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private int mCount; //Store the number of counts
    private TextView mShowCount; // Store a reference to the textView

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowCount = findViewById(R.id.show_count); // Find the element with its ID from the xml file, cast it to a TextView and store it in the mShowCount variable
    }

    public void showToast(View view)
    {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);

        toast.show();
    }

    public void countUp(View view)
    {
        mCount++;

        if (mShowCount != null)
            mShowCount.setText(String.valueOf(mCount)); // Assign the variable mCount to the mShowCount variable
    }

    public void countReset(View view)
    {
        mCount = 0;

        if (mShowCount != null)
            mShowCount.setText(String.valueOf(mCount)); // Assign the variable mCount to the mShowCount variable
    }
}
