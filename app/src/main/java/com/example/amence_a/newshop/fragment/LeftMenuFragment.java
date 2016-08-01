package com.example.amence_a.newshop.fragment;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.amence_a.newshop.R;
import com.example.amence_a.newshop.activity.MainActivity;
import com.example.amence_a.newshop.base.imp.NewsCenterPager;
import com.example.amence_a.newshop.to.NewsData;
import com.example.amence_a.newshop.util.SlidingUtil;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;

/**
 * Created by Amence_A on 2016/7/26.
 */
public class LeftMenuFragment extends BaseFragment {
    private ArrayList<NewsData.NewsMenuData> mMenuList;
    private ListView mListView;
    private MenuAdapter menuAdapter;
    private int mCurrentPos;

    @Override
    public View init() {
        View view = View.inflate(mActivity, R.layout.fragment_left_menu, null);
        mListView = (ListView) view.findViewById(R.id.lv_list);
        return view;
    }

    public void initData() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mCurrentPos = position;
                menuAdapter.notifyDataSetChanged();
                setCurrentMenuDetailPager(position);
                SlidingUtil.toggleSlidingMenu(mActivity);
            }
        });
    }



    /**
     * 点击侧边栏时，切换NewsCenterPager的页面
     *
     * @param position
     */
    private void setCurrentMenuDetailPager(int position) {
        MainActivity mainActivity = (MainActivity) mActivity;
        ContentFragment contentFragment = mainActivity.getContentFragment();
        NewsCenterPager newsCenterPager = contentFragment.getNewsCenterPager();
        newsCenterPager.setCurrentMenuDetailPager(position);
    }

    public void setMenuData(NewsData data) {
        mMenuList = data.data;
        menuAdapter = new MenuAdapter();
        mListView.setAdapter(menuAdapter);

    }

    class MenuAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mMenuList.size();
        }

        @Override
        public NewsData.NewsMenuData getItem(int position) {
            return mMenuList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(mActivity, R.layout.list_menu_item, null);
            TextView tvTitle = (TextView) view.findViewById(R.id.tv_title);
            NewsData.NewsMenuData newsMenuData = getItem(position);
            tvTitle.setText(newsMenuData.title);
            if (mCurrentPos == position) {// 判断当前绘制的view是否被选中
                // 显示红色
                tvTitle.setEnabled(true);
            } else {
                // 显示白色
                tvTitle.setEnabled(false);
            }

            return view;
        }
    }
}
