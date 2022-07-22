/**
 * 
 */
package com.hnexus.esmd.organization.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.hnexus.esmd.address.domain.Address;

/**
 * @author user
 *
 */
@Entity
@Table(name="ESMD_ORGANIZATION")
public class Organization {
	@Id
	@Column(name="esmd_org_id", length = 50, nullable=false)
	private String esmdOrgId;
	@Column(name="esmd_org_name", length = 50, nullable=false)
	private String esmdOrgName;
	@Column(name="esmd_org_business_phone", length = 15, nullable=false)
	private String esmdOrgBusinessPhone;
	@Column(name="esmd_org_contact", length = 50, nullable=false)
	private String esmdOrgContact;
	@Column(name="esmd_org_fax", length = 15, nullable=false)
	private String esmdOrgFax;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "esmd_org_address", nullable=false)
	private Address esmdOrgAddress;
	@Column(name="esmd_org_sub_domain", length = 80, nullable=false)
	private String esmdOrgSubDomain;
	@Column(name="esmd_org_status", length=4, columnDefinition="tinyint(4) default 0", nullable=false)
	private Byte esmdOrgStatus;
	@Column(name="esmd_org_is_special", length=4, columnDefinition="tinyint(4) default 0", nullable=false)
	private Byte esmdOrgIsSpecial;
	@Column(name="esmd_org_bdeleted", length=4, columnDefinition="tinyint(4) default 0", nullable=false)
	private Byte esmdOrgBdeleted;
	@Column(name="esmd_org_bshowdel", length=4, columnDefinition="tinyint(4) default 1", nullable=false)
	private Byte esmdOrgBshowdel;
	@Column(name="esmd_org_creation_date", nullable=false)
	private Date esmdOrgCreationDate;
	@Column(name="esmd_org_update_date", nullable=false)
	private Date esmdOrgUpdateDate;
	/**
	 * 
	 */
	public Organization() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param esmdOrgId
	 * @param esmdOrgName
	 * @param esmdOrgBusinessPhone
	 * @param esmdOrgContact
	 * @param esmdOrgFax
	 * @param esmdOrgAddress
	 * @param esmdOrgSubDomain
	 * @param esmdOrgStatus
	 * @param esmdOrgIsSpecial
	 * @param esmdOrgBdeleted
	 * @param esmdOrgBshowdel
	 * @param esmdOrgCreationDate
	 * @param esmdOrgUpdateDate
	 */
	public Organization(String esmdOrgId, String esmdOrgName,
			String esmdOrgBusinessPhone, String esmdOrgContact,
			String esmdOrgFax, Address esmdOrgAddress, String esmdOrgSubDomain,
			Byte esmdOrgStatus, Byte esmdOrgIsSpecial,
			Byte esmdOrgBdeleted, Byte esmdOrgBshowdel,
			Date esmdOrgCreationDate, Date esmdOrgUpdateDate) {
		this.esmdOrgId = esmdOrgId;
		this.esmdOrgName = esmdOrgName;
		this.esmdOrgBusinessPhone = esmdOrgBusinessPhone;
		this.esmdOrgContact = esmdOrgContact;
		this.esmdOrgFax = esmdOrgFax;
		this.esmdOrgAddress = esmdOrgAddress;
		this.esmdOrgSubDomain = esmdOrgSubDomain;
		this.esmdOrgStatus = esmdOrgStatus;
		this.esmdOrgIsSpecial = esmdOrgIsSpecial;
		this.esmdOrgBdeleted = esmdOrgBdeleted;
		this.esmdOrgBshowdel = esmdOrgBshowdel;
		this.esmdOrgCreationDate = esmdOrgCreationDate;
		this.esmdOrgUpdateDate = esmdOrgUpdateDate;
	}
	/**
	 * @return the esmdOrgId
	 */
	public String getEsmdOrgId() {
		return esmdOrgId;
	}
	/**
	 * @param esmdOrgId the esmdOrgId to set
	 */
	public void setEsmdOrgId(String esmdOrgId) {
		this.esmdOrgId = esmdOrgId;
	}
	/**
	 * @return the esmdOrgName
	 */
	public String getEsmdOrgName() {
		return esmdOrgName;
	}
	/**
	 * @param esmdOrgName the esmdOrgName to set
	 */
	public void setEsmdOrgName(String esmdOrgName) {
		this.esmdOrgName = esmdOrgName;
	}
	/**
	 * @return the esmdOrgBusinessPhone
	 */
	public String getEsmdOrgBusinessPhone() {
		return esmdOrgBusinessPhone;
	}
	/**
	 * @param esmdOrgBusinessPhone the esmdOrgBusinessPhone to set
	 */
	public void setEsmdOrgBusinessPhone(String esmdOrgBusinessPhone) {
		this.esmdOrgBusinessPhone = esmdOrgBusinessPhone;
	}
	/**
	 * @return the esmdOrgContact
	 */
	public String getEsmdOrgContact() {
		return esmdOrgContact;
	}
	/**
	 * @param esmdOrgContact the esmdOrgContact to set
	 */
	public void setEsmdOrgContact(String esmdOrgContact) {
		this.esmdOrgContact = esmdOrgContact;
	}
	/**
	 * @return the esmdOrgFax
	 */
	public String getEsmdOrgFax() {
		return esmdOrgFax;
	}
	/**
	 * @param esmdOrgFax the esmdOrgFax to set
	 */
	public void setEsmdOrgFax(String esmdOrgFax) {
		this.esmdOrgFax = esmdOrgFax;
	}
	/**
	 * @return the esmdOrgAddress
	 */
	public Address getEsmdOrgAddress() {
		return esmdOrgAddress;
	}
	/**
	 * @param esmdOrgAddress the esmdOrgAddress to set
	 */
	public void setEsmdOrgAddress(Address esmdOrgAddress) {
		this.esmdOrgAddress = esmdOrgAddress;
	}
	/**
	 * @return the esmdOrgSubDomain
	 */
	public String getEsmdOrgSubDomain() {
		return esmdOrgSubDomain;
	}
	/**
	 * @param esmdOrgSubDomain the esmdOrgSubDomain to set
	 */
	public void setEsmdOrgSubDomain(String esmdOrgSubDomain) {
		this.esmdOrgSubDomain = esmdOrgSubDomain;
	}
	/**
	 * @return the esmdOrgStatus
	 */
	public Byte getEsmdOrgStatus() {
		return esmdOrgStatus;
	}
	/**
	 * @param esmdOrgStatus the esmdOrgStatus to set
	 */
	public void setEsmdOrgStatus(Byte esmdOrgStatus) {
		this.esmdOrgStatus = esmdOrgStatus;
	}
	/**
	 * @return the esmdOrgIsSpecial
	 */
	public Byte getEsmdOrgIsSpecial() {
		return esmdOrgIsSpecial;
	}
	/**
	 * @param esmdOrgIsSpecial the esmdOrgIsSpecial to set
	 */
	public void setEsmdOrgIsSpecial(Byte esmdOrgIsSpecial) {
		this.esmdOrgIsSpecial = esmdOrgIsSpecial;
	}
	/**
	 * @return the esmdOrgBdeleted
	 */
	public Byte getEsmdOrgBdeleted() {
		return esmdOrgBdeleted;
	}
	/**
	 * @param esmdOrgBdeleted the esmdOrgBdeleted to set
	 */
	public void setEsmdOrgBdeleted(Byte esmdOrgBdeleted) {
		this.esmdOrgBdeleted = esmdOrgBdeleted;
	}
	/**
	 * @return the esmdOrgBshowdel
	 */
	public Byte getEsmdOrgBshowdel() {
		return esmdOrgBshowdel;
	}
	/**
	 * @param esmdOrgBshowdel the esmdOrgBshowdel to set
	 */
	public void setEsmdOrgBshowdel(Byte esmdOrgBshowdel) {
		this.esmdOrgBshowdel = esmdOrgBshowdel;
	}
	/**
	 * @return the esmdOrgCreationDate
	 */
	public Date getEsmdOrgCreationDate() {
		return esmdOrgCreationDate;
	}
	/**
	 * @param esmdOrgCreationDate the esmdOrgCreationDate to set
	 */
	public void setEsmdOrgCreationDate(Date esmdOrgCreationDate) {
		this.esmdOrgCreationDate = esmdOrgCreationDate;
	}
	/**
	 * @return the esmdOrgUpdateDate
	 */
	public Date getEsmdOrgUpdateDate() {
		return esmdOrgUpdateDate;
	}
	/**
	 * @param esmdOrgUpdateDate the esmdOrgUpdateDate to set
	 */
	public void setEsmdOrgUpdateDate(Date esmdOrgUpdateDate) {
		this.esmdOrgUpdateDate = esmdOrgUpdateDate;
	}
	
}
