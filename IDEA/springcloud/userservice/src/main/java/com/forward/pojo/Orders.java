package com.forward.pojo;

public class Orders {
    private Integer id;
    private Integer userId;
    private String orderDesc;

    public Orders() {
    }

    public Orders(Integer id, Integer userId, String orderDesc) {
        this.id = id;
        this.userId = userId;
        this.orderDesc = orderDesc;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderDesc='" + orderDesc + '\'' +
                '}';
    }
}
