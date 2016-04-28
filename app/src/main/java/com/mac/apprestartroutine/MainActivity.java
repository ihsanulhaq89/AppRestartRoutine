package com.mac.apprestartroutine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mac.apprestartroutine.services.AppService;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAppService();
            }
        });
    }

    private void startAppService(){
        Intent mServiceIntent = new Intent(this, AppService.class);
        startService(mServiceIntent);
    }
}
