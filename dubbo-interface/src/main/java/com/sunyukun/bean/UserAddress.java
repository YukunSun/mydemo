package com.sunyukun.bean;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2021/7/3 22:59
 * Blog: sunyukun.com
 */
public class UserAddress {
    private Integer userId;
    private String province;
    private String county;

    public UserAddress(Integer userId, String province, String county) {
        this.userId = userId;
        this.province = province;
        this.county = county;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "userId='" + userId + '\'' +
                ", province='" + province + '\'' +
                ", county='" + county + '\'' +
                '}';
    }
}
