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
import android.widget.*;


import comqwera.mingrisoft.shousi.DAO.Login1DAO;
import comqwera.mingrisoft.shousi.activity.activity.*;

import comqwera.mingrisoft.shousi.model.User;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class User_fragment extends Basefragment{
    private List<User>userlist=new ArrayList<User> ();
    private Button tuichudenglu;
    private ImageView img_show;
    private Button xiugaixinxi;
    private int u_id;
    private ImageView daifukuang_picture;
    private ImageView lishidingdan_picture;
    private ListView list_view;
    private int[] imageId = new int[]{R.mipmap.mymessage,R.mipmap.dingwei,R.mipmap.customer ,R.mipmap.aboutus};
    private String[] wenzi = new String[]{"我的信息","地址管理","联系商家","关于我们"};
    private int[] imageId1 = new int[]{R.mipmap.more,R.mipmap.more,R.mipmap.more,R.mipmap.more};

    public View initview() {
        View view = View.inflate (mcontext, R.layout.user_activity, null);
        list_view=(ListView)view.findViewById(R.id.list_view) ;
        tuichudenglu = view.findViewById (R.id.tuichudenglu);
        daifukuang_picture= view.findViewById(R.id.daifukuang_picture);
        lishidingdan_picture=view.findViewById(R.id.lishidingdan_picture);
        lishidingdan_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), MyorderActivity.class);
                startActivity(intent);
            }
        });
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



        img_show= view.findViewById(R.id.wode_picture);

        img_show.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                goToast();
            }
        });
        list();

        return view;
    }

    public void list(){
        List<Map<String,Object>> listItems = new ArrayList<>();
        for (int i = 0; i < imageId.length; i++ ){
            Map<String,Object> map = new HashMap<>();
            map.put("image",imageId[i]);
            map.put("text",wenzi[i]);
            map.put("image1",imageId1[i]);
            listItems.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(
                getActivity(),
                listItems,
                R.layout.my_user,
                new  String[]{"image","text","image1"},
                new int[] {R.id.image, R.id.text, R.id.image1}
        );
        list_view.setAdapter(adapter);
        //设置listview点击事件
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //position 点击的Item位置，从0开始算
                // Intent intent=new Intent();
                // intent.putExtra("xx","");//传递给下一个Activity的值
                //  startActivity(intent);//启动Activity
                if (position == 0){
                    startActivity(new Intent(getActivity(),MymessageActivity.class));}
                if (position == 1){
                    startActivity(new Intent(getActivity(),MyadressActivity.class));}
                if (position == 2){
                    startActivity(new Intent(getActivity(),CallusActivity.class));
                }
                if (position == 3){
                    startActivity(new Intent(getActivity(),AboutusActivity.class));
                }
            }
        });
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


