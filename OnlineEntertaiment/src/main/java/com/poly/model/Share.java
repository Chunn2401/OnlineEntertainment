package com.poly.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="SHARE")
public class Share {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "SHAREDATE")
	private Date ShareDate;
	
	@ManyToOne
	@JoinColumn(name = "USERID")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "VIDEOID")
	private Video video;

	public Share() {
		super();
	}

	public Share(Integer id, String email, Date shareDate, User user, Video video) {
		super();
		this.id = id;
		this.email = email;
		ShareDate = shareDate;
		this.user = user;
		this.video = video;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getShareDate() {
		return ShareDate;
	}

	public void setShareDate(Date shareDate) {
		ShareDate = shareDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}
	
}
