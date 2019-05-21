package jp.co.jcps.Bean;

import java.io.Serializable;

/**
 * 出席登録画面のBean
 *
 */
public class RegistAttendBean implements Serializable {

	// 講義スケジュールID
	private String lectureScheduleId;

	// 講義名
	private String lectureNm;

	// 次回講義日
	private String  kaisaiDate;

	// 出席コード
	private String attendanceCd;

	// 出席登録可能フラグ
	private boolean registableFlg;

	/**
	 * コンストラクタ
	 *
	 */
	public RegistAttendBean() {
		this.lectureScheduleId = null;
		this.lectureNm = null;
		this.kaisaiDate = null;
		this.attendanceCd = null;
		this.registableFlg = false;
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

	/**
	 * @return registableFlg
	 */
	public boolean isRegistableFlg() {
		return registableFlg;
	}

	/**
	 * @param registableFlg セットする registableFlg
	 */
	public void setRegistableFlg(boolean registableFlg) {
		this.registableFlg = registableFlg;
	}
}
