package comqwera.mingrisoft.shousi.activity.fragment;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;



import comqwera.mingrisoft.shousi.DAO.Login1DAO;
import comqwera.mingrisoft.shousi.DAO.MyuserDAO;
import comqwera.mingrisoft.shousi.activity.Adapter.UserAdapter;
import comqwera.mingrisoft.shousi.activity.activity.Login;

import comqwera.mingrisoft.shousi.activity.activity.Orderfinish;
import comqwera.mingrisoft.shousi.activity.activity.R;
import comqwera.mingrisoft.shousi.activity.activity.updatewode;
import comqwera.mingrisoft.shousi.model.User;


import java.util.ArrayList;
import java.util.List;


public class User_fragment extends Basefragment{
    private List<User>userlist=new ArrayList<User> ();
    private Button tuichudenglu;
    private ImageView img_show;
    private Button xiugaixinxi;
    private int u_id;
    private ImageView daifukuang_picture;
    public View initview() {
        View view = View.inflate (mcontext, R.layout.user_activity, null);

        tuichudenglu = view.findViewById (R.id.tuichudenglu);
        daifukuang_picture= view.findViewById(R.id.daifukuang_picture);
        daifukuang_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(getActivity(),Orderfinish.class);
                startActivity(a);
            }
        });
        tuichudenglu.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Login1DAO login1DAO=new Login1DAO(getActivity());
                login1DAO.detele(1);
                Intent intent = new Intent (getActivity (), Login.class);
                startActivity (intent);
                getActivity().finish();
            }
        });//退出按钮
        xiugaixinxi= view.findViewById(R.id.xiugaixinxi);
        xiugaixinxi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent wodexinxi=new Intent(getActivity(),updatewode.class);
                startActivity(wodexinxi);
                getActivity().finish();
            }
        });//修改信息按钮
        img_show= view.findViewById(R.id.wode_picture);

        img_show.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                goToast();

            }

        });

        initUser ();//初始化信息数据
        UserAdapter adapter = new UserAdapter(getActivity (), R.layout.user_xinxi, userlist);
        ListView listView = view.findViewById (R.id.list_view);
        listView.setAdapter (adapter);
        return view;
    }
    private String username;
    private String address1;
    private String phone1;
    private String _id;
    private String zhiwen1;
    private void initUser(){//信息显示

        Login1DAO login1DAO=new Login1DAO(getActivity());   //建立login1对象

        u_id=login1DAO.find(1).getU_id();      //通过login1dao查找u_id
        zhiwen1=Integer.toString(login1DAO.find(1).getZhiwen());
        _id= Integer.toString (u_id);
        MyuserDAO myuserDAO=new MyuserDAO(getActivity());
        username=myuserDAO.find2(u_id).getU_nickname();
        address1=myuserDAO.find2(u_id).getU_adress();
        phone1=myuserDAO.find2(u_id).getU_phone2();
        User id=new User ("用户id:",_id);
        userlist.add (id);
        User nicheng=new User ("昵称:" ,username);
        userlist.add (nicheng);
        User zhiwen=new User ("电话号码:",phone1);
        userlist.add (zhiwen);
        User phone=new User ("指纹识别:",zhiwen1);
        userlist.add (phone);
        User address=new User ("地址:",address1);
        userlist.add (address);
     //显示我的信息
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



                }

                img_show.setImageBitmap(bitmap);

            } catch (Exception e) {

                e.printStackTrace();

            }

        }



    }
}


