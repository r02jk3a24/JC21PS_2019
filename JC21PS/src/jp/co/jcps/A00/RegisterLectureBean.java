package jp.co.jcps.A00;

import java.io.Serializable;

/**
 * 講義登録画面のBean
 *
 */
public class RegisterLectureBean implements Serializable {

	// 講義ID
	private String lectureId;

	// 講義スケジュールID
	private String lectureScheduleId;

	// 講義名
	private String lectureNm;

	// 曜日
	private String youbi;

	// 時限
	private String period;

	// 次回講義日
	private String kaisaiDate;

	// 講義回数
	private String lectureTimes;

	// 教員ID
	private String teacherId;

	// 学部ID
	private String departmentId;

	// 更新モード
	private String mode;

	/**
	 * コンストラクタ
	 *
	 */
	public RegisterLectureBean() {
		this.lectureId = "";
		this.lectureScheduleId = "";
		this.lectureNm = "";
		this.youbi = "";
		this.period = "";
		this.kaisaiDate = "";
		this.lectureTimes = "";
		this.teacherId = "";
		this.departmentId = "";
		this.mode = "";
	}

	/**
	 * @return lectureId
	 */
	public String getLectureId() {
		return lectureId;
	}

	/**
	 * @param lectureId セットする lectureId
	 */
	public void setLectureId(String lectureId) {
		this.lectureId = lectureId;
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
	 * @return youbi
	 */
	public String getYoubi() {
		return youbi;
	}

	/**
	 * @param youbi セットする youbi
	 */
	public void setYoubi(String youbi) {
		this.youbi = youbi;
	}

	/**
	 * @return period
	 */
	public String getPeriod() {
		return period;
	}

	/**
	 * @param period セットする period
	 */
	public void setPeriod(String period) {
		this.period = period;
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
	 * @return lectureTimes
	 */
	public String getLectureTimes() {
		return lectureTimes;
	}

	/**
	 * @param lectureTimes セットする lectureTimes
	 */
	public void setLectureTimes(String lectureTimes) {
		this.lectureTimes = lectureTimes;
	}

	/**
	 * @return teacherId
	 */
	public String getTeacherId() {
		return teacherId;
	}

	/**
	 * @param teacherId セットする teacherId
	 */
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	/**
	 * @return departmentId
	 */
	public String getDepartmentId() {
		return departmentId;
	}

	/**
	 * @param departmentId セットする departmentId
	 */
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * @return mode
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * @param mode セットする mode
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}



}
