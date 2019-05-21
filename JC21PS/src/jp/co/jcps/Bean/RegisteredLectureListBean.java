package jp.co.jcps.Bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 履修講義一覧画面のBean
 *
 */
public class RegisteredLectureListBean implements Serializable {

	// 講義名リスト
	private List<String> lectureNmList;

	// 曜日リスト
	private List<String> youbiList;

	// 時限リスト
	private List<String> periodList;

	// 次回講義日リスト
	private List<String> kaisaiDateList;

	// 担当教員リスト
	private List<String> teacherNmList;

	// 講義スケジュールIDリスト
	private List<String> lectureScheduleIdList;

	/**
	 * コンストラクタ
	 *
	 */
	public RegisteredLectureListBean() {
		this.lectureNmList = new ArrayList<>();
		this.youbiList = new ArrayList<>();
		this.periodList = new ArrayList<>();
		this.kaisaiDateList = new ArrayList<>();
		this.teacherNmList = new ArrayList<>();
		this.lectureScheduleIdList = new ArrayList<>();
	}

	/**
	 * @return lectureNmList
	 */
	public List<String> getLectureNmList() {
		return lectureNmList;
	}

	/**
	 * @param lectureNmList セットする lectureNmList
	 */
	public void setLectureNmList(List<String> lectureNmList) {
		this.lectureNmList = lectureNmList;
	}

	/**
	 * @param lectureNmList に追加する lectureNm
	 */
	public void addLectureNmList(String lectureNm) {
		this.lectureNmList.add(lectureNm);
	}

	/**
	 * @return youbiList
	 */
	public List<String> getYoubiList() {
		return youbiList;
	}

	/**
	 * @param youbiList セットする youbiList
	 */
	public void setYoubiList(List<String> youbiList) {
		this.youbiList = youbiList;
	}

	/**
	 * @param youbiList に追加する youbi
	 */
	public void addYoubiList(String youbi) {
		this.youbiList.add(youbi);
	}

	/**
	 * @return periodList
	 */
	public List<String> getPeriodList() {
		return periodList;
	}

	/**
	 * @param periodList セットする periodList
	 */
	public void setPeriodList(List<String> periodList) {
		this.periodList = periodList;
	}

	/**
	 * @param periodList に追加する period
	 */
	public void addPeriodList(String period) {
		this.periodList.add(period);
	}

	/**
	 * @return kaisaiDateList
	 */
	public List<String> getKaisaiDateList() {
		return kaisaiDateList;
	}

	/**
	 * @param kaisaiDateList セットする kaisaiDateList
	 */
	public void setKaisaiDateList(List<String> kaisaiDateList) {
		this.kaisaiDateList = kaisaiDateList;
	}

	/**
	 * @param kaisaiDateList 追加する kaisaiDate
	 */
	public void addKaisaiDateList(String kaisaiDate) {
		this.kaisaiDateList.add(kaisaiDate);
	}

	/**
	 * @return teacherList
	 */
	public List<String> getTeacherNmList() {
		return teacherNmList;
	}

	/**
	 * @param teacherList セットする teacherList
	 */
	public void setTeacherNmList(List<String> teacherList) {
		this.teacherNmList = teacherList;
	}

	/**
	 * @param teacherList 追加する teacher
	 */
	public void addTeacherNmList(String teacher) {
		this.teacherNmList.add(teacher);
	}

	/**
	 * @return lectureScheduleIdList
	 */
	public List<String> getLectureScheduleIdList() {
		return lectureScheduleIdList;
	}

	/**
	 * @param lectureScheduleIdList セットする lectureScheduleIdList
	 */
	public void setLectureScheduleIdList(List<String> lectureScheduleIdList) {
		this.lectureScheduleIdList = lectureScheduleIdList;
	}

	/**
	 * @param lectureScheduleIdList 追加する lectureScheduleId
	 */
	public void addLectureScheduleIdList(String lectureScheduleId) {
		this.lectureScheduleIdList.add(lectureScheduleId);
	}






}
