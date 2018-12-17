package comqwera.mingrisoft.shousi.activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.*;

import comqwera.mingrisoft.shousi.activity.activity.R;
import comqwera.mingrisoft.shousi.activity.activity.ShoppingCartActivity;

public class Type_fragment extends Basefragment  {
/*
    private ListView listleft;
    private PinnedHeaderListView pinnedListView;
    private boolean isScroll = true;
    private Leftadapter adapter;
    private String[] leftStr = new String[]{"热销", "优惠", "新品上市","美味经典",  "饮品"};
    private boolean[] flagArray = {true, false, false, false, false, false, false, false, false};
    private String[][] rightStr = new String[][]{{"三文鱼寿司", "樱花之恋", "韩风烤肉卷"},
                                                   {"三文鱼寿司", "樱花之恋", "韩风烤肉卷"},
                                                   {"三文鱼寿司", "樱花之恋", "韩风烤肉卷"},
                                                   {"三文鱼寿司", "樱花之恋", "韩风烤肉卷"},
                                                   {"三文鱼寿司", "樱花之恋", "韩风烤肉卷"},
    };


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
        listleft=(ListView)getActivity().findViewById(R.id.left_listview);
        pinnedListView=(PinnedHeaderListView) getActivity().findViewById(R.id.pinnedListView);
        final Rightadapter sectionedAdapter = new Rightadapter(getActivity(), leftStr, rightStr);
        pinnedListView.setAdapter(sectionedAdapter);
        adapter = new Leftadapter(getActivity(), leftStr, flagArray);
        listleft.setAdapter(adapter);
        listleft.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
                isScroll = false;

                for (int i = 0; i < leftStr.length; i++) {
                    if (i == position) {
                        flagArray[i] = true;
                    } else {
                        flagArray[i] = false;
                    }
                }
                adapter.notifyDataSetChanged();
                int rightSection = 0;
                for (int i = 0; i < position; i++) {
                    rightSection += sectionedAdapter.getCountForSection(i) + 1;
                }
                pinnedListView.setSelection(rightSection);

            }

        });

        pinnedListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView arg0, int scrollState) {
                switch (scrollState) {
                    // 当不滚动时
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                        // 判断滚动到底部
                        if (pinnedListView.getLastVisiblePosition() == (pinnedListView.getCount() - 1)) {
                            listleft.setSelection(ListView.FOCUS_DOWN);
                        }

                        // 判断滚动到顶部
                        if (pinnedListView.getFirstVisiblePosition() == 0) {
                            listleft.setSelection(0);
                        }

                        break;
                }
            }

            int y = 0;
            int x = 0;
            int z = 0;

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (isScroll) {
                    for (int i = 0; i < rightStr.length; i++) {
                        if (i == sectionedAdapter.getSectionForPosition(pinnedListView.getFirstVisiblePosition())) {
                            flagArray[i] = true;
                            x = i;
                        } else {
                            flagArray[i] = false;
                        }
                    }
                    if (x != y) {
                        adapter.notifyDataSetChanged();
                        y = x;
                        if (y == listleft.getLastVisiblePosition()) {
//                            z = z + 3;
                            listleft.setSelection(z);
                        }
                        if (x == listleft.getFirstVisiblePosition()) {
//                            z = z - 1;
                            listleft.setSelection(z);
                        }
                        if (firstVisibleItem + visibleItemCount == totalItemCount - 1) {
                            listleft.setSelection(ListView.FOCUS_DOWN);
                        }
                    }
                } else {
                    isScroll = true;
                }
            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //ButterKnife.unbind(this);
    }
*/
    private TextView hot;
    private TextView discount;
    private TextView new_foods;
    private TextView delicious;
    private TextView snack;
    private TextView drink;


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
        hot=(TextView)getActivity().findViewById(R.id.hot);
        discount=(TextView)getActivity().findViewById(R.id.discount);
        new_foods=(TextView)getActivity().findViewById(R.id.new_foods);
        delicious=(TextView)getActivity().findViewById(R.id.delicious);
        snack=(TextView)getActivity().findViewById(R.id.snack);
        drink=(TextView)getActivity().findViewById(R.id.drink);
        hot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getActivity(), ShoppingCartActivity.class);
                startActivity(intent1);
            }
        });
        discount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getActivity(), ShoppingCartActivity.class);
                startActivity(intent1);
            }
        });
        new_foods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getActivity(), ShoppingCartActivity.class);
                startActivity(intent1);
            }
        });
        delicious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getActivity(), ShoppingCartActivity.class);
                startActivity(intent1);
            }
        });
        snack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getActivity(), ShoppingCartActivity.class);
                startActivity(intent1);
            }
        });
        drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getActivity(), ShoppingCartActivity.class);
                startActivity(intent1);
            }
        });

    }
    /*
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.hot:
                Intent intent1=new Intent(getActivity(), ShoppingCartActivity.class);
                startActivity(intent1);
            case R.id.discount:
                Intent intent2=new Intent(getActivity(), ShoppingCartActivity.class);
                startActivity(intent2);
            case R.id.new_foods:
                Intent intent3=new Intent(getActivity(), ShoppingCartActivity.class);
                startActivity(intent3);
            case R.id.delicious:
                Intent intent4=new Intent(getActivity(), ShoppingCartActivity.class);
                startActivity(intent4);
            case R.id.snack:
                Intent intent5=new Intent(getActivity(), ShoppingCartActivity.class);
                startActivity(intent5);
            case R.id.drink:
                Intent intent6=new Intent(getActivity(), ShoppingCartActivity.class);
                startActivity(intent6);
        }

    }*/



}


