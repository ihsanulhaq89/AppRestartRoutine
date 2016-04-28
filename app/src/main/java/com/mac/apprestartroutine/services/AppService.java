package com.mac.apprestartroutine.services;

import android.app.ActivityManager;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import java.util.List;

public class AppService extends IntentService {
    public AppService() {
        super("AppService");
    }

    @Override
    protected void onHandleIntent(Intent workIntent) {

        ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningAppProcessInfo = am.getRunningAppProcesses();

        for (int i = 0; i < runningAppProcessInfo.size(); i++) {
            if(runningAppProcessInfo.get(i).processName.equals("com.mac.apprestartroutine")) {
                android.os.Process.killProcess(runningAppProcessInfo.get(i).pid);
                break;
            }
        }
        openApp(this, "com.mac.apprestartroutine");
        this.stopSelf();
        android.os.Process.killProcess(android.os.Process.myPid());
    }
    public void openApp(Context context, String packageName) {
        PackageManager manager = context.getPackageManager();
        Intent i = manager.getLaunchIntentForPackage(packageName);
        i.addCategory(Intent.CATEGORY_LAUNCHER);
        context.startActivity(i);
    }
}