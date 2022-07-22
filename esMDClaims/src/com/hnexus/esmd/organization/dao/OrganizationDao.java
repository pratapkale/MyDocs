/**
 * 
 */
package com.hnexus.esmd.organization.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hnexus.esmd.organization.domain.Organization;

/**
 * @author user
 *
 */
@Repository
@Transactional
public class OrganizationDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Organization getOrganizationById(String OrganizationId) {
		return (Organization) sessionFactory.getCurrentSession().get(Organization.class,
				OrganizationId);
	}

	@SuppressWarnings("unchecked")
	public List<Organization> searchOrganizations(String esmdOrgName) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Organization.class);
		criteria.setFetchMode("esmdOrgAddress", FetchMode.JOIN);
		criteria.add(Restrictions.ilike("esmdOrgName", "%" + esmdOrgName + "%"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Organization> getAllOrganizations() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Organization.class);
		criteria.setFetchMode("esmdOrgAddress", FetchMode.JOIN);
		return criteria.list();
	}

	public void save(Organization oOrganization) {
		sessionFactory.getCurrentSession().save(oOrganization);
	}

	public void update(Organization oOrganization) {
		sessionFactory.getCurrentSession().saveOrUpdate(oOrganization);
	}

	public void delete(String OrganizationId) {
		Organization oOrganization = getOrganizationById(OrganizationId);
		oOrganization.setEsmdOrgStatus((byte)1);
		sessionFactory.getCurrentSession().saveOrUpdate(oOrganization);
	}
}
