package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;

    private Toast toast;

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @SuppressLint({"ResourceType", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
    }

    public void showToast(View view) {
        this.toast = Toast.makeText(this, R.string.hello_toast, Toast.LENGTH_SHORT);
        toast.show();
    }

    @SuppressLint("ResourceType")
    public void countToast(View view) {
        if (mShowCount != null) {
            mCount++;
            if(mCount > 100){
                this.toast = Toast.makeText(this, R.string.max_limit_count, Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
            mShowCount.setText(Integer.toString(mCount));
        }
    }

    public void decreaseToast(View view) {
        if (mShowCount != null) {
            mCount--;
            if(mCount < 0){
                this.toast = Toast.makeText(this, R.string.min_limit_count, Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
            mShowCount.setText(Integer.toString(mCount));
        }
    }
}