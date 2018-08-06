package com.huanghongfa.manage;

import com.huanghongfa.activity.R;
import com.huanghongfa.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huanghongfa on 2018/8/6.
 * 用户数据管理类
 */

public class UserDataManage {

    //这里的单例主要是考虑到线程安全着想，也可以使用其他方式实现单例
    private static class Holder {
        private static UserDataManage INSTANCE = new UserDataManage();
    }

    private UserDataManage() {

    }

    public static UserDataManage getInstance() {
        return Holder.INSTANCE;
    }


    /**
     * 获取用户数据
     * @return
     */
    public List<UserEntity> getUserData() {
        List<UserEntity> entityList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            UserEntity entity = new UserEntity();
            entity.setAge(21);
            entity.setName("小明");
            entity.setHeadPortrait(R.mipmap.ic_launcher);
            entity.setUrlImage("https://a-ssl.duitang.com/uploads/blog/201406/05/20140605130526_xGV2r.thumb.700_0.jpeg");
            entityList.add(entity);
        }
        return entityList;
    }

    /**
     * 显示view的接口监听
     */
    public interface IShowViewListener {

        void showView(List<UserEntity> mListUserEntity);

    }
}
