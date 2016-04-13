package com.delta.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Christopher on 4/7/2016.
 */
public class SecondActivity extends Activity {

    public  static  final  int DETAIL_REQUEST =1;
    private Button mButton = null;
    private Button mDetailButton = null;
    private TextView mSelectedView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mSelectedView = (TextView) findViewById(R.id.userSelection);


        mButton = (Button) findViewById(R.id.goFirstActivty);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), FirstActivity.class);
                startActivity(i);

            }
        });

        mDetailButton =(Button) findViewById(R.id.goDetailActivity);
        mDetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), DetailActivity.class);
                i.putExtra("KeySending", "Some data from SecondActivity");
                startActivityForResult(i, DETAIL_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK && requestCode == DETAIL_REQUEST){
            if(data.hasExtra("KeyForReturning")){
                String myValue = data.getExtras().getString("KeyForReturning");
                mSelectedView.setText(myValue);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.first, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
