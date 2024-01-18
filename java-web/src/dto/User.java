package dto;

public class User {
	private int id;
	private String email;
	private String password;
	private String phone;
	private int status;
	private int roleId;

	public User() {

	}

	public User(int id, String email, String password, String phone, int status, int roleId) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.status = status;
		this.roleId = roleId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", phone=" + phone + ", status="
				+ status + ", roleId=" + roleId + "]";
	}
}