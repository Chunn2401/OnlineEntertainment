package com.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.poly.utils.JpaUtils;

public abstract class AbstractEmtityDao<T> {
	private Class<T> entityClass;

	public AbstractEmtityDao(Class<T> cls) {
		this.entityClass = cls;
	}

	public int insert(T entity) {
		int i;
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(entity);
			trans.commit();
			i = 1;
//			i = 1 là đúng
		} catch (Exception e) {
			i = 0;
//			i = 0 là sai
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			em.close();
		}
		return i;
	}

	public int update(T entity) {
		int i;
		EntityManager em = JpaUtils.getEntityManager();

		EntityTransaction trans = em.getTransaction();

		try {
			trans.begin();
			em.merge(entity);
			trans.commit();
			i = 1;
		} catch (Exception e) {
			i = 0;
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			em.close();
		}
		return i;
	}

	public int delete(Object id) {
		int i;
		EntityManager em = JpaUtils.getEntityManager();

		EntityTransaction trans = em.getTransaction();

		try {
			trans.begin();
			T entityT = em.find(entityClass, id);
			em.remove(entityT);
			trans.commit();
			i = 1;
		} catch (Exception e) {
			i = 0;
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			em.close();
		}
		return i;
	}

	public T findById(Object id) {
		EntityManager em = JpaUtils.getEntityManager();

		T entity = em.find(entityClass, id);
		return entity;
	}

	public List<T> findAll() {
		EntityManager em = JpaUtils.getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();

			cq.select(cq.from(entityClass));
			return em.createQuery(cq).getResultList();
		} finally {
			em.close();
		}
	}

	public List<T> findAll(boolean all, int firstResult, int maxResult) {
		EntityManager em = JpaUtils.getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(entityClass));
			Query q = em.createQuery(cq);

			if (!all) {
				q.setFirstResult(firstResult);
				q.setMaxResults(maxResult);
			}

			return q.getResultList();
		} finally {
			em.close();
		}
	}

	public Long count() {
		EntityManager em = JpaUtils.getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();

			Root<T> rt = cq.from(entityClass);
			cq.select(em.getCriteriaBuilder().count(rt));
			Query q = em.createQuery(cq);

			return (Long) q.getSingleResult();
		} finally {
			em.close();
		}
	}

}
