package com.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import com.poly.utils.JpaUtils;
import com.poly.model.Report;
import com.poly.model.Video;

public class ReportDao {
	EntityManager em = JpaUtils.getEntityManager();
	
	public List<Report> getTopLike(boolean all, int firstResult, int maxResult){
		String jpql = "SELECT new Report(o.video.id, count(o) as SOLIKE, max(o.likeDate), min(o.likeDate)) FROM Favorite o GROUP BY o.video.id ORDER BY SOLIKE DESC";
		TypedQuery<Report> query = em.createQuery(jpql,Report.class);
		if(!all) {
			query.setFirstResult(firstResult);
			query.setMaxResults(maxResult);
		}
		List<Report> list = query.getResultList();
		return list;
	}
	
	public List<Report> getInfor(){
		String jpql = "SELECT new Report(o.video.title, count(o), max(o.likeDate), min(o.likeDate)) FROM Favorite o GROUP BY o.video.title";
		TypedQuery<Report> query = em.createQuery(jpql,Report.class);
		List<Report> list = query.getResultList();
		return list;
	}
	
	public List<Integer> selectYear(){
		String jpql = "SELECT year(o.likeDate) FROM Favorite o GROUP BY year(o.likeDate)";
		TypedQuery<Integer> query = em.createQuery(jpql,Integer.class);
		List<Integer> list = query.getResultList();
		return list;
	}
	
	public List<Video> getTongHop(Integer year){
		StoredProcedureQuery query = em.createStoredProcedureQuery("Report.favoriteByYear");
		query.setParameter("year", year);
		List<Video> list = query.getResultList();
		return list;
	}
	
	
}
