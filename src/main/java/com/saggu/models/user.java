
package com.saggu.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class user {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="User_id")
	int userId;
	@Column(name="username")
	String username;
	@Column(name="password")
	String password;
	 @OneToMany(cascade = CascadeType.ALL)
	 @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	List<role> role;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUserName(String userName) {
		this.username = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public List<role> getRole() {
		return role;
	}
	public void setRole(List<role> role) {
		this.role = role;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public user() {
	}
	
}
