package comqwera.mingrisoft.shousi.activity.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CallusActivity extends AppCompatActivity {

    private TextView tv_call1,tv_call2;

    public static final int REQUEST_CALL_PERMISSION = 10111; //拨号请求码

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callus);
        tv_call1=(TextView)findViewById(R.id.tv_call1) ;
        tv_call2=(TextView)findViewById(R.id.tv_call2) ;
        tv_call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call("tel:15179152606");
            }
        });
        tv_call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call("tel:15179152606");
            }
        });


    }
    public boolean checkReadPermission(String string_permission,int request_code) {
        boolean flag = false;
        if (ContextCompat.checkSelfPermission(this, string_permission) == PackageManager.PERMISSION_GRANTED) {//已有权限
            flag = true;
        } else {//申请权限
            ActivityCompat.requestPermissions(this, new String[]{string_permission}, request_code);
        }
        return flag;
    }

    /**
     * 检查权限后的回调
     * @param requestCode 请求码
     * @param permissions  权限
     * @param grantResults 结果
     */
    @Override
    public void onRequestPermissionsResult(int requestCode,  String[] permissions,  int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CALL_PERMISSION: //拨打电话
                if (permissions.length != 0 && grantResults[0] != PackageManager.PERMISSION_GRANTED) {//失败
                    Toast.makeText(this,"请允许拨号权限后再试",Toast.LENGTH_SHORT).show();
                } else {//成功
                    call("tel:"     );
                }
                break;
        }
    }

    /**
     * 拨打电话（直接拨打）
     * @param telPhone 电话
     */
    public void call(String telPhone) {
        if (checkReadPermission(Manifest.permission.CALL_PHONE, REQUEST_CALL_PERMISSION)) {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(telPhone));
            startActivity(intent);
        }

    }
}
