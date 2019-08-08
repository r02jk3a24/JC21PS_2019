package jp.co.jcps.A06;

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

/**
 * 部員登録承認のコントローラー
 */
@WebServlet("/JoinApprovalController")
public class JoinApprovalControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * コンストラクタ
	 */
	public JoinApprovalControllerServlet() {
		super();
	}

	/**
	 * GETメソッドでリクエストされた場合の処理
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 共通チェック
		if (!CommonCheck.existSession(request)) {
			// セッションが切れてる場合はログイン画面に遷移
			request.getRequestDispatcher("/Login").forward(request, response);
		}

		// セッションからログイン中のユーザーの部長クラブIDを取得する
		String leaderClubId = (String) request.getSession().getAttribute("leaderClubId");

		// SQLに埋め込むパラメータリストを定義
		List<String> paramList = new ArrayList<String>();
		paramList.add(leaderClubId);

		// SQLを設定
		String sql = "SELECT club.club_name,usr.user_id,usr.user_name FROM trn_join_request as request INNER JOIN mst_user as usr ON usr.user_id = request.user_id INNER JOIN mst_club as club ON request.club_id = club.club_id WHERE request.club_id = ?;";

		// SQLを実行し結果を取得
		DBConnection db = new DBConnection();
		ResultSet rs = db.executeSelectQuery(sql, paramList);

		// 部員登録申請画面に表示するbeanを初期化
		JoinApprovalBean bean = new JoinApprovalBean();

		try {
			// beanにDBから取得した値をセット
			while (rs.next()) {
				bean.setClubName(rs.getString("club_name"));
				bean.addUserIdList(rs.getString("user_id"));
				bean.addUserNameList(rs.getString("user_name"));
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

		// 部活情報登録画面を表示
		request.getRequestDispatcher("A06/JoinApproval.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
