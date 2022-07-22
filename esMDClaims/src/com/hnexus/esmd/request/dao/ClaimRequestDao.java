/**
 * 
 */
package com.hnexus.esmd.request.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hnexus.esmd.request.domain.ClaimRequest;


/**
 * @author user
 *
 */
@Repository
@Transactional
public class ClaimRequestDao {
	@Autowired
	private SessionFactory sessionFactory;

	public ClaimRequest getClaimRequestById(String ClaimRequestId) {
		return (ClaimRequest) sessionFactory.getCurrentSession().get(ClaimRequest.class,
				ClaimRequestId);
	}

	@SuppressWarnings("unchecked")
	public List<ClaimRequest> searchClaimRequests(String esmdLastName) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				ClaimRequest.class);
		criteria.setFetchMode("orgnization", FetchMode.JOIN);
		criteria.setFetchMode("esmdEnteredBy", FetchMode.JOIN);
		criteria.setFetchMode("esmdUpdatedBy", FetchMode.JOIN);
		criteria.add(Restrictions.ilike("esmdLastName", "%" + esmdLastName + "%"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<ClaimRequest> getAllClaimRequests() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				ClaimRequest.class);
		criteria.setFetchMode("orgnization", FetchMode.JOIN);
		criteria.setFetchMode("esmdEnteredBy", FetchMode.JOIN);
		criteria.setFetchMode("esmdUpdatedBy", FetchMode.JOIN);
		criteria.addOrder(Order.desc("esmdCreationDate"));
		return criteria.list();
	}
	@SuppressWarnings("unchecked")
	public List<ClaimRequest> getAllClaimRequests(Integer start, Integer max) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				ClaimRequest.class);
		criteria.setFetchMode("orgnization", FetchMode.JOIN);
		criteria.setFetchMode("esmdEnteredBy", FetchMode.JOIN);
		criteria.setFetchMode("esmdUpdatedBy", FetchMode.JOIN);
		criteria.setFirstResult(start);
		criteria.setMaxResults(max);
		return criteria.list();
	}
	
	public Integer getTotalClaimRequestsCount() {
		Integer recordsCount = 0;
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ClaimRequest.class);
		criteria.setFetchMode("orgnization", FetchMode.JOIN);
		criteria.setFetchMode("esmdEnteredBy", FetchMode.JOIN);
		criteria.setFetchMode("esmdUpdatedBy", FetchMode.JOIN);
		recordsCount = (Integer) criteria.setProjection(Projections.rowCount()).uniqueResult();
		return recordsCount.intValue();
	}
	public void save(ClaimRequest oClaimRequest) {
		sessionFactory.getCurrentSession().saveOrUpdate(oClaimRequest);
	}

	public void update(ClaimRequest oClaimRequest) {
		sessionFactory.getCurrentSession().saveOrUpdate(oClaimRequest);
	}

	public void delete(String ClaimRequestId) {
		ClaimRequest oClaimRequest = getClaimRequestById(ClaimRequestId);
		sessionFactory.getCurrentSession().delete(oClaimRequest);
	}
}