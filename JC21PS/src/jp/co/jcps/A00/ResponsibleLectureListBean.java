package jp.co.jcps.A00;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 履修講義一覧画面のBean
 *
 */
public class ResponsibleLectureListBean implements Serializable {

	// 講義名リスト
	private List<String> lectureNmList;

	// 曜日リスト
	private List<String> youbiList;

	// 時限リスト
	private List<String> periodList;

	// 次回講義日リスト
	private List<String> nextKaisaiDateList;

	// 出席コードリスト
	private List<String> attendanceCdList;

	// 講義スケジュールIDリスト
	private List<String> lectureScheduleIdList;

	// 講義編集可能フラグリスト
	private List<Boolean> isAbleUpdateFlgList;

	/**
	 * コンストラクタ
	 *
	 */
	public ResponsibleLectureListBean() {
		this.lectureNmList = new ArrayList<>();
		this.youbiList = new ArrayList<>();
		this.periodList = new ArrayList<>();
		this.nextKaisaiDateList = new ArrayList<>();
		this.attendanceCdList = new ArrayList<>();
		this.lectureScheduleIdList = new ArrayList<>();
		this.isAbleUpdateFlgList = new ArrayList<>();

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
	 * @return nextKaisaiDateList
	 */
	public List<String> getNextKaisaiDateList() {
		return nextKaisaiDateList;
	}

	/**
	 * @param nextKaisaiDateList セットする nextKaisaiDateList
	 */
	public void setKaisaiDateList(List<String> nextKaisaiDateList) {
		this.nextKaisaiDateList = nextKaisaiDateList;
	}

	/**
	 * @param nextKaisaiDateList 追加する nextKaisaiDate
	 */
	public void addKaisaiDateList(String nextKaisaiDate) {
		this.nextKaisaiDateList.add(nextKaisaiDate);
	}

	/**
	 * @return attendanceCdList
	 */
	public List<String> getAttendanceCdList() {
		return attendanceCdList;
	}

	/**
	 * @param attendanceCdList セットする attendanceCdList
	 */
	public void setAttendanceCdList(List<String> teacherList) {
		this.attendanceCdList = teacherList;
	}

	/**
	 * @param attendanceCdList 追加する attendanceCd
	 */
	public void addAttendanceCdList(String teacher) {
		this.attendanceCdList.add(teacher);
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
	/**
	 * @return isAbleUpdateFlgList
	 */
	public List<Boolean> getIsAbleUpdateFlgList() {
		return isAbleUpdateFlgList;
	}
	/**
	 * @param isAbleUpdateFlgList セットする isAbleUpdateFlgList
	 */
	public void setIsAbleUpdateFlgList(List<Boolean> isAbleUpdateFlgList) {
		this.isAbleUpdateFlgList = isAbleUpdateFlgList;
	}
	/**
	 * @param isAbleUpdateFlgList 追加する isAbleUpdateFlg
	 */
	public void addIsAbleUpdateFlgList(Boolean isAbleUpdateFlg) {
		this.isAbleUpdateFlgList.add(isAbleUpdateFlg);
	}







}
