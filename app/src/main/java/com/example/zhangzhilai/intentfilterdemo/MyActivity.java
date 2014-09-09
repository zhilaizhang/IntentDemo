package com.example.zhangzhilai.intentfilterdemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MyActivity extends ActionBarActivity {

    private Button mIntentButton;  //隐式调用测试button
    private Button mSchemeButton;  //scheme测试button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        findViews();
        initListener();
    }

    private void findViews(){
        mIntentButton = (Button)findViewById(R.id.intent_demo_button);
        mSchemeButton = (Button)findViewById(R.id.scheme_button);
    }

    private void initListener(){
        mIntentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.example.intent.test");
                startActivity(intent);
            }
        });
        mSchemeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.example.scheme");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse("scheme_test://com.example.zhangzhilai.intentfilterdemo"));
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
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
