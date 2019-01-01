package comqwera.mingrisoft.shousi.activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import comqwera.mingrisoft.shousi.activity.View.Lmenu;
import comqwera.mingrisoft.shousi.activity.activity.R;
import comqwera.mingrisoft.shousi.activity.activity.ShoppingCartActivity;

public class Type_fragment extends Basefragment  {




    @Override
    public View initview() {
        View view=View.inflate(mcontext, R.layout.type_fragment,null);


        return view;
    }
    public void initDate(){
        super.initDate();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Lmenu menu = getActivity().findViewById(R.id.lmenu);
        menu.setonMenuClickListener(new Lmenu.onMenuClickListener() {
            @Override
            public void hot() {
                Intent intent=new Intent(getActivity(),ShoppingCartActivity.class);
                startActivity(intent);

            }

            @Override
            public void discount() {
                Intent intent=new Intent(getActivity(),ShoppingCartActivity.class);
                startActivity(intent);

            }

            @Override
            public void new_foods() {
                Intent intent=new Intent(getActivity(),ShoppingCartActivity.class);
                startActivity(intent);

            }

            @Override
            public void delicious() {
                Intent intent=new Intent(getActivity(),ShoppingCartActivity.class);
                startActivity(intent);

            }

            @Override
            public void snack() {
                Intent intent=new Intent(getActivity(),ShoppingCartActivity.class);
                startActivity(intent);

            }

            @Override
            public void drink() {
                Intent intent=new Intent(getActivity(),ShoppingCartActivity.class);
                startActivity(intent);

            }
        });


    }


}


