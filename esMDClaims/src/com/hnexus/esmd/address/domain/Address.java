/**
 * 
 */
package com.hnexus.esmd.address.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author user
 *
 */
@Entity
@Table(name="ESMD_ADDRESS")
public class Address {
	@Id
	@Column(name="esmd_address_id", length = 50, nullable=false)
	private String esmdAddressId;
	@Column(name="esmd_street_number", length = 50, nullable=false)
	private String esmdStreetNumber;
	@Column(name="esmd_street_name", length = 50, nullable=false)
	private String esmdStreetName;
	@Column(name="esmd_city", length = 50, nullable=false)
	private String esmdCity;
	@Column(name="esmd_state", length = 50, nullable=false)
	private String esmdState;
	@Column(name="esmd_country", length = 50, nullable=false)
	private String esmdCountry;
	@Column(name="esmd_postal_code", length = 50, nullable=false)
	private String esmdPostalCode;
	@Column(name="esmd_bstatus", length=4, columnDefinition="tinyint(4) default 0", nullable=false)
	private Byte esmdBstatus;
	/**
	 * 
	 */
	public Address() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param esmdAddressId
	 * @param esmdStreetNumber
	 * @param esmdStreetName
	 * @param esmdCity
	 * @param esmdState
	 * @param esmdCountry
	 * @param esmdPostalCode
	 * @param esmdBstatus
	 */
	public Address(String esmdAddressId, String esmdStreetNumber,
			String esmdStreetName, String esmdCity, String esmdState,
			String esmdCountry, String esmdPostalCode, Byte esmdBstatus) {
		this.esmdAddressId = esmdAddressId;
		this.esmdStreetNumber = esmdStreetNumber;
		this.esmdStreetName = esmdStreetName;
		this.esmdCity = esmdCity;
		this.esmdState = esmdState;
		this.esmdCountry = esmdCountry;
		this.esmdPostalCode = esmdPostalCode;
		this.esmdBstatus = esmdBstatus;
	}
	/**
	 * @return the esmdAddressId
	 */
	public String getEsmdAddressId() {
		return esmdAddressId;
	}
	/**
	 * @param esmdAddressId the esmdAddressId to set
	 */
	public void setEsmdAddressId(String esmdAddressId) {
		this.esmdAddressId = esmdAddressId;
	}
	/**
	 * @return the esmdStreetNumber
	 */
	public String getEsmdStreetNumber() {
		return esmdStreetNumber;
	}
	/**
	 * @param esmdStreetNumber the esmdStreetNumber to set
	 */
	public void setEsmdStreetNumber(String esmdStreetNumber) {
		this.esmdStreetNumber = esmdStreetNumber;
	}
	/**
	 * @return the esmdStreetName
	 */
	public String getEsmdStreetName() {
		return esmdStreetName;
	}
	/**
	 * @param esmdStreetName the esmdStreetName to set
	 */
	public void setEsmdStreetName(String esmdStreetName) {
		this.esmdStreetName = esmdStreetName;
	}
	/**
	 * @return the esmdCity
	 */
	public String getEsmdCity() {
		return esmdCity;
	}
	/**
	 * @param esmdCity the esmdCity to set
	 */
	public void setEsmdCity(String esmdCity) {
		this.esmdCity = esmdCity;
	}
	/**
	 * @return the esmdState
	 */
	public String getEsmdState() {
		return esmdState;
	}
	/**
	 * @param esmdState the esmdState to set
	 */
	public void setEsmdState(String esmdState) {
		this.esmdState = esmdState;
	}
	/**
	 * @return the esmdCountry
	 */
	public String getEsmdCountry() {
		return esmdCountry;
	}
	/**
	 * @param esmdCountry the esmdCountry to set
	 */
	public void setEsmdCountry(String esmdCountry) {
		this.esmdCountry = esmdCountry;
	}
	/**
	 * @return the esmdPostalCode
	 */
	public String getEsmdPostalCode() {
		return esmdPostalCode;
	}
	/**
	 * @param esmdPostalCode the esmdPostalCode to set
	 */
	public void setEsmdPostalCode(String esmdPostalCode) {
		this.esmdPostalCode = esmdPostalCode;
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
}
