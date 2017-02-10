package com.lj.redwine.pojo;

import java.util.List;

public class User {
    private Integer user_id;//用户id

    private String username;//用户名

    private String password;//密码

    private String avatar;//头像

    private String telephone;//用户电话
    
    private List<Address> addressList;//一个用户对应多个地址
    
    private List<Favorites> favoritesList;//一个用户有多个收藏
    
    private List<Evaluation> evaluationList;//一个用户对应多条评价
    
    private List<Orders> ordersList;//一个用户对应多个订单 
    
    private List<ShoppingCart> shoppingCartList;//一个用户有多个购物车

    public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public List<Favorites> getFavoritesList() {
		return favoritesList;
	}

	public void setFavoritesList(List<Favorites> favoritesList) {
		this.favoritesList = favoritesList;
	}

	public List<Evaluation> getEvaluationList() {
		return evaluationList;
	}

	public void setEvaluationList(List<Evaluation> evaluationList) {
		this.evaluationList = evaluationList;
	}

	public List<Orders> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(List<Orders> ordersList) {
		this.ordersList = ordersList;
	}

	public List<ShoppingCart> getShoppingCartList() {
		return shoppingCartList;
	}

	public void setShoppingCartList(List<ShoppingCart> shoppingCartList) {
		this.shoppingCartList = shoppingCartList;
	}

}