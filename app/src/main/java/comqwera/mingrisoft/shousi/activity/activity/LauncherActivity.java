package comqwera.mingrisoft.shousi.activity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;
import comqwera.mingrisoft.shousi.activity.activity.R;
import comqwera.mingrisoft.shousi.DAO.Login1DAO;
import comqwera.mingrisoft.shousi.DAO.MyuserDAO;
import comqwera.mingrisoft.shousi.business.activity.Main2Activity;


public class LauncherActivity extends Activity {
    private int data;

    @Override
    protected void onCreate(Bundle savedInstancestate) {
        super.onCreate(savedInstancestate);
        setContentView(R.layout.activity_laucher);

        final Login1DAO login1DAO = new Login1DAO(LauncherActivity.this);
        if (login1DAO.getMaxId() == 1) {
            data = login1DAO.find(1).getZhiwen();
        } else data = 0;


        if (data == 0) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(login1DAO.getMaxId()==1&&login1DAO.find(1).getZt()==2){//在主线程中执行
                    startMainActivity2();}
                    else{
                        startMainActivity();
                    }
                }

                private void startMainActivity() {
                    Intent intent = new Intent(LauncherActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                private void startMainActivity2(){
                    Intent intent = new Intent(LauncherActivity.this, Main2Activity.class);
                    startActivity(intent);
                    finish();
                }
            }, 2000);
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    //在主线程中执行
                    startMainActivity();
                }


                private void startMainActivity() {
                    Intent intent = new Intent(LauncherActivity.this, Fingerprint.class);
                    startActivity(intent);
                    finish();
                }
            }, 2000);
        }
    }
}