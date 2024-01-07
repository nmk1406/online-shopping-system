package dto;

import java.sql.Date;

public class Order {
	private int id;
	private Date orderDate;
	private double totalMoney;
	private String fullname;
	private String address;
	private String email;
	private String phone;
	private int userId;

	public Order() {
		
	}

	public Order(int id, Date orderDate, double totalMoney, String fullname, String address, String email, String phone,
			int userId) {
		this.id = id;
		this.orderDate = orderDate;
		this.totalMoney = totalMoney;
		this.fullname = fullname;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}