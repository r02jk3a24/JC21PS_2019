package jp.co.jcps.Bean;

import java.io.Serializable;

/**
 * Top画面のBean
 *
 */
public class TrnActivityBean implements Serializable {

	// 活動ID
	private String activityId;

	// 部活ID
	private String clubId;

	// 活動名
	private String ActivityName;

	// 活動場所
	private String ActivityPlace;
	
	// 活動時間（自）
	private 

	/**
	 * コンストラクタ
	 *
	 */
	public TrnActivityBean() {
		this.lectureScheduleId = null;
		this.lectureNm = null;
		this.kaisaiDate = null;
		this.attendanceCd = null;
	}

	/**
	 * @return lectureScheduleId
	 */
	public String getLectureScheduleId() {
		return lectureScheduleId;
	}

	/**
	 * @param lectureScheduleId セットする lectureScheduleId
	 */
	public void setLectureScheduleId(String lectureScheduleId) {
		this.lectureScheduleId = lectureScheduleId;
	}

	/**
	 * @return lectureNm
	 */
	public String getLectureNm() {
		return lectureNm;
	}

	/**
	 * @param lectureNm セットする lectureNm
	 */
	public void setLectureNm(String lectureNm) {
		this.lectureNm = lectureNm;
	}

	/**
	 * @return kaisaiDate
	 */
	public String getKaisaiDate() {
		return kaisaiDate;
	}

	/**
	 * @param kaisaiDate セットする kaisaiDate
	 */
	public void setKaisaiDate(String kaisaiDate) {
		this.kaisaiDate = kaisaiDate;
	}

	/**
	 * @return registableFlg
	 */
	public String getAttendanceCd() {
		return attendanceCd;
	}

	/**
	 * @param registableFlg セットする attendCd
	 */
	public void setAttendanceCd(String attendCd) {
		this.attendanceCd = attendCd;
	}
}
