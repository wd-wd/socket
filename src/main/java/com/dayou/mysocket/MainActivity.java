package com.dayou.mysocket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mStartSever;
    private Button mSendMessege;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       initView();
        initListener();
    }


    private void initView() {
        mStartSever = (Button) findViewById(R.id.startSever);
        mSendMessege = (Button) findViewById(R.id.sendMessege);
    }
    private void initListener() {
        mStartSever.setOnClickListener(this);
        mSendMessege.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.startSever:
                startServer();
                break;
            case  R.id.sendMessege:
                sendMessage();
                break;
        }
    }

    private void sendMessage() {
        SocketClient.sendMessage();
    }

    private void startServer() {
        SocketSever.startSever();
    }
}
