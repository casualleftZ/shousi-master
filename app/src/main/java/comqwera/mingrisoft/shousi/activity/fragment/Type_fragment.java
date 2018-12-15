package comqwera.mingrisoft.shousi.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import comqwera.mingrisoft.shousi.activity.Adapter.Leftadapter;
import comqwera.mingrisoft.shousi.activity.Adapter.Rightadapter;
import comqwera.mingrisoft.shousi.activity.View.PinnedHeaderListView;
import comqwera.mingrisoft.shousi.activity.activity.R;

public class Type_fragment extends Basefragment {

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
    }


