package com.poly.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedQueries({
		@NamedQuery(name = "Video.findByKeyword", query = "SELECT DISTINCT o.video FROM Favorite o"
				+ " WHERE o.video.title LIKE :keyword"),
		@NamedQuery(name = "Video.findByUser", query = "SELECT o.video FROM Favorite o" + " WHERE o.user.id=:id"),
		@NamedQuery(name = "Video.findInRange", query = "SELECT DISTINCT o.video FROM Favorite o"
				+ " WHERE o.likeDate BETWEEN :min AND :max"),
		@NamedQuery(name = "Video.findInMonths", query = "SELECT DISTINCT o.video FROM Favorite o"
				+ " WHERE month(o.likeDate) IN (:months)") })
@NamedNativeQueries({
		@NamedNativeQuery(name = "Report.random10", query = "SELECT TOP 10 * FROM VIDEO ORDER BY newid()", resultClass = Video.class) })

@Entity
@Table(name = "VIDEO")

public class Video {
	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "POSTER")
	private String poster;

	@Column(name = "VIEWS")
	private String views;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "ACTIVE")
	private boolean active;

	@OneToMany(mappedBy = "video")
	private List<Favorite> favorites;

	@OneToMany(mappedBy = "video")
	private List<Share> shares;

	public Video() {
		super();
	}

	public Video(String id, String title, String poster, String views, String description, boolean active) {
		super();
		this.id = id;
		this.title = title;
		this.poster = poster;
		this.views = views;
		this.description = description;
		this.active = active;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getViews() {
		return views;
	}

	public void setViews(String views) {
		this.views = views;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
