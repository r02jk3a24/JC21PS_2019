package jp.co.jcps.A04;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.jcps.Common.CommonCheck;
import jp.co.jcps.Common.DBConnection;
import jp.co.jcps.DisplayBean.ParticipantListBean;

/**
 * 参加者一覧画面のコントローラー
 */
@WebServlet("/ParticipantListController")
public class ParticipantListControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * コンストラクタ
	 */
	public ParticipantListControllerServlet() {
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

		// リクエストパラメーターから活動IDを取得する
		String activityId = request.getParameter("activityId");

		// SQLに埋め込むパラメータリストを定義
		List<String> paramList = new ArrayList<String>();
		paramList.add(activityId);

		// SQLを設定
		String sql = "SELECT activity.*,usr.* FROM trn_activity as activity INNER JOIN trn_participant as participant ON activity.activity_id = participant.activity_id INNER JOIN mst_user as usr ON participant.user_id = usr.user_id WHERE activity.activity_id = ?;";

		// SQLを実行し結果を取得
		DBConnection db = new DBConnection();
		ResultSet rs = db.executeSelectQuery(sql, paramList);

		// 活動登録画面のBeanを初期化
		ParticipantListBean bean = new ParticipantListBean();

		try {
			// beanに部活名をセット
			while(rs.next()) {
				bean.setActivityName(rs.getString("activity_name"));
				bean.addParticipantList(rs.getString("user_name"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new ServletException(e);
		} finally {
			try {
				db.close();
			} catch (Exception e) {
			}
		}

		// beanをリクエストにセット
		request.setAttribute("bean", bean);


		// 履修講義一覧画面を表示
		request.getRequestDispatcher("A04/ParticipantList.jsp").forward(request, response);
	}

}
