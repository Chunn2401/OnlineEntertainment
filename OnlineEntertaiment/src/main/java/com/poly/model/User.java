package com.poly.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="USERS")
public class User {
	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "FULLNAME")
	private String fullname;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "ADMIN")
	private Boolean admin;
	
	@OneToMany(mappedBy = "user")
	List<Favorite> favorites;
	
	@OneToMany(mappedBy = "user")
	List<Share> shares;
	
	
	
	public User() {
		super();
	}

	public User(String id, String password, String fullname, String email, Boolean admin) {
		super();
		this.id = id;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.admin = admin;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public List<Favorite> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	public List<Share> getShares() {
		return shares;
	}

	public void setShares(List<Share> shares) {
		this.shares = shares;
	}
	
}
