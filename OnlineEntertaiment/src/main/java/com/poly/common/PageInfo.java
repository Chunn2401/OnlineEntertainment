package com.poly.common;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

public class PageInfo {
	public static Map<PageType, PageInfo> pageRoute = new HashedMap();
	
	static {
		pageRoute.put(PageType.USER_MANAGEMENT_PAGE, new PageInfo("User Management", "/views/user/layout/menu.jsp", null));
	}
	
	public static void prepareAndForward(HttpServletRequest request, HttpServletResponse response,PageType pageType) throws ServletException, IOException {
		PageInfo page = pageRoute.get(pageType);
		
		request.setAttribute("page", page);
		
		request.getRequestDispatcher("/views/user/home.jsp").forward(request, response);
	}
	
	private String title;
	private String contentUrl;
	private String scriptUrl;
	
	public PageInfo(String title, String contentUrl, String scriptUrl) {
		super();
		this.title = title;
		this.contentUrl = contentUrl;
		this.scriptUrl = scriptUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContentUrl() {
		return contentUrl;
	}
	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}
	public String getScriptUrl() {
		return scriptUrl;
	}
	public void setScriptUrl(String scriptUrl) {
		this.scriptUrl = scriptUrl;
	}
	
	
}
