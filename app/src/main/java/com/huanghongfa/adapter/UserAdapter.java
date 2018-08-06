package com.huanghongfa.adapter;

import android.content.Context;

import com.huanghongfa.activity.R;
import com.huanghongfa.entity.UserEntity;
import com.huanghongfa.view.CommonViewHolder;

import java.util.List;


/**
 * Created by huanghongfa on 2018/8/6.
 */

public class UserAdapter extends CommonAdapter<UserEntity> {

    public UserAdapter(Context context, List<UserEntity> list) {
        super(context, list, R.layout.user_item_list);
    }

    /**
     * 复写抽象方法
     *
     * @param viewHolder 一个ViewHolder
     * @param userEntity 实体对象
     */
    @Override
    public void setViewContent(CommonViewHolder viewHolder, UserEntity userEntity) {
        //直接设置内容 链式调用
        viewHolder.setText(R.id.tvName, userEntity.getName())
                .setText(R.id.tvAge, String.valueOf(userEntity.getAge()))
                .setImageResource(R.id.IgHeadPortrait, userEntity.getHeadPortrait())
                .setNetworkImgByUrl(R.id.network_img, userEntity.getUrlImage());
    }
}
