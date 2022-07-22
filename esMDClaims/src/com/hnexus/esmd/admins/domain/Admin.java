/**
 * 
 */
package com.hnexus.esmd.admins.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hnexus.esmd.organization.domain.Organization;

/**
 * @author user
 *
 */
@Entity
@Table(name="ESMD_ADMINS")
public class Admin {
	@Id
	@Column(name="esmd_admin_id", length = 50, nullable=false)
	private String esmdAdminId;
	@Column(name="esmd_user_name", length = 50, nullable=false)
	private String esmdUserName;
	@Column(name="esmd_password", length = 100, nullable=false)
	private String esmdPassword;
	@Column(name="esmd_str_password", length = 100, nullable=false)
	private String esmdStrPassword;
	@Column(name="esmd_admin_type", length=4, columnDefinition="tinyint(4) default 2", nullable=false)
	private Byte esmdAdminType;
	@Column(name="esmd_first_name", length = 50, nullable=false)
	private String esmdFirstName;
	@Column(name="esmd_last_name", length = 50, nullable=false)
	private String esmdLastName;
	@Column(name="esmd_middle_name", length = 50, nullable=false)
	private String esmdMiddleName;
	@Column(name="esmd_admin_email", length = 50, nullable=false)
	private String esmdAdminEmail;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "esmd_org_identifier", nullable=false)
	private Organization organization;
	@Column(name="esmd_fax", length = 15, nullable=false)
	private String esmdFax;
	@Column(name="esmd_phone", length = 15, nullable=false)
	private String esmdPhone;
	@Column(name="esmd_bsuperuser", length=4, columnDefinition="tinyint(4) default 0", nullable=false)
	private Byte esmdBsuperuser;
	@Column(name="esmd_bstatus", length=4, columnDefinition="tinyint(4) default 0", nullable=false)
	private Byte esmdBstatus;
	@Column(name="esmd_bdelete", length=4, columnDefinition="tinyint(4) default 0", nullable=false)
	private Byte esmdBdelete;
	@Column(name="esmd_bshowdel", length=4, columnDefinition="tinyint(4) default 1", nullable=false)
	private Byte esmdBshowdel;
	@Column(name="esmd_bnew", length=4, columnDefinition="tinyint(4) default 0", nullable=false)
	private Byte esmdBnew;
	@Column(name="esmd_bpwd_force", length=4, columnDefinition="tinyint(4) default 0", nullable=false)
	private Byte esmdBpwdForce;
	@Column(name="esmd_creation_date", nullable=false)
	private Date esmdCreationDate;
	@Column(name="esmd_update_date", nullable=false)
	private Date esmdUpdateDate;
	
	/**
	 * 
	 */
	public Admin() {
	}

	/**
	 * @param esmdAdminId
	 * @param esmdUserName
	 * @param esmdPassword
	 * @param esmdStrPassword
	 * @param esmdAdminType
	 * @param esmdFirstName
	 * @param esmdLastName
	 * @param esmdMiddleName
	 * @param esmdAdminEmail
	 * @param organization
	 * @param esmdFax
	 * @param esmdPhone
	 * @param esmdBsuperuser
	 * @param esmdBstatus
	 * @param esmdBdelete
	 * @param esmdBshowdel
	 * @param esmdBnew
	 * @param esmdBpwdForce
	 * @param esmdCreationDate
	 * @param esmdUpdateDate
	 */
	public Admin(String esmdAdminId, String esmdUserName, String esmdPassword,
			String esmdStrPassword, Byte esmdAdminType, String esmdFirstName,
			String esmdLastName, String esmdMiddleName, String esmdAdminEmail,
			Organization organization, String esmdFax, String esmdPhone,
			Byte esmdBsuperuser, Byte esmdBstatus, Byte esmdBdelete,
			Byte esmdBshowdel, Byte esmdBnew, Byte esmdBpwdForce,
			Date esmdCreationDate, Date esmdUpdateDate) {
		this.esmdAdminId = esmdAdminId;
		this.esmdUserName = esmdUserName;
		this.esmdPassword = esmdPassword;
		this.esmdStrPassword = esmdStrPassword;
		this.esmdAdminType = esmdAdminType;
		this.esmdFirstName = esmdFirstName;
		this.esmdLastName = esmdLastName;
		this.esmdMiddleName = esmdMiddleName;
		this.esmdAdminEmail = esmdAdminEmail;
		this.organization = organization;
		this.esmdFax = esmdFax;
		this.esmdPhone = esmdPhone;
		this.esmdBsuperuser = esmdBsuperuser;
		this.esmdBstatus = esmdBstatus;
		this.esmdBdelete = esmdBdelete;
		this.esmdBshowdel = esmdBshowdel;
		this.esmdBnew = esmdBnew;
		this.esmdBpwdForce = esmdBpwdForce;
		this.esmdCreationDate = esmdCreationDate;
		this.esmdUpdateDate = esmdUpdateDate;
	}

	/**
	 * @return the esmdAdminId
	 */
	public String getEsmdAdminId() {
		return esmdAdminId;
	}

	/**
	 * @param esmdAdminId the esmdAdminId to set
	 */
	public void setEsmdAdminId(String esmdAdminId) {
		this.esmdAdminId = esmdAdminId;
	}

	/**
	 * @return the esmdUserName
	 */
	public String getEsmdUserName() {
		return esmdUserName;
	}

	/**
	 * @param esmdUserName the esmdUserName to set
	 */
	public void setEsmdUserName(String esmdUserName) {
		this.esmdUserName = esmdUserName;
	}

	/**
	 * @return the esmdPassword
	 */
	public String getEsmdPassword() {
		return esmdPassword;
	}

	/**
	 * @param esmdPassword the esmdPassword to set
	 */
	public void setEsmdPassword(String esmdPassword) {
		this.esmdPassword = esmdPassword;
	}

	/**
	 * @return the esmdStrPassword
	 */
	public String getEsmdStrPassword() {
		return esmdStrPassword;
	}

	/**
	 * @param esmdStrPassword the esmdStrPassword to set
	 */
	public void setEsmdStrPassword(String esmdStrPassword) {
		this.esmdStrPassword = esmdStrPassword;
	}

	/**
	 * @return the esmdAdminType
	 */
	public Byte getEsmdAdminType() {
		return esmdAdminType;
	}

	/**
	 * @param esmdAdminType the esmdAdminType to set
	 */
	public void setEsmdAdminType(Byte esmdAdminType) {
		this.esmdAdminType = esmdAdminType;
	}

	/**
	 * @return the esmdFirstName
	 */
	public String getEsmdFirstName() {
		return esmdFirstName;
	}

	/**
	 * @param esmdFirstName the esmdFirstName to set
	 */
	public void setEsmdFirstName(String esmdFirstName) {
		this.esmdFirstName = esmdFirstName;
	}

	/**
	 * @return the esmdLastName
	 */
	public String getEsmdLastName() {
		return esmdLastName;
	}

	/**
	 * @param esmdLastName the esmdLastName to set
	 */
	public void setEsmdLastName(String esmdLastName) {
		this.esmdLastName = esmdLastName;
	}

	/**
	 * @return the esmdMiddleName
	 */
	public String getEsmdMiddleName() {
		return esmdMiddleName;
	}

	/**
	 * @param esmdMiddleName the esmdMiddleName to set
	 */
	public void setEsmdMiddleName(String esmdMiddleName) {
		this.esmdMiddleName = esmdMiddleName;
	}

	/**
	 * @return the esmdAdminEmail
	 */
	public String getEsmdAdminEmail() {
		return esmdAdminEmail;
	}

	/**
	 * @param esmdAdminEmail the esmdAdminEmail to set
	 */
	public void setEsmdAdminEmail(String esmdAdminEmail) {
		this.esmdAdminEmail = esmdAdminEmail;
	}

	/**
	 * @return the organization
	 */
	public Organization getOrganization() {
		return organization;
	}

	/**
	 * @param organization the organization to set
	 */
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	/**
	 * @return the esmdFax
	 */
	public String getEsmdFax() {
		return esmdFax;
	}

	/**
	 * @param esmdFax the esmdFax to set
	 */
	public void setEsmdFax(String esmdFax) {
		this.esmdFax = esmdFax;
	}

	/**
	 * @return the esmdPhone
	 */
	public String getEsmdPhone() {
		return esmdPhone;
	}

	/**
	 * @param esmdPhone the esmdPhone to set
	 */
	public void setEsmdPhone(String esmdPhone) {
		this.esmdPhone = esmdPhone;
	}

	/**
	 * @return the esmdBsuperuser
	 */
	public Byte getEsmdBsuperuser() {
		return esmdBsuperuser;
	}

	/**
	 * @param esmdBsuperuser the esmdBsuperuser to set
	 */
	public void setEsmdBsuperuser(Byte esmdBsuperuser) {
		this.esmdBsuperuser = esmdBsuperuser;
	}

	/**
	 * @return the esmdBstatus
	 */
	public Byte getEsmdBstatus() {
		return esmdBstatus;
	}

	/**
	 * @param esmdBstatus the esmdBstatus to set
	 */
	public void setEsmdBstatus(Byte esmdBstatus) {
		this.esmdBstatus = esmdBstatus;
	}

	/**
	 * @return the esmdBdelete
	 */
	public Byte getEsmdBdelete() {
		return esmdBdelete;
	}

	/**
	 * @param esmdBdelete the esmdBdelete to set
	 */
	public void setEsmdBdelete(Byte esmdBdelete) {
		this.esmdBdelete = esmdBdelete;
	}

	/**
	 * @return the esmdBshowdel
	 */
	public Byte getEsmdBshowdel() {
		return esmdBshowdel;
	}

	/**
	 * @param esmdBshowdel the esmdBshowdel to set
	 */
	public void setEsmdBshowdel(Byte esmdBshowdel) {
		this.esmdBshowdel = esmdBshowdel;
	}

	/**
	 * @return the esmdBnew
	 */
	public Byte getEsmdBnew() {
		return esmdBnew;
	}

	/**
	 * @param esmdBnew the esmdBnew to set
	 */
	public void setEsmdBnew(Byte esmdBnew) {
		this.esmdBnew = esmdBnew;
	}

	/**
	 * @return the esmdBpwdForce
	 */
	public Byte getEsmdBpwdForce() {
		return esmdBpwdForce;
	}

	/**
	 * @param esmdBpwdForce the esmdBpwdForce to set
	 */
	public void setEsmdBpwdForce(Byte esmdBpwdForce) {
		this.esmdBpwdForce = esmdBpwdForce;
	}

	/**
	 * @return the esmdCreationDate
	 */
	public Date getEsmdCreationDate() {
		return esmdCreationDate;
	}

	/**
	 * @param esmdCreationDate the esmdCreationDate to set
	 */
	public void setEsmdCreationDate(Date esmdCreationDate) {
		this.esmdCreationDate = esmdCreationDate;
	}

	/**
	 * @return the esmdUpdateDate
	 */
	public Date getEsmdUpdateDate() {
		return esmdUpdateDate;
	}

	/**
	 * @param esmdUpdateDate the esmdUpdateDate to set
	 */
	public void setEsmdUpdateDate(Date esmdUpdateDate) {
		this.esmdUpdateDate = esmdUpdateDate;
	}
		
}
