package com.example.amence_a.newshop.fragment;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.amence_a.newshop.R;
import com.example.amence_a.newshop.to.NewsData;

import java.util.ArrayList;

/**
 * Created by Amence_A on 2016/7/26.
 */
public class LeftMenuFragment extends BaseFragment {
    private ArrayList<NewsData.NewsMenuData> mMenuList;
    private ListView mListView;
    private MenuAdapter menuAdapter;

    @Override
    public View init() {
        View view = View.inflate(mActivity, R.layout.fragment_left_menu, null);
        mListView = (ListView) view.findViewById(R.id.lv_list);
        return view;
    }

    public void initData() {

    }

    public void setMenuData(NewsData data) {
        mMenuList = data.data;
        menuAdapter = new MenuAdapter();
//        mListView.setAdapter(menuAdapter);
        Log.v("Amence", mMenuList.toString());
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
            return null;
        }
    }
}
