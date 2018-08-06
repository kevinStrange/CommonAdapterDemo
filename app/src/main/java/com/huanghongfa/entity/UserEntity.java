package com.huanghongfa.entity;

/**
 * Created by huanghongfa on 2018/8/6.
 */

public class UserEntity {

    private String name;//用户名
    private int age;//年龄
    private int headPortrait;//头像
    private String urlImage;//网络图片

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(int headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
