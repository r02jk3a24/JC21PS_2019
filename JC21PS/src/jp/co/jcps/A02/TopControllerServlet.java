package jp.co.jcps.A02;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import jp.co.jcps.Bean.ActivityBean;
import jp.co.jcps.Bean.TopBean;
import jp.co.jcps.Common.CommonCheck;

/**
 * トップ画面のコントローラ
 */
@WebServlet("/TopControllerServlet")
public class TopControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * コンストラクタ
	 */
	public TopControllerServlet() {
		super();
	}

	/**
	 * GETメソッドでリクエストされた場合の処理
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 共通チェック
		if(!CommonCheck.existSession(request)) {
			// セッションが切れてる場合はログイン画面に遷移
			request.getRequestDispatcher("/Login").forward(request, response);
		}

		// セッションからログイン中の学生の学生IDを取得する
		String userId = (String) request.getSession().getAttribute("userId");

		// DB接続
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 比較用の部活ID
		String tmpClubId = null;
		// Whileの実行回数
		int exeCount = 0;
		// 部活のリストを初期化
		List<List<ActivityBean>> clubList = new ArrayList<>();
		// 活動のリストを初期化
		List<ActivityBean> activityList = new ArrayList<>();
		// トップ画面用のbean
		TopBean bean = new TopBean();

		try {
			// データソースの取得
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/jc21ps");

			// データベースへ接続
			con = ds.getConnection();

			String sql = "SELECT activity.*,club.club_id,club.club_name,count.count,isnull(participant.user_id) != 1 as participation_flg FROM trn_activity as activity INNER JOIN mst_club as club USING(club_id) INNER JOIN trn_club_member as member ON club.club_id = member.club_id LEFT JOIN (SELECT activity_id,count(*) as count FROM trn_participant GROUP BY activity_id) as count ON count.activity_id = activity.activity_id LEFT JOIN trn_participant as participant ON participant.user_id = ? AND participant.activity_id = activity.activity_id WHERE member.user_id = ? ORDER BY club.club_id ASC,activity.activity_start_time ASC;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userId);
			rs = pstmt.executeQuery();

			// リストにDBから取得した値をセット
			while(rs.next()) {
				ActivityBean activity = new ActivityBean();

				if(exeCount == 0) {
					// 初回は必ず退避
					tmpClubId = rs.getString("club_id");
					bean.addClubNameList(rs.getString("club_name"));
				}else if (!tmpClubId.equals(rs.getString("club_id"))) {
					// 以降はclub_idが変わったときだけ更新
					tmpClubId = rs.getString("club_id");

					bean.addClubNameList(rs.getString("club_name"));
					// 部活リストに活動リストを追加し、活動リストを初期化
					clubList.add(activityList);
					activityList = new ArrayList<>();
				}

				// DB取得結果をBeanに詰め替える
				activity.setClubId(rs.getString("club_id"));
				activity.setClubName(rs.getString("club_name"));
				activity.setActivityId(rs.getString("activity_id"));
				activity.setActivityName(rs.getString("activity_name"));
				activity.setActivityPlace(rs.getString("activity_place"));
				// TODO 時刻の編集を考える
				//
				//
				activity.setActivityDescription(rs.getString("activity_description"));
				activity.setParticipantsCount(rs.getInt("count"));
				activity.setMaxParticipants(rs.getInt("max_participants"));
				activity.setIsParticipationFlg(rs.getBoolean("participation_flg"));

				// 活動リストに活動を追加
				activityList.add(activity);

				// 実行回数をインクリメント
				exeCount++;
			}
			// 最後の活動リストを部活リストに追加
			if(activityList.size() != 0) {
				clubList.add(activityList);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new ServletException(e);
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
			}
		}

		// トップ画面のBeanにリストをセットし、リクエストにセット
		bean.setClubActivityList(clubList);
		request.setAttribute("bean", bean);


		// 履修講義一覧画面を表示
		request.getRequestDispatcher("A02/Top.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
