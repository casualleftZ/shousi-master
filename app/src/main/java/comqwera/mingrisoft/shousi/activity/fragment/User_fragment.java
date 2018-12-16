package comqwera.mingrisoft.shousi.activity.fragment;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import comqwera.mingrisoft.shousi.DAO.Login1DAO;
import comqwera.mingrisoft.shousi.activity.activity.Login;
import comqwera.mingrisoft.shousi.activity.activity.R;
import comqwera.mingrisoft.shousi.model.User;
import comqwera.mingrisoft.shousi.activity.Adapter.UserAdapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




public class User_fragment extends Basefragment{
    private List<User>userlist=new ArrayList<User> ();
    private Button tuichudenglu;
    private ImageView img_show;




    public View initview() {
        View view = View.inflate (mcontext, R.layout.user_activity, null);

        tuichudenglu = (Button) view.findViewById (R.id.tuichudenglu);
        img_show=(ImageView)view.findViewById(R.id.wode_picture);
        img_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToast();
            }
        });


        //退出登录
        tuichudenglu.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Login1DAO login1DAO=new Login1DAO(getActivity());
                login1DAO.detele(1);
                Intent intent = new Intent (getActivity (), Login.class);
                startActivity (intent);
                getActivity().finish();
            }
        });

        initUser ();//初始化信息数据
        UserAdapter adapter = new UserAdapter (getActivity (), R.layout.user_xinxi, userlist);
        ListView listView = view.findViewById (R.id.list_view);
        listView.setAdapter (adapter);

        return view;
    }




    private void initUser(){
        User id=new User ("用户id:","001");
        userlist.add (id);
        User nicheng=new User ("昵称:" ,"...");
        userlist.add (nicheng);
        User phone=new User ("电话号码:","1111111");
        userlist.add (phone);
        User address=new User ("地址:","江西师范大学");
        userlist.add (address);
    }
    public void initDate(){
        super.initDate();

    }


    private void goToast() {

        final String[] item = {"相册","拍照"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("请选择获取头像方式：");
        builder.setItems(item, new DialogInterface.OnClickListener() {


            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        xc = 0;
                        goXiangChe();
                        break;
                    case 1:
                        xc=1;
                        goXiangJi();
                        break;
                }
            }
        });
        builder.create().show();
    }
    private void goXiangJi() {

        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, 1);
        } else {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT,false);
            startActivityForResult(intent, 1);
        }

    }
    protected void goXiangChe() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, 111);
    }

    private Bitmap bitmap;
    private int xc;
    //不管是拍照还是在相册里选择相片，都会调用这个方法
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            ContentResolver cr = getActivity().getContentResolver();
            try {
                if (xc == 0) {
                    bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                } else {
                    Bundle bundle = data.getExtras();
                     bitmap = (Bitmap) bundle.get("data");
//                    bitmap = data.getParcelableExtra("data");
//                }
//                if (uri == null) {
//                    uri = Uri.parse(MediaStore.Images.Media.insertImage(getActivity().getContentResolver(), bitmap, null, null));
                }
                img_show.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}


