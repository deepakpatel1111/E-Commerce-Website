package com.basic.entity;

import java.io.UnsupportedEncodingException;
import java.lang.invoke.MethodHandles.Lookup;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(length=10,name="user_id")
	private int id;
	
	@Column(length=100,name="user_name")
	private String name;
	
	@Column(length=100,name="user_email")
	private String email;

	@Column(length=100,name="user_password")
	private String password;

	@Column(length=12,name="user_phonNumber")
	private String phoneNumber;

	@Column(length=100,name="user_pic")
	private String  userPic;

	@Column(length=1000,name="user_address")
	private String address;
	
	@Column(length=100)
	private String userType;
	
	
	
	public User(int id, String name, String email, String password, String phoneNumber, String userPic,
			String address, String userType) {
		//super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.userPic = userPic;
		this.address = address;
		this.userType=userType;
	}


	public User(String name, String email, String password, String phoneNumber, String userPic, String address, String userType) {
		//super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.userPic = userPic;
		this.address = address;
		this.userType=userType;
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getUserPic() {
		return userPic;
	}


	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	


	

	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}


	//@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", phoneNumber="
				+ phoneNumber + ", userPic=" + userPic + ", address=" + address + "]";
	}
	
	
	
	
	
	
	

}
