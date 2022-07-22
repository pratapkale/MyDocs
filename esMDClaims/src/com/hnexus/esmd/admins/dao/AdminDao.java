/**
 * 
 */
package com.hnexus.esmd.admins.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hnexus.esmd.admins.domain.Admin;
import com.hnexus.esmd.commons.utils.MD5Convertor;

/**
 * @author user
 * 
 */
@Repository
@Transactional
public class AdminDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Admin getAdminById(String adminId) {
		return (Admin) sessionFactory.getCurrentSession().get(Admin.class,
				adminId);
	}

	public Admin loginAuthentication(Admin oAdmin) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Admin.class);
		criteria.setFetchMode("organization", FetchMode.JOIN);
		if (oAdmin != null && oAdmin.getEsmdUserName() != null
				&& oAdmin.getEsmdPassword() != null) {
			criteria.add(Restrictions.eq("esmdUserName", oAdmin.getEsmdUserName()));
			criteria.add(Restrictions.eq("esmdPassword",
					MD5Convertor.MD5(oAdmin.getEsmdPassword())));
		}
		Admin objAdmin = (Admin) criteria.uniqueResult();
		return objAdmin;
	}

	@SuppressWarnings("unchecked")
	public List<Admin> searchAdmins(String esmdUserName) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Admin.class);
		criteria.setFetchMode("organization", FetchMode.JOIN);
		criteria.add(Restrictions.ilike("esmdUserName", "%" + esmdUserName + "%"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Admin> getAllAdmins() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Admin.class);
		criteria.setFetchMode("organization", FetchMode.JOIN);
		return criteria.list();
	}

	public void save(Admin oadmin) {
		sessionFactory.getCurrentSession().save(oadmin);
	}

	public void update(Admin oadmin) {
		sessionFactory.getCurrentSession().saveOrUpdate(oadmin);
	}

	public void delete(String adminId) {
		Admin oAdmin = getAdminById(adminId);
		oAdmin.setEsmdBdelete((byte) 1);
		sessionFactory.getCurrentSession().saveOrUpdate(oAdmin);
	}
}
