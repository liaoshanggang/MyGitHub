package com.lanqiao.vo;

import java.util.Date;

public class House {
	private Integer id;
	private Integer userId;
	private Integer streetId;
	private Integer typeId;
	// 几室
	private Integer room;
	// 几厅
	private Integer hall;
	private String title;
	private String description;
	private Double price;
	private Date pubdate;
	// 联系电话
	private String telephone;
	// 联系人
	private String contact;
	private Double lowPrice;
	private Double hiPrice;
	// 实体关联
	private UserInfo userInfo;
	private Street street;
	private Types types;

	public House() {
		super();
	}

	public House(Integer id, Integer userId, Integer streetId, Integer typeId,
			Integer room, Integer hall, String title, String description,
			Double price, Date pubdate, String telephone, String contact) {
		super();
		this.id = id;
		this.userId = userId;
		this.streetId = streetId;
		this.typeId = typeId;
		this.room = room;
		this.hall = hall;
		this.title = title;
		this.description = description;
		this.price = price;
		this.pubdate = pubdate;
		this.telephone = telephone;
		this.contact = contact;
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

	public Integer getStreetId() {
		return streetId;
	}

	public void setStreetId(Integer streetId) {
		this.streetId = streetId;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getRoom() {
		return room;
	}

	public void setRoom(Integer room) {
		this.room = room;
	}

	public Integer getHall() {
		return hall;
	}

	public void setHall(Integer hall) {
		this.hall = hall;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getPubdate() {
		return pubdate;
	}

	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "House [id=" + id + ", userId=" + userId + ", streetId="
				+ streetId + ", typeId=" + typeId + ", room=" + room
				+ ", hall=" + hall + ", title=" + title + ", description="
				+ description + ", price=" + price + ", pubdate=" + pubdate
				+ ", telephone=" + telephone + ", contact=" + contact + "]";
	}

	public Double getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(Double lowPrice) {
		this.lowPrice = lowPrice;
	}

	public Double getHiPrice() {
		return hiPrice;
	}

	public void setHiPrice(Double hiPrice) {
		this.hiPrice = hiPrice;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Street getStreet() {
		return street;
	}

	public void setStreet(Street street) {
		this.street = street;
	}

	public Types getTypes() {
		return types;
	}

	public void setTypes(Types types) {
		this.types = types;
	}

}
