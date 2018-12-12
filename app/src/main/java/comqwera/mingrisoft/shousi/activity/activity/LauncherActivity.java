package comqwera.mingrisoft.shousi.activity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;




public class LauncherActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstancestate){
        super.onCreate (savedInstancestate);
        setContentView (R.layout.activity_laucher);
        new Handler ().postDelayed (new Runnable () {
            @Override
            public void run() {
                //在主线程中执行
                startMainActivity();
            }
            private void startMainActivity() {
                Intent intent=new Intent (LauncherActivity.this,Login.class);
                startActivity (intent);
                finish ();
            }
        }, 2000);

    }
}
