package com.john.hellotoast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
        private int mCount;
        private TextView mShowCount;
        private static final String LOG_TAG = MainActivity.class.getSimpleName();
        public final static String MESSAGE = "com.john.hellotoast.MESSAGE";

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
                super.onCreate(savedInstanceState);

                setContentView(R.layout.activity_main);

                mShowCount = findViewById(R.id.show_count);

                Log.d(LOG_TAG, "Second activity created!");
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
                        mShowCount.setText(String.valueOf(mCount));
        }

        public void countReset(View view)
        {
                mCount = 0;

                if (mShowCount != null)
                        mShowCount.setText(String.valueOf(mCount));
        }

        public void showSecondActivity(View view)
        {
                Intent newActivity = new Intent(this, SecondActivity.class);

                newActivity.putExtra(MESSAGE, "Hello, mister");

                startActivityForResult(newActivity, 1);
        }

        public void onActivityResult(int requestCode, int resultCode, Intent data)
        {
                super.onActivityResult(requestCode, resultCode, data);

                if (requestCode == 1)
                {
                        if (resultCode == RESULT_OK)
                        {
                                String reply = data.getStringExtra(SecondActivity.RETURN_MESSAGE);

                                Log.d(LOG_TAG, reply);
                        }
                        else
                        {
                                Log.d(LOG_TAG, getString(R.string.no_response));
                        }
                }
        }
}
