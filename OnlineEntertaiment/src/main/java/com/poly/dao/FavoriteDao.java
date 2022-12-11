package com.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import com.poly.model.Favorite;
import com.poly.model.Video;
import com.poly.utils.JpaUtils;

public class FavoriteDao extends AbstractEmtityDao<Favorite>{

	public FavoriteDao() {
		super(Favorite.class);
	}
	
	
	private EntityManager em = JpaUtils.getEntityManager();
	
	public List<Favorite> findFavoriteByUserAndVideo(String UserId, String VideoId){
		String jpql = "select o from Favorite o where o.user.id=:idu and o.video.id=:idv";
		TypedQuery<Favorite> query = em.createQuery(jpql,Favorite.class);
		query.setParameter("idu",UserId);
		query.setParameter("idv",VideoId);
		List<Favorite> list = query.getResultList();
		return list;
	}
	

	public Favorite findOneFavorite(String UserId, String VideoId){
		String jpql = "select o from Favorite o where o.user.id=:idu and o.video.id=:idv";
		TypedQuery<Favorite> query = em.createQuery(jpql,Favorite.class);
		query.setParameter("idu",UserId);
		query.setParameter("idv",VideoId);
		List<Favorite> list = query.getResultList();
		if (list.isEmpty()) {
			return null;
		}else {
			return list.get(0);
		}
//		return query.getSingleResult();
	}
	

	
	public void unlike(Favorite model) {
		em.getTransaction().begin();
		em.remove(model);
		em.getTransaction().commit();
	}
	
//	public static void main(String[] args) {
//		FavoriteDao favoriteDao = new FavoriteDao();
//		String uId ="user1";
//		String vId = "3uYDFO_FRrQ";
//		System.out.println("====================="+favoriteDao.findOneFavorite(uId, vId));
//	}
	
	
	

}
