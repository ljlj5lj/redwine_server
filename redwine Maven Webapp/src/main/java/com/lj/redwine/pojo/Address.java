package com.lj.redwine.pojo;

public class Address {
    private Integer address_id;//地址id

    private String consignee;//收货人

    private String gender;//收货人性别

    private String consignee_phone;//收货人电话

    private String location_address;//定位地址

    private String detail_address;//详细地址
    
    private Integer user_delete;//用户是否删除地址

    private User user;//一个用户对应多个地址
    
    private Integer user_id;//用户id(外键)
    
    public Integer getAddress_id() {
		return address_id;
	}

	public Integer getUser_delete() {
		return user_delete;
	}



	public void setUser_delete(Integer user_delete) {
		this.user_delete = user_delete;
	}



	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}

	public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee == null ? null : consignee.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

	public String getConsignee_phone() {
		return consignee_phone;
	}

	public void setConsignee_phone(String consignee_phone) {
		this.consignee_phone = consignee_phone;
	}

	public String getLocation_address() {
		return location_address;
	}

	public void setLocation_address(String location_address) {
		this.location_address = location_address;
	}

	public String getDetail_address() {
		return detail_address;
	}

	public void setDetail_address(String detail_address) {
		this.detail_address = detail_address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
}