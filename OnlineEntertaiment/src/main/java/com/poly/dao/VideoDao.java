package com.poly.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import com.poly.model.Report;
import com.poly.model.Video;

import com.poly.utils.JpaUtils;

public class VideoDao extends AbstractEmtityDao<Video>{
	
	public VideoDao() {
		super(Video.class);
	}
	private EntityManager em = JpaUtils.getEntityManager();
	
	public List<Video> findByKeyWord(String keyword){
		String jpql = "SELECT DISTINCT o.video FROM Favorite o"
						+" WHERE o.video.title LIKE :keyword";
		TypedQuery<Video> query = em.createQuery(jpql,Video.class);
		query.setParameter("keyword","%"+ keyword + "%");
		List<Video> list = query.getResultList();
		return list;
	}
	
	public List<Video> showVideo(boolean favorite){
		String jpql = "SELECT o FROM Video o WHERE o.favorites IS EMPTY";
		if(favorite) {
			jpql = "SELECT o FROM Video o WHERE o.favorites IS NOT EMPTY";
		}
		TypedQuery<Video> query = em.createQuery(jpql,Video.class);
		List<Video> list = query.getResultList();
		return list;
	}
	
	public List<Video> findByKeywordNameQR(String keyword){
		TypedQuery<Video> query = em.createNamedQuery("Video.findByKeyword",Video.class);
		query.setParameter("keyword","%" + keyword + "%");
		List<Video> list = query.getResultList();
		return list;
	}
	
	public List<Video> findByUserNameQR(String id){
		TypedQuery<Video> query = em.createNamedQuery("Video.findByUser",Video.class);
		query.setParameter("id", id);
		List<Video> list = query.getResultList();
		return list;
	}
	
	public List<Video> findInRangeNameQR(Date from,Date to){
		TypedQuery<Video> query = em.createNamedQuery("Video.findInRange",Video.class);
		query.setParameter("min", from);
		query.setParameter("max", to);
		List<Video> list = query.getResultList();
		return list;
	}
	
	public List<Video> findInMonthsNameQR(List<Integer> months){
		TypedQuery<Video> query = em.createNamedQuery("Video.findInMonths",Video.class);
		query.setParameter("months", months);
		List<Video> list = query.getResultList();
		return list;
	}
	
	public List<Video> getRandom10(){
		Query query = em.createNamedQuery("Report.random10");
		List<Video> list = query.getResultList();
		return list;
	}
	
	public List<Video> getTopViews(boolean all, int firstResult, int maxResult) {
		String jpql = "SELECT o FROM Video o ORDER BY o.views DESC";
		TypedQuery<Video> query = em.createQuery(jpql,Video.class);
		if(!all) {
			query.setFirstResult(firstResult);
			query.setMaxResults(maxResult);
		}
		List<Video> list = query.getResultList();
		
		return list;

	}
	

	
	
	
	public static void main(String[] args) {
		VideoDao videoDao = new VideoDao();
		
		for (Video video : videoDao.getTopViews(false, 0, 4)) {
			System.out.println("title: "+ video.getTitle());
		}
	}
	
}
