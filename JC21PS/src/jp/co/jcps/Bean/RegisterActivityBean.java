package jp.co.jcps.Bean;

import java.io.Serializable;

/**
 * 活動登録画面のBean
 *
 */
public class RegisterActivityBean implements Serializable {

	// No
	private String no;

	// 部活名
	private String clubName;

	// 活動名
	private String activityName;

	// 活動場所
	private String activityPlace;

	// 活動日
	private String activityDate;

	// 活動時間(自)
	private String activityStartTime;

	// 活動時間(至)
	private String activityEndTime;

	// 活動説明
	private String activityDescription;

	// 参加上限人数
	private Integer maxParticipants;

	/**
	 * コンストラクタ
	 *
	 */
	public RegisterActivityBean() {
		this.clubName = null;
		this.activityName = null;
		this.activityPlace = null;
		this.activityStartTime = null;
		this.activityEndTime = null;
		this.activityDescription = null;
		this.maxParticipants = null;
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
