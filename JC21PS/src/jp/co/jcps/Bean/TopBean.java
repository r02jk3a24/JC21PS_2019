package jp.co.jcps.Bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Top画面のBean
 *
 */
public class TopBean implements Serializable {

	// No
	private String no;

	// 活動ID
	private String activityId;

	// 部活ID
	private String clubId;

	// 活動名
	private String ActivityName;

	// 活動場所
	private String ActivityPlace;

	// 活動時間（自）
	private Date ActivityStartTime;

	// 活動時間（至）
	private Date ActivityEndTime;

	// 活動説明
	private String ActivityDescription;

	// 参加予定人数
	private Integer participantsCount;

	// 参加上限人数
	private Integer maxParticipants;

	/**
	 * コンストラクタ
	 *
	 */
	public TopBean() {
		this.activityId = null;
		this.clubId = null;
		this.ActivityName = null;
		this.ActivityPlace = null;
		this.ActivityStartTime = null;
		this.ActivityEndTime = null;
		this.ActivityDescription = null;
		this.maxParticipants = null;

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
	 * @return activityName
	 */
	public String getActivityName() {
		return ActivityName;
	}

	/**
	 * @param activityName セットする activityName
	 */
	public void setActivityName(String activityName) {
		ActivityName = activityName;
	}

	/**
	 * @return activityPlace
	 */
	public String getActivityPlace() {
		return ActivityPlace;
	}

	/**
	 * @param activityPlace セットする activityPlace
	 */
	public void setActivityPlace(String activityPlace) {
		ActivityPlace = activityPlace;
	}

	/**
	 * @return activityStartTime
	 */
	public Date getActivityStartTime() {
		return ActivityStartTime;
	}

	/**
	 * @param activityStartTime セットする activityStartTime
	 */
	public void setActivityStartTime(Date activityStartTime) {
		ActivityStartTime = activityStartTime;
	}

	/**
	 * @return activityEndTime
	 */
	public Date getActivityEndTime() {
		return ActivityEndTime;
	}

	/**
	 * @param activityEndTime セットする activityEndTime
	 */
	public void setActivityEndTime(Date activityEndTime) {
		ActivityEndTime = activityEndTime;
	}

	/**
	 * @return activityDescription
	 */
	public String getActivityDescription() {
		return ActivityDescription;
	}

	/**
	 * @param activityDescription セットする activityDescription
	 */
	public void setActivityDescription(String activityDescription) {
		ActivityDescription = activityDescription;
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


}
