package jp.co.jcps.A00;

import java.io.Serializable;

/**
 * 出席登録のBean
 *
 */
public class GenerateAttendanceCdBean implements Serializable {

	// 講義スケジュールID
	private String lectureScheduleId;

	// 講義名
	private String lectureNm;

	// 次回講義日
	private String  kaisaiDate;

	// 出席コード
	private String attendanceCd;

	/**
	 * コンストラクタ
	 *
	 */
	public GenerateAttendanceCdBean() {
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
