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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="FAVORITE")
public class Favorite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "LIKEDATE")
	@Temporal(TemporalType.DATE)
	private Date likeDate;
	
	@ManyToOne
	@JoinColumn(name = "USERID")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "VIDEOID")
	private Video video;
	
	public Favorite() {
		super();
	}

	public Favorite(Integer id, Date likeDate, User user, Video video) {
		super();
		this.id = id;
		this.likeDate = likeDate;
		this.user = user;
		this.video = video;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getLikeDate() {
		return likeDate;
	}

	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
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
