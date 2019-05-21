package jp.co.jcps.Common;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;

import jp.co.jcps.Bean.MessageBean;

/**
 * 入力値チェックをするクラス
 *
 */

public class Validation {

	/**
	 * 半角英数かどうかをチェック
	 * @param str チェック対象文字列
	 * @param field 対象フィールド名
	 * @param messageBean
	 * @return messageBean
	 */
	public static MessageBean checkAlphaNumeric(String str, String field, MessageBean messageBean) {
		if(str.length() == 0){
			return messageBean;
		}

		if(str.matches("[0-9a-zA-Z]+")) {
			return messageBean;
		}else {
			messageBean.addMessageList(field + "は半角英数で入力してください。" );
			return messageBean;
		}
	}

	/**
	 * 桁数チェック
	 * maxLength以下であるかをチェック
	 *
	 * @param str チェック対象文字列
	 * @param maxLength 最大文字数
	 * @param field 対象フィールド名
	 * @param messageBean
	 * @return messageBean
	 */
	public static MessageBean checkLegalLengthString(String str, int maxLength, String field, MessageBean messageBean) {
		if(str.length() <= maxLength) {
			return messageBean;
		}else {
			messageBean.addMessageList(field + "は" + maxLength + "文字以下で入力してください。" );
			return messageBean;
		}
	}

	/**
	 * 必須チェック
	 * @param str
	 * @param field
	 * @param messageBean
	 * @return
	 */
	public static MessageBean checkRequired(String str,String field, MessageBean messageBean) {
		if(str.length() != 0) {
			return messageBean;
		}else {
			messageBean.addMessageList(field + "は必須項目です。");
			return messageBean;
		}
	}
	/**
	 * 半角数字チェック
	 * @param num
	 * @param field
	 * @param messageBean
	 * @return
	 */
	public static MessageBean checkNumeric(String num, String field,MessageBean messageBean) {
		// 半角数字の場合はそのまま返却
		if(Pattern.matches("[1-9]?[0-9]+$", num)) {
			return messageBean;
		}
		// 半角数字ではない場合はエラーメッセージを追加して返却
		messageBean.addMessageList(field + "は半角数字で入力してください。");
		return messageBean;
	}

	/**
	 * 数値の範囲チェック
	 * @param num 検査数字
	 * @param min 最小値
	 * @param max 最大値
	 * @param field
	 * @param messageBean
	 * @return
	 */
	public static MessageBean checkCorrectRangeNumber(String num, int min, int max, String field, MessageBean messageBean) {
		try {
			int checkNum = Integer.parseInt(num);
			if(min <= checkNum && checkNum <= max) {
				// 範囲内の数字の場合はそのまま返却
				return messageBean;
			} else {
				// 範囲外の数字の場合はエラーメッセージを追加して返却
				messageBean.addMessageList(field + "は" + min + "以上" + max + "以下で入力してください。");
				return messageBean;
			}
		} catch(NumberFormatException e) {
			// 範囲外の数字の場合はエラーメッセージを追加して返却
			messageBean.addMessageList(field + "は" + min + "以上" + max + "以下で入力してください。");
			return messageBean;
		}
	}

	/**
	 * 存在する日付かどうかチェックする
	 * @param date
	 * @param messageBean
	 * @return
	 */
	public static MessageBean checkCorrectDate(String date, String field, MessageBean messageBean) {
		if (date == null || date.length() != 10) {
			messageBean.addMessageList(field + "が不正です。");
			return messageBean;
		}

		date = date.replace("-", "/");
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		format.setLenient(false);
		try {
			format.parse(date);
			return messageBean;
		} catch (Exception e) {
			messageBean.addMessageList(field + "が不正です。");
			return messageBean;
		}
	}

	/**
	 * 翌日以降かどうかチェックする
	 * @param date
	 * @param field
	 * @param messageBean
	 * @return
	 */
	public static MessageBean checkIsAfterTommorowDate(String date, String field, MessageBean messageBean) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Calendar now = Calendar.getInstance();
		String today = format.format(now.getTime());
		if(date.compareTo(today) > 0) {
			// 日付が翌日以降ならエラーなし
			return messageBean;
		} else {
			// 過去もしくは当日の場合はエラー
			messageBean.addMessageList(field + "は明日以降で入力してください。");
		}
		return messageBean;
	}


	/**
	 * 翌日以降かどうかチェックする
	 * @param date
	 * @param field
	 * @return
	 */
	public static boolean checkIsAfterTommorowDateBool(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Calendar now = Calendar.getInstance();
		String today = format.format(now.getTime());
		if(date.compareTo(today) > 0) {
			// 日付が翌日以降ならエラーなし
			return true;
		} else {
			// 過去もしくは当日の場合はエラー
			return false;
		}
	}

	/**
	 * yyyy/MM/ddの日付かどうかチェックする
	 * @param date
	 * @param field
	 * @param messageBean
	 * @return
	 */
	public static MessageBean checkYYYYMMDDFromatDate(String date, String field, MessageBean messageBean) {
		try {
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			df.format(df.parse(date));
		} catch(ParseException e) {
			// フォーマットできない場合はエラー
			messageBean.addMessageList(field + "はyyyy/MM/dd形式で入力してください。");
		}
		return messageBean;

	}

	/**
	 * 入力された曜日と日付の整合性をチェックする
	 * @param date
	 * @param youbi
	 * @param messageBean
	 * @return
	 */
	public static MessageBean checkDayOfWeek(String date, String youbi, MessageBean messageBean) {
		if(Utils.getDayOfWeek(date) == Integer.parseInt(youbi)) {
			return messageBean;
		}
		messageBean.addMessageList("入力された日付と曜日が異なります。");
		return messageBean;
	}

	/**
	 * 講義データが更新可能かチェックする
	 * @param lectureScheduleId
	 * @return
	 */
	public static boolean isAbleUpdateLecture(String lectureScheduleId) {
		// 講義情報を取得するSQLを定義
		String sql = "SELECT attendance_cd, delete_flg, kaisai_date, sel.lecture_id as selected FROM lecture_schedule_tbl lst LEFT JOIN (SELECT lecture_id FROM selected_lecture_tbl GROUP BY lecture_id) sel ON sel.lecture_id = lst.lecture_id WHERE  lecture_schedule_id = ?;";

		// SQLに埋め込むパラメータリストを定義
		List<String> paramList = new ArrayList<String>();
		paramList.add(lectureScheduleId);

		// SQLを実行し結果を取得
		DBConnection db = new DBConnection();
		ResultSet rs = db.executeSelectQuery(sql, paramList);

		// リストにDBから取得した値をセット
		try {
			while(rs.next()) {
				String attendanceCd = rs.getString("attendance_cd");
				String deleteFlg = rs.getString("delete_flg");
				String kaisaiDate = rs.getString("kaisai_date").replace("-", "/");
				String selected = rs.getString("selected");

				// 出席コードが登録されている、削除フラグが1、履修登録されているのどれかに該当する場合はFalseを返却
				if(attendanceCd != null || deleteFlg.equals("1") || selected != null) {
					return false;
				}

				// 講義日が当日以前の場合はFalseを返却
				return checkIsAfterTommorowDateBool(kaisaiDate);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				db.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return true;
	}

}
