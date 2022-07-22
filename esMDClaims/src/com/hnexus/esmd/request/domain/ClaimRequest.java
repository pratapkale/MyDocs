/**
 * 
 */
package com.hnexus.esmd.request.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.hnexus.esmd.admins.domain.Admin;
import com.hnexus.esmd.organization.domain.Organization;

/**
 * @author user
 *
 */
@Entity
@Table(name="ESMD_REQUEST")
public class ClaimRequest {
	@Id
	@Column(name="esmd_request_id", length = 50, nullable=false)
	private String esmdRequestId;
	@Column(name="esmd_family_name", length = 50, nullable=false)
	private String esmdFamilyName;
	@Column(name="esmd_given_name", length = 50, nullable=false)
	private String esmdGivenName;
	@Column(name="esmd_secondName_or_initials", length = 50, nullable=false)
	private String esmdSecondNameOrInitials;
	@Column(name="esmd_full_name", length = 50, nullable=false)
	private String esmdFullName;
	@Column(name="esmd_user_name", length = 50, nullable=false)
	private String esmdUserName;
	@Column(name="esmd_description", length = 255, nullable=false)
	private String esmdDescription;
	@Column(name="esmd_target_community", length = 50, nullable=false)
	private String esmdTargetCommunity;
	@Column(name="esmd_claim_id", length = 76, nullable=false)
	private String esmdClaimId;
	@Column(name="esmd_case_id", length = 76, nullable=false)
	private String esmdCaseId;
	@Column(name="esmd_intended_recipient", length = 64, nullable=false)
	private String esmdIntendedRecipient;
	@Column(name="esmd_esmd_author", length = 10, nullable=false)
	private String esmdAuthor;
	@Column(name="esmd_author_institution", length = 10, nullable=true)
	private String esmdAuthorInstitution;
	@Column(name="esmd_author_person", length = 10, nullable=true)
	private String esmdAuthorPerson;
	@Column(name="esmd_content_type_code", length = 16, nullable=false)
	private String esmdContentTypeCode;
	@Column(name="esmd_entry_uuid", length = 64, nullable=false)
	private String esmdEntryUuid;
	@Column(name="esmd_source_id", length = 64, nullable=false)
	private String esmdSourceId;
	@Column(name="esmd_document_title", length = 256, nullable=false)
	private String esmdDocumentTitle;
	@Column(name="esmd_patient_id", length = 256, nullable=false)
	private String esmdPatientId;
	@Column(name="esmd_creation_time", length = 14, nullable=false)
	private String esmdCreationTime;
	@Column(name="esmd_service_start_time", length = 14, nullable=false)
	private String esmdServiceStartTime;
	@Column(name="esmd_service_stop_time", length = 14, nullable=false)
	private String esmdServiceStopTime;
	@Column(name="esmd_submission_time", length = 14, nullable=false)
	private String esmdSubmissionTime;
	@Column(name="esmd_unique_id", length = 128, nullable=false)
	private String esmdUniqueId;
	@Column(name="esmd_confidentiality_code", length = 64, nullable=false)
	private String esmdConfidentialityCode;
	@Column(name="esmd_class_code", length = 64, nullable=false)
	private String esmdClassCode;
	@Column(name="esmd_format_code", length = 64, nullable=false)
	private String esmdFormatCode;
	@Column(name="esmd_healthcare_facility_type", length = 64, nullable=false)
	private String esmdHealthcareFacilityType;
	@Column(name="esmd_submission_set", length = 32, nullable=false)
	private String esmdSubmissionSet;
	//@Column(name="esmd_upload_document", nullable=true)
	//private byte[] esmdUploadDocument;
	@Column(name="esmd_upload_document", nullable=true)
	private CommonsMultipartFile esmdUploadDocument;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "esmd_org_id", nullable=false)
	private Organization orgnization;
	//@Column(name="esmd_entered_by", length = 50, nullable=false)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "esmd_entered_by", nullable=false)
	private Admin esmdEnteredBy;
	//@Column(name="esmd_updated_by", length = 50, nullable=false)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "esmd_updated_by", nullable=false)
	private Admin esmdUpdatedBy;
	@Column(name="esmd_creation_date", nullable=false)
	private Date esmdCreationDate;
	@Column(name="esmd_update_date", nullable=false)
	private Date esmdUpdateDate;
	@Column(name="esmd_uploaded_file_path", nullable=true)
	private String fileName;
	/**
	 * 
	 */
	public ClaimRequest() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the esmdRequestId
	 */
	public String getEsmdRequestId() {
		return esmdRequestId;
	}
	/**
	 * @param esmdRequestId the esmdRequestId to set
	 */
	public void setEsmdRequestId(String esmdRequestId) {
		this.esmdRequestId = esmdRequestId;
	}
	/**
	 * @return the esmdFamilyName
	 */
	public String getEsmdFamilyName() {
		return esmdFamilyName;
	}
	/**
	 * @param esmdFamilyName the esmdFamilyName to set
	 */
	public void setEsmdFamilyName(String esmdFamilyName) {
		this.esmdFamilyName = esmdFamilyName;
	}
	/**
	 * @return the esmdGivenName
	 */
	public String getEsmdGivenName() {
		return esmdGivenName;
	}
	/**
	 * @param esmdGivenName the esmdGivenName to set
	 */
	public void setEsmdGivenName(String esmdGivenName) {
		this.esmdGivenName = esmdGivenName;
	}
	/**
	 * @return the esmdSecondNameOrInitials
	 */
	public String getEsmdSecondNameOrInitials() {
		return esmdSecondNameOrInitials;
	}
	/**
	 * @param esmdSecondNameOrInitials the esmdSecondNameOrInitials to set
	 */
	public void setEsmdSecondNameOrInitials(String esmdSecondNameOrInitials) {
		this.esmdSecondNameOrInitials = esmdSecondNameOrInitials;
	}
	/**
	 * @return the esmdFullName
	 */
	public String getEsmdFullName() {
		return esmdFullName;
	}
	/**
	 * @param esmdFullName the esmdFullName to set
	 */
	public void setEsmdFullName(String esmdFullName) {
		this.esmdFullName = esmdFullName;
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
	 * @return the esmdDescription
	 */
	public String getEsmdDescription() {
		return esmdDescription;
	}
	/**
	 * @param esmdDescription the esmdDescription to set
	 */
	public void setEsmdDescription(String esmdDescription) {
		this.esmdDescription = esmdDescription;
	}
	/**
	 * @return the esmdTargetCommunity
	 */
	public String getEsmdTargetCommunity() {
		return esmdTargetCommunity;
	}
	/**
	 * @param esmdTargetCommunity the esmdTargetCommunity to set
	 */
	public void setEsmdTargetCommunity(String esmdTargetCommunity) {
		this.esmdTargetCommunity = esmdTargetCommunity;
	}
	/**
	 * @return the esmdClaimId
	 */
	public String getEsmdClaimId() {
		return esmdClaimId;
	}
	/**
	 * @param esmdClaimId the esmdClaimId to set
	 */
	public void setEsmdClaimId(String esmdClaimId) {
		this.esmdClaimId = esmdClaimId;
	}
	/**
	 * @return the esmdCaseId
	 */
	public String getEsmdCaseId() {
		return esmdCaseId;
	}
	/**
	 * @param esmdCaseId the esmdCaseId to set
	 */
	public void setEsmdCaseId(String esmdCaseId) {
		this.esmdCaseId = esmdCaseId;
	}
	/**
	 * @return the esmdIntendedRecipient
	 */
	public String getEsmdIntendedRecipient() {
		return esmdIntendedRecipient;
	}
	/**
	 * @param esmdIntendedRecipient the esmdIntendedRecipient to set
	 */
	public void setEsmdIntendedRecipient(String esmdIntendedRecipient) {
		this.esmdIntendedRecipient = esmdIntendedRecipient;
	}
	/**
	 * @return the esmdEsmdAuthor
	 */
	public String getEsmdAuthor() {
		return esmdAuthor;
	}
	/**
	 * @param esmdEsmdAuthor the esmdEsmdAuthor to set
	 */
	public void setEsmdAuthor(String esmdAuthor) {
		this.esmdAuthor = esmdAuthor;
	}
	/**
	 * @return the esmdAuthorInstitution
	 */
	public String getEsmdAuthorInstitution() {
		return esmdAuthorInstitution;
	}
	/**
	 * @param esmdAuthorInstitution the esmdAuthorInstitution to set
	 */
	public void setEsmdAuthorInstitution(String esmdAuthorInstitution) {
		this.esmdAuthorInstitution = esmdAuthorInstitution;
	}
	/**
	 * @return the esmdAuthorPerson
	 */
	public String getEsmdAuthorPerson() {
		return esmdAuthorPerson;
	}
	/**
	 * @param esmdAuthorPerson the esmdAuthorPerson to set
	 */
	public void setEsmdAuthorPerson(String esmdAuthorPerson) {
		this.esmdAuthorPerson = esmdAuthorPerson;
	}
	/**
	 * @return the esmdContentTypeCode
	 */
	public String getEsmdContentTypeCode() {
		return esmdContentTypeCode;
	}
	/**
	 * @param esmdContentTypeCode the esmdContentTypeCode to set
	 */
	public void setEsmdContentTypeCode(String esmdContentTypeCode) {
		this.esmdContentTypeCode = esmdContentTypeCode;
	}
	/**
	 * @return the esmdEntryUuid
	 */
	public String getEsmdEntryUuid() {
		return esmdEntryUuid;
	}
	/**
	 * @param esmdEntryUuid the esmdEntryUuid to set
	 */
	public void setEsmdEntryUuid(String esmdEntryUuid) {
		this.esmdEntryUuid = esmdEntryUuid;
	}
	/**
	 * @return the esmdSourceId
	 */
	public String getEsmdSourceId() {
		return esmdSourceId;
	}
	/**
	 * @param esmdSourceId the esmdSourceId to set
	 */
	public void setEsmdSourceId(String esmdSourceId) {
		this.esmdSourceId = esmdSourceId;
	}
	/**
	 * @return the esmdDocumentTitle
	 */
	public String getEsmdDocumentTitle() {
		return esmdDocumentTitle;
	}
	/**
	 * @param esmdDocumentTitle the esmdDocumentTitle to set
	 */
	public void setEsmdDocumentTitle(String esmdDocumentTitle) {
		this.esmdDocumentTitle = esmdDocumentTitle;
	}
	/**
	 * @return the esmdPatientId
	 */
	public String getEsmdPatientId() {
		return esmdPatientId;
	}
	/**
	 * @param esmdPatientId the esmdPatientId to set
	 */
	public void setEsmdPatientId(String esmdPatientId) {
		this.esmdPatientId = esmdPatientId;
	}
	/**
	 * @return the esmdCreationTime
	 */
	public String getEsmdCreationTime() {
		return esmdCreationTime;
	}
	/**
	 * @param esmdCreationTime the esmdCreationTime to set
	 */
	public void setEsmdCreationTime(String esmdCreationTime) {
		this.esmdCreationTime = esmdCreationTime;
	}
	/**
	 * @return the esmdServiceStartTime
	 */
	public String getEsmdServiceStartTime() {
		return esmdServiceStartTime;
	}
	/**
	 * @param esmdServiceStartTime the esmdServiceStartTime to set
	 */
	public void setEsmdServiceStartTime(String esmdServiceStartTime) {
		this.esmdServiceStartTime = esmdServiceStartTime;
	}
	/**
	 * @return the esmdServiceStopTime
	 */
	public String getEsmdServiceStopTime() {
		return esmdServiceStopTime;
	}
	/**
	 * @param esmdServiceStopTime the esmdServiceStopTime to set
	 */
	public void setEsmdServiceStopTime(String esmdServiceStopTime) {
		this.esmdServiceStopTime = esmdServiceStopTime;
	}
	/**
	 * @return the esmdSubmissionTime
	 */
	public String getEsmdSubmissionTime() {
		return esmdSubmissionTime;
	}
	/**
	 * @param esmdSubmissionTime the esmdSubmissionTime to set
	 */
	public void setEsmdSubmissionTime(String esmdSubmissionTime) {
		this.esmdSubmissionTime = esmdSubmissionTime;
	}
	/**
	 * @return the esmdUniqueId
	 */
	public String getEsmdUniqueId() {
		return esmdUniqueId;
	}
	/**
	 * @param esmdUniqueId the esmdUniqueId to set
	 */
	public void setEsmdUniqueId(String esmdUniqueId) {
		this.esmdUniqueId = esmdUniqueId;
	}
	/**
	 * @return the esmdConfidentialityCode
	 */
	public String getEsmdConfidentialityCode() {
		return esmdConfidentialityCode;
	}
	/**
	 * @param esmdConfidentialityCode the esmdConfidentialityCode to set
	 */
	public void setEsmdConfidentialityCode(String esmdConfidentialityCode) {
		this.esmdConfidentialityCode = esmdConfidentialityCode;
	}
	/**
	 * @return the esmdClassCode
	 */
	public String getEsmdClassCode() {
		return esmdClassCode;
	}
	/**
	 * @param esmdClassCode the esmdClassCode to set
	 */
	public void setEsmdClassCode(String esmdClassCode) {
		this.esmdClassCode = esmdClassCode;
	}
	/**
	 * @return the esmdFormatCode
	 */
	public String getEsmdFormatCode() {
		return esmdFormatCode;
	}
	/**
	 * @param esmdFormatCode the esmdFormatCode to set
	 */
	public void setEsmdFormatCode(String esmdFormatCode) {
		this.esmdFormatCode = esmdFormatCode;
	}
	/**
	 * @return the esmdHealthcareFacilityType
	 */
	public String getEsmdHealthcareFacilityType() {
		return esmdHealthcareFacilityType;
	}
	/**
	 * @param esmdHealthcareFacilityType the esmdHealthcareFacilityType to set
	 */
	public void setEsmdHealthcareFacilityType(String esmdHealthcareFacilityType) {
		this.esmdHealthcareFacilityType = esmdHealthcareFacilityType;
	}
	/**
	 * @return the esmdSubmissionSet
	 */
	public String getEsmdSubmissionSet() {
		return esmdSubmissionSet;
	}
	/**
	 * @param esmdSubmissionSet the esmdSubmissionSet to set
	 */
	public void setEsmdSubmissionSet(String esmdSubmissionSet) {
		this.esmdSubmissionSet = esmdSubmissionSet;
	}
	/**
	 * @return the esmdUploadDocument
	 */
	public CommonsMultipartFile getEsmdUploadDocument() {
		return esmdUploadDocument;
	}
	/**
	 * @param esmdUploadDocument the esmdUploadDocument to set
	 */
	public void setEsmdUploadDocument(CommonsMultipartFile esmdUploadDocument) {
		this.esmdUploadDocument = esmdUploadDocument;
	}
	
	/**
	 * @return the esmdEnteredBy
	 */
	public Admin getEsmdEnteredBy() {
		return esmdEnteredBy;
	}
	/**
	 * @param esmdEnteredBy the esmdEnteredBy to set
	 */
	public void setEsmdEnteredBy(Admin esmdEnteredBy) {
		this.esmdEnteredBy = esmdEnteredBy;
	}
	/**
	 * @return the esmdUpdatedBy
	 */
	public Admin getEsmdUpdatedBy() {
		return esmdUpdatedBy;
	}
	/**
	 * @param esmdUpdatedBy the esmdUpdatedBy to set
	 */
	public void setEsmdUpdatedBy(Admin esmdUpdatedBy) {
		this.esmdUpdatedBy = esmdUpdatedBy;
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
	/**
	 * @return the filename
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @param filename the filename to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the orgnization
	 */
	public Organization getOrgnization() {
		return orgnization;
	}

	/**
	 * @param orgnization the orgnization to set
	 */
	public void setOrgnization(Organization orgnization) {
		this.orgnization = orgnization;
	}

}
