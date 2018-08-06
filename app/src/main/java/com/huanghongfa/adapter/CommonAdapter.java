package com.huanghongfa.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.huanghongfa.view.CommonViewHolder;

import java.util.List;


/**
 * Created by huanghongfa on 2018/8/6.
 */

public abstract class CommonAdapter<T> extends BaseAdapter {

    protected Context mContext;//上下文
    protected List<T> mCommonList;//
    private int mLayoutId;

    public CommonAdapter(Context context, List<T> list, int layoutId) {
        this.mContext = context;
        this.mCommonList = list;
        this.mLayoutId = layoutId;
    }

    @Override
    public int getCount() {
        return mCommonList == null ? 0 : mCommonList.size();
    }

    @Override
    public T getItem(int position) {
        return mCommonList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


//    @Override
//    public int getItemViewType(int position) {
//        return getItem(position).getType() == 1 ? 1 : 0;
//    }

    /**
     * 封装getView方法
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //得到一个ViewHolder
        CommonViewHolder viewHolder = CommonViewHolder.get(mContext, convertView, parent, mLayoutId, position);
        //设置控件内容
        setViewContent(viewHolder, (T) getItem(position));
        //返回复用的View
        return viewHolder.getConvertView();
    }

    /**
     * 提供抽象方法，来设置控件内容
     *
     * @param viewHolder 一个ViewHolder
     * @param t          一个数据集
     */
    public abstract void setViewContent(CommonViewHolder viewHolder, T t);
}
