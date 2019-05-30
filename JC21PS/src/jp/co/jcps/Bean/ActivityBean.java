package jp.co.jcps.Bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 活動リストのBean
 *
 */
public class ActivityBean implements Serializable {

	// No
	private String no;

	// 部活ID
	private String clubId;

	// 部活名
	private String clubName;

	// 活動ID
	private String activityId;

	// 活動名
	private String activityName;

	// 活動場所
	private String activityPlace;

	// 活動時間（自）
	private Date activityStartTime;

	// 活動時間（至）
	private Date activityEndTime;

	// 活動説明
	private String activityDescription;

	// 参加予定人数
	private Integer participantsCount;

	// 参加上限人数
	private Integer maxParticipants;

	// 参加予定フラグ
	private Boolean isParticipationFlg;

	/**
	 * コンストラクタ
	 *
	 */
	public ActivityBean() {
		this.no = null;
		this.clubId = null;
		this.clubName = null;
		this.activityId = null;
		this.activityName = null;
		this.activityPlace = null;
		this.activityStartTime = null;
		this.activityEndTime = null;
		this.activityDescription = null;
		this.participantsCount = null;
		this.maxParticipants = null;
		this.isParticipationFlg = null;
	}

	/**
	 * @return no
	 */
	public String getNo() {
		return no;
	}

	/**
	 * @param no セットする no
	 */
	public void setNo(String no) {
		this.no = no;
	}

	/**
	 * @return clubId
	 */
	public String getClubId() {
		return clubId;
	}

	/**
	 * @param clubId セットする clubId
	 */
	public void setClubId(String clubId) {
		this.clubId = clubId;
	}

	/**
	 * @return clubName
	 */
	public String getClubName() {
		return clubName;
	}

	/**
	 * @param clubName セットする clubName
	 */
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	/**
	 * @return activityId
	 */
	public String getActivityId() {
		return activityId;
	}

	/**
	 * @param activityId セットする activityId
	 */
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	/**
	 * @return activityName
	 */
	public String getActivityName() {
		return activityName;
	}

	/**
	 * @param activityName セットする activityName
	 */
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	/**
	 * @return activityPlace
	 */
	public String getActivityPlace() {
		return activityPlace;
	}

	/**
	 * @param activityPlace セットする activityPlace
	 */
	public void setActivityPlace(String activityPlace) {
		this.activityPlace = activityPlace;
	}

	/**
	 * @return activityStartTime
	 */
	public Date getActivityStartTime() {
		return activityStartTime;
	}

	/**
	 * @param activityStartTime セットする activityStartTime
	 */
	public void setActivityStartTime(Date activityStartTime) {
		this.activityStartTime = activityStartTime;
	}

	/**
	 * @return activityEndTime
	 */
	public Date getActivityEndTime() {
		return activityEndTime;
	}

	/**
	 * @param activityEndTime セットする activityEndTime
	 */
	public void setActivityEndTime(Date activityEndTime) {
		this.activityEndTime = activityEndTime;
	}

	/**
	 * @return activityDescription
	 */
	public String getActivityDescription() {
		return activityDescription;
	}

	/**
	 * @param activityDescription セットする activityDescription
	 */
	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}

	/**
	 * @return participantsCount
	 */
	public Integer getParticipantsCount() {
		return participantsCount;
	}

	/**
	 * @param participantsCount セットする participantsCount
	 */
	public void setParticipantsCount(Integer participantsCount) {
		this.participantsCount = participantsCount;
	}

	/**
	 * @return maxParticipants
	 */
	public Integer getMaxParticipants() {
		return maxParticipants;
	}

	/**
	 * @param maxParticipants セットする maxParticipants
	 */
	public void setMaxParticipants(Integer maxParticipants) {
		this.maxParticipants = maxParticipants;
	}

	/**
	 * @return isParticipationFlg
	 */
	public Boolean getIsParticipationFlg() {
		return isParticipationFlg;
	}

	/**
	 * @param isParticipationFlg セットする isParticipationFlg
	 */
	public void setIsParticipationFlg(Boolean isParticipationFlg) {
		this.isParticipationFlg = isParticipationFlg;
	}

}
